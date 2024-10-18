package edu.icet.repository;

import edu.icet.dto.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuardiantDao extends JpaRepository<Guardian,String> {
}
