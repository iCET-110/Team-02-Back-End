package edu.icet.service;

import edu.icet.dto.Guardian;
import edu.icet.dto.Patient;

import java.util.List;

public interface GuardianService {
    List<Guardian> getGuardian();
    void addGuardian(Guardian guardian);
    void updateGuardian(Guardian guardian);

}
