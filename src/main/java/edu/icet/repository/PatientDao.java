package edu.icet.repository;

import edu.icet.dto.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PatientDao extends JpaRepository <Patient,String>{
    List<Patient> findByName(String name);
    Patient findByNic(String nic);
    Patient findByid(String id);
}
