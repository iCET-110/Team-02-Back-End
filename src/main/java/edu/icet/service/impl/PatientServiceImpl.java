package edu.icet.service.impl;

import edu.icet.dto.Patient;
import edu.icet.repository.PatientDao;
import edu.icet.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    final PatientDao patientDao;

    @Override
    public List<Patient> getByName(String name) {
        List<Patient> patientList = patientDao.findByName(name);
        return patientList;
    }
    @Override
    public Patient findById(String id) {
        return patientDao.findByid(id);
    }

    @Override
    public Patient getByNic(String nic) {
        return patientDao.findByNic(nic);
    }

    @Override
    public List<Patient> getPatients() {
        return patientDao.findAll();
    }
    
    @Override
    public void updatePatient(Patient patient) {
        patientDao.save(patient);
    }
}
