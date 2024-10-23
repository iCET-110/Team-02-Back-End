package edu.icet.controller;

import edu.icet.dto.Patient;
import edu.icet.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/patient")
@RequiredArgsConstructor
@Slf4j
public class PatientController {

    final PatientService patientService;

    @PostMapping("/add-patient")
    public ResponseEntity<String> addPatient(@Valid @RequestBody Patient patient){
        log.info("Received Patient: {}", patient);
        patientService.addPatient(patient);
        return ResponseEntity.ok("Patient added successfully");
    }

    @GetMapping("/patient-get-all")
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    @GetMapping("/patient-search-by-id/{id}")
    public Patient searchPatientById(@Valid @PathVariable Long id) {
        return patientService.findById(id);
    }

    @GetMapping("/patient-search-by-name/{name}")
    public List<Patient> searchPatientByName(@Valid @PathVariable String name){
        return patientService.getByName(name);
    }

    @GetMapping("/patient-search-by-nic/{nic}")
    public Patient searchPatientByNic(@PathVariable String nic){
      return patientService.getByNic(nic);
    }

    @PutMapping
    public ResponseEntity<String> updatePatient(@Valid @RequestBody Patient patient) {
        patientService.updatePatient(patient);
        return ResponseEntity.ok("Patient updated successfully");
    }

    @DeleteMapping("/patient-delete-by-id/{id}")
    public ResponseEntity<String> deletePatient(@Valid @PathVariable Long id){
        patientService.deletPatient(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }

    @DeleteMapping("/patient-delete-all")
    public ResponseEntity<String> deleteAllPatients(){
        patientService.deleteAll();
        return ResponseEntity.ok("All patients deleted successfully");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}