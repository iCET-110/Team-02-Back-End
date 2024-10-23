package edu.icet.repository;

import edu.icet.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientDao extends JpaRepository <PatientEntity,Long>{
    List<PatientEntity> findByFirstName(String firstName);
    PatientEntity findByNic(String nic);
}
