package edu.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Patient;
import edu.icet.entity.PatientEntity;
import edu.icet.repository.PatientDao;
import edu.icet.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {

    final PatientDao patientDao;
    final ObjectMapper objectMapper;

    @Override
    public boolean addPatient(Patient patient) {
        try {
            patientDao.save(objectMapper.convertValue(patient,PatientEntity.class));
            return true;
        } catch (Exception e) {
            log.error("Error saving patient to the database: ", e);
            return false;
        }
    }



    @Override
    public List<Patient> getByName(String name) {
        List<Patient> patientList = new ArrayList<>();
        patientDao.findByFirstName(name).forEach(patientEntity -> {
            patientList.add(objectMapper.convertValue(patientEntity, Patient.class));
        });
        return patientList;
    }
    @Override
    public Patient findById(Long id) {
        return patientDao.findById(id)
                .map(entity -> objectMapper.convertValue(entity, Patient.class))
                .orElse(null);
    }

    @Override
    public Patient getByNic(String nic) {
        return objectMapper.convertValue(patientDao.findByNic(nic), Patient.class);
    }

    @Override
    public List<Patient> getPatients() {
        ArrayList<Patient> patientArrayList = new ArrayList<>();
        patientDao.findAll().forEach(entity->{
            patientArrayList.add(objectMapper.convertValue(entity, Patient.class));
        });
        return patientArrayList;
    }

    @Override
    public boolean updatePatient(Patient patient) {
        try {
            patientDao.save(objectMapper.convertValue(patient,PatientEntity.class));
            return true;
        } catch (Exception e) {
            log.error("Error updating patient: ", e);
            return false;
        }
    }

    @Override
    public void deletPatient(Long id) {
        patientDao.deleteById(id);  // Implementation of delete by ID
    }

    @Override
    public void deleteAll() {
        patientDao.deleteAll();  // Implementation of delete all patients
    }
}