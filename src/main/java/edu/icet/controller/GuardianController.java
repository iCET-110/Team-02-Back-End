package edu.icet.controller;

import edu.icet.dto.Guardian;
import edu.icet.service.GuardianService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
@RequiredArgsConstructor

public class GuardianController {
    @Autowired
    GuardianService guardianService;
    @GetMapping("/view-guardian")
    public List<Guardian> getGuardian(){
        return  guardianService.getGuardian();
    }
    @PostMapping("/add-guardian")
    public void addGuardian(@RequestBody Guardian guardian){
        guardianService.addGuardian(guardian);
    }
}
