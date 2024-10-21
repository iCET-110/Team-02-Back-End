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
    @GetMapping
    public List <Patient> getPatients() {
        return patientService.getPatients();}
    @GetMapping("/{patientId}")
    public Patient searchPatientById(@PathVariable String id) {
        return patientService.findById(id);
    }
    @GetMapping("/name/{firstName}")
    public List<Patient> searchPatientByName(@PathVariable String name){
        return patientService.getByName(name);
    }
    @GetMapping("/nic/{nic}")
    public Patient searchPatientByNic(@PathVariable String nic){
        return patientService.getByNic(nic);
    }
    @PutMapping
    public void updatePatient(@RequestBody Patient patient) {
        patientService.updatePatient(patient);
    }
}
