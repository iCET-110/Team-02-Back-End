package edu.icet.repository;

import edu.icet.entity.GuardianEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuardianDao extends JpaRepository<GuardianEntity,String> {
}
