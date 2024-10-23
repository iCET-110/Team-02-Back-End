package edu.icet.repository;

import edu.icet.entity.GuardianEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface GuardianDao extends JpaRepository<GuardianEntity,String> {
    List<GuardianEntity> findByGuardianName(String name);

    GuardianEntity findByGuardianContact(String contact);

}
