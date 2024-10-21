package edu.icet.controller;

import edu.icet.dto.Patient;
import edu.icet.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/patient")
@RequiredArgsConstructor
@Slf4j
public class PatientController {

    final PatientService service;

    @PostMapping("/add-patient")
    public void addPatient(@RequestBody Patient patient){
        log.info("Received Patient: {}", patient);
        service.addPatient(patient);
    }

    @PutMapping
    public void updatePatient(@RequestBody Patient patient) {
        service.updatePatient(patient);
    }

}
