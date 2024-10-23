package edu.icet.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Guardian;
import edu.icet.entity.GuardianEntity;
import edu.icet.repository.GuardianDao;
import edu.icet.service.impl.GuardianServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GuardianServiceImplTest {

    @Mock
    private GuardianDao guardianDao;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private GuardianServiceImpl guardianService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void updateGuardian() {
        Guardian guardian = new Guardian();
        GuardianEntity guardianEntity = new GuardianEntity();
        when(objectMapper.convertValue(guardian, GuardianEntity.class)).thenReturn(guardianEntity);

        guardianService.updateGuardian(guardian);

        verify(guardianDao).save(guardianEntity);
    }
}

