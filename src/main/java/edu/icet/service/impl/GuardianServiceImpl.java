package edu.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Guardian;
import edu.icet.dto.Patient;
import edu.icet.entity.GuardianEntity;
import edu.icet.entity.PatientEntity;
import edu.icet.repository.GuardianDao;
import edu.icet.service.GuardianService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GuardianServiceImpl implements GuardianService {

    final GuardianDao guardianDao;
    final ObjectMapper objectMapper;

    @Override
    public List<Guardian> getGuardian() {
        List<Guardian> guardianList = new ArrayList<>();
        guardianDao.findAll().forEach(guardianEntity -> {
            guardianList.add(objectMapper.convertValue(guardianEntity, Guardian.class));
        });
        return guardianList;
    }
    @Override
    public void addGuardian(Guardian guardian) {
        guardianDao.save(objectMapper.convertValue(guardian, GuardianEntity.class));
    }
    @Override
    public void updateGuardian(Guardian guardian) {
        guardianDao.save(objectMapper.convertValue(guardian, GuardianEntity.class));
    }
    @Override
    public void deleteGuardian(String guardianNIC) {
        guardianDao.deleteById(guardianNIC);  // Implementation of delete by ID
    }
}
