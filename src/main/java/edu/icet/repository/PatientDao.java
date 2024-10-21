package edu.icet.repository;

import edu.icet.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDao extends JpaRepository <PatientEntity,Long>{

}
