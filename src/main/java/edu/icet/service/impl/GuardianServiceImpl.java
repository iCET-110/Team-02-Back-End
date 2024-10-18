package edu.icet.service.impl;

import edu.icet.dto.Guardian;
import edu.icet.repository.GuardianDao;
import edu.icet.service.GuardianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuardianServiceImpl implements GuardianService {
    @Autowired
    GuardianDao guardianDao;
    @Override
    public List<Guardian> getGuardian() {
        List<Guardian> guardianList =guardianDao.findAll();
        return guardianList;
    }
    @Override
    public void addGuardian(Guardian guardian) {
        guardianDao.save(guardian);
    }
}
