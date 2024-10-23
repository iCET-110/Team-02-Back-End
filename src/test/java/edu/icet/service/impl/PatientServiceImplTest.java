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


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
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
    
    @Test
    void getByName() {
        String name = "John";
        PatientEntity patientEntity = new PatientEntity();
        Patient patient = new Patient();
        when(patientDao.findByFirstName(name)).thenReturn(Arrays.asList(patientEntity));
        when(objectMapper.convertValue(patientEntity, Patient.class)).thenReturn(patient);

        List<Patient> result = patientService.getByName(name);

        assertEquals(1, result.size());
        assertEquals(patient, result.get(0));
    }

    @Test
    void findById() {
        Long id = 1L;
        PatientEntity patientEntity = new PatientEntity();
        Patient patient = new Patient();
        when(patientDao.findById(id)).thenReturn(Optional.of(patientEntity));
        when(objectMapper.convertValue(patientEntity, Patient.class)).thenReturn(patient);

        Patient result = patientService.findById(id);

        assertNotNull(result);
        assertEquals(patient, result);
    }

    @Test
    void getByNic() {
        String nic = "123456789";
        PatientEntity patientEntity = new PatientEntity();
        Patient patient = new Patient();
        when(patientDao.findByNic(nic)).thenReturn(patientEntity);
        when(objectMapper.convertValue(patientEntity, Patient.class)).thenReturn(patient);

        Patient result = patientService.getByNic(nic);

        assertEquals(patient, result);
    }

    @Test
    void getPatients() {
        PatientEntity patientEntity1 = new PatientEntity();
        PatientEntity patientEntity2 = new PatientEntity();
        Patient patient1 = new Patient();
        Patient patient2 = new Patient();
        when(patientDao.findAll()).thenReturn(Arrays.asList(patientEntity1, patientEntity2));
        when(objectMapper.convertValue(patientEntity1, Patient.class)).thenReturn(patient1);
        when(objectMapper.convertValue(patientEntity2, Patient.class)).thenReturn(patient2);

        List<Patient> result = patientService.getPatients();

        assertEquals(2, result.size());
        assertTrue(result.contains(patient1));
        assertTrue(result.contains(patient2));
    }


}