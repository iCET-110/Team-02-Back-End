package edu.icet.repository;

import edu.icet.dto.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuardianDao extends JpaRepository<Guardian,String>{
    List<Guardian> findByName(String name);
}
