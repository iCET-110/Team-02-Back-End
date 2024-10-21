package edu.icet.controller;

import edu.icet.dto.Patient;
import edu.icet.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/patient")
@RequiredArgsConstructor
@Slf4j
public class PatientController {

    final PatientService patientService;

    @PostMapping("/add-patient")
    public void addPatient(@RequestBody Patient patient){
        log.info("Received Patient: {}", patient);
        patientService.addPatient(patient);
    }
    @GetMapping
    public List <Patient> getPatients() {
        return patientService.getPatients();}
    @GetMapping("/{id}")
    public Patient searchStudentById(@PathVariable Long id) {
        return patientService.findById(id);
    }
    @GetMapping("/name/{name}")
    public List<Patient> searchStudentByName(@PathVariable String name){
        return patientService.getByName(name);
    }
    @GetMapping("/nic/{nic}")
    public Patient searchStudentByNic(@PathVariable String nic){
        return patientService.getByNic(nic);
    }
    @PutMapping
    public void updatePatient(@RequestBody Patient patient) {
        patientService.updatePatient(patient);
    }
}
