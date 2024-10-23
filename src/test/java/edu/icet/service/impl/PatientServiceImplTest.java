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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class PatientServiceImplTest {

    @Mock
    private PatientDao patientDao;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
     private PatientServiceImpl patientService;

    private Patient patient;
    private PatientEntity patientEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        patient = new Patient();
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setAge(30);
        patient.setDob(Date.from(LocalDate.of(1994, 5, 15).atStartOfDay().atZone(java.time.ZoneId.systemDefault()).toInstant()));
        patient.setNic("123456789V");
        patient.setContactNo("077 484 1006");
        patient.setEmail("john.doe@example.com");
        patient.setAddress("123 Main Street, City");
        patient.setBloodGroup("O+");
        patient.setGender("Male");
        patient.setPatientStatus("true");
        patient.setAdmittedDateTime(LocalDateTime.now());
        patient.setAllergyStatus("false");
        patient.setRemarks("");
        patient.setGuardianNic("987654321V");

        patientEntity = new PatientEntity();
        patientEntity.setFirstName("John");
        patientEntity.setLastName("Doe");
        patientEntity.setAge(30);
        patientEntity.setDob(Date.from(LocalDate.of(1994, 5, 15).atStartOfDay().atZone(java.time.ZoneId.systemDefault()).toInstant()));
        patientEntity.setNic("123456789V");
        patientEntity.setContactNo("+077 484 1006");
        patientEntity.setEmail("john.doe@example.com");
        patientEntity.setAddress("123 Main Street, City");
        patientEntity.setBloodGroup("O+");
        patientEntity.setGender("Male");
        patientEntity.setPatientStatus("true");
        patientEntity.setAdmittedDateTime(LocalDateTime.now());
        patientEntity.setAllergyStatus("false");
        patientEntity.setRemarks("");
        patientEntity.setGuardianNic("987654321V");
    }

    @Test
    void test_AddPatient_Success() {
        when(objectMapper.convertValue(patient, PatientEntity.class)).thenReturn(patientEntity);
        patientService.addPatient(patient);
        verify(patientDao, times(1)).save(patientEntity);
    }
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
