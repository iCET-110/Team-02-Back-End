package edu.icet.repository;

import edu.icet.dto.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GuardianDao extends JpaRepository<Guardian,String>{
}
