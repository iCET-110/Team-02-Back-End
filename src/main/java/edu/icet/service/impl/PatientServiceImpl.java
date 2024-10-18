package edu.icet.service.impl;

import edu.icet.dto.Patient;
import edu.icet.repository.PatientDao;
import edu.icet.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientDao patientDao;

    @Override
    public void addStudent(Patient patient) {
        patientDao.save(patient);
    }
}
