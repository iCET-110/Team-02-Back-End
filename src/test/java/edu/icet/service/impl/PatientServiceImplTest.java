package edu.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Patient;
import edu.icet.entity.PatientEntity;
import edu.icet.repository.PatientDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class PatientServiceImplTest {

    @Mock
    private PatientDao patientDao;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private PatientServiceImpl patientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void updatePatient() {
        Patient patient = new Patient();
        PatientEntity patientEntity = new PatientEntity();
        when(objectMapper.convertValue(patient, PatientEntity.class)).thenReturn(patientEntity);

        patientService.updatePatient(patient);

        verify(patientDao).save(patientEntity);
    }
}