package edu.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Patient;
import edu.icet.entity.PatientEntity;
import edu.icet.repository.PatientDao;
import edu.icet.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    final PatientDao patientDao;
    final ObjectMapper objectMapper;

    @Override
    public void addPatient(Patient patient) {
        patientDao.save(objectMapper.convertValue(patient, PatientEntity.class));
    }
    public List<Patient> getByName(String name) {
        List<Patient> patientList = new ArrayList<>();
        patientDao.findByFirstName(name).forEach(patientEntity -> {
            patientList.add(objectMapper.convertValue(patientEntity, Patient.class));
        });
        return patientList;
    }
    @Override
    public Patient findById(Long id) {
        return objectMapper.convertValue(patientDao.findById(id), Patient.class);
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
    public void updatePatient(Patient patient) {
        patientDao.save(objectMapper.convertValue(patient, PatientEntity.class));
    }
}
