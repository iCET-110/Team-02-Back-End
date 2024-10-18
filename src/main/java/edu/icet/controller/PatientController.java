package edu.icet.controller;

import edu.icet.dto.Patient;
import edu.icet.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    final PatientService patientService;
    @GetMapping
    public List <Patient> getPatients() {
        return patientService.getPatients();}
    @GetMapping("/{id}")
    public Patient searchStudentById(@PathVariable String id) {
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
}
