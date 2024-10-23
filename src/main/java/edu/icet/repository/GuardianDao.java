package edu.icet.repository;

import edu.icet.entity.GuardianEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface GuardianDao extends JpaRepository<GuardianEntity,String> {
    Optional<GuardianEntity> findById(String guardianNIC);
}
