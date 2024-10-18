package edu.icet.controller;

import edu.icet.dto.Guardian;
import edu.icet.service.GuardiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor

public class GuardiantController {
   private final GuardiantService guardianService;

    @PutMapping("/updateGuardian")
    public void updateGuardian(Guardian guardiant){
        guardianService.updateGuardian(guardiant);
    }
}
