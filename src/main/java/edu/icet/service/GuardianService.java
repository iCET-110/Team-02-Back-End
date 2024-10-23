package edu.icet.service;

import edu.icet.dto.Guardian;
import edu.icet.entity.GuardianEntity;

import java.util.List;
import java.util.Optional;

public interface GuardianService {
    List<Guardian> getGuardian();
    void addGuardian(Guardian guardian);
    void updateGuardian(Guardian guardian);
    Optional<GuardianEntity> searchGuardian(String guardianNIC);
}
