package edu.icet.service.impl;
import edu.icet.dto.Guardiant;
import edu.icet.repository.GuardiantDao;
import edu.icet.service.GuardiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class GuardiantServiceImpl implements GuardiantService{
    final GuardiantDao guardiantDao;
    @Override
    public void deleteGuardiant(String id) {
        guardiantDao.deleteById(id);
    }
    @Override
    public void deleteAllGuardiant() {
        guardiantDao.deleteAll();
    }
}
