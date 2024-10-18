package edu.icet.repository;

import edu.icet.dto.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDao extends JpaRepository<Patient,String> {
}
