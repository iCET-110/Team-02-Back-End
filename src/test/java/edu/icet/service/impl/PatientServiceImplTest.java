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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.mockito.Mockito.*;

public class PatientServiceImplTest {
    @Mock
    private PatientDao patientDao;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private PatientServiceImpl patientServiceImpl;

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
        patientServiceImpl.addPatient(patient);
        verify(patientDao, times(1)).save(patientEntity);
    }
}
