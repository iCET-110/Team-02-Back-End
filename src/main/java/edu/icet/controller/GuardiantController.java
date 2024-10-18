package edu.icet.controller;

import edu.icet.dto.Guardian;
import edu.icet.service.GuardiantService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class GuardiantController {
    GuardiantService service;


    @PutMapping("/updateGuardian")
    public void updateGuardian(Guardian guardiant){
        service.updateGuardian(guardiant);
    }
}
