package edu.icet.service;

import edu.icet.dto.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getByName(String name);

    Patient findById(Long id);

    Patient getByNic(String nic);

    List<Patient> getPatients();

    void updatePatient(Patient patient);

    void addPatient(Patient patient);

    void deletPatient(Long id);

    void deleteAll();
}
