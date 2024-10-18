package edu.icet.service;

import edu.icet.dto.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getByName(String name);
    Patient findById(String id);
    Patient getByNic(String nic);
    List<Patient> getPatients();

}
