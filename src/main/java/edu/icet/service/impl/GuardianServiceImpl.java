package edu.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Guardian;
import edu.icet.entity.GuardianEntity;
import edu.icet.repository.GuardianDao;
import edu.icet.service.GuardianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuardianServiceImpl implements GuardianService {
    @Autowired
    GuardianDao guardianDao;

    @Autowired
    ObjectMapper objectMapper;

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
    public void deleteGuardianById(String id) {
        guardianDao.deleteById(id);
    }
    @Override
    public void deleteAllGuardian() {
        guardianDao.deleteAll();
    }
}
