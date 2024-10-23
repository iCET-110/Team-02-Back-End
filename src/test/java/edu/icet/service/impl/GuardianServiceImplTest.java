package edu.icet.service.impl;

import edu.icet.entity.GuardianEntity;
import edu.icet.repository.GuardianDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GuardianServiceImplTest {

    @Mock
    private GuardianDao guardianDao;

    @InjectMocks
    private GuardianServiceImpl guardianServiceImpl;

    private GuardianEntity guardianEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        guardianEntity = new GuardianEntity();
        guardianEntity.setGuardianNIC("123456789V");
        guardianEntity.setGuardianName("Jane Doe");
        guardianEntity.setGuardianContact("077 123 4567");
    }

    @Test
    void test_SearchGuardian_Found() {
        String guardianNIC = "123456789V";
        when(guardianDao.findById(guardianNIC)).thenReturn(Optional.of(guardianEntity));

        Optional<GuardianEntity> result = guardianServiceImpl.searchGuardian(guardianNIC);

        assertTrue(result.isPresent());
        assertEquals("Jane Doe", result.get().getGuardianName());
        verify(guardianDao, times(1)).findById(guardianNIC);
    }

    @Test
    void test_SearchGuardian_NotFound() {
        String guardianNIC = "987654321V";
        when(guardianDao.findById(guardianNIC)).thenReturn(Optional.empty());

        Optional<GuardianEntity> result = guardianServiceImpl.searchGuardian(guardianNIC);

        assertFalse(result.isPresent());
        verify(guardianDao, times(1)).findById(guardianNIC);
    }
}
