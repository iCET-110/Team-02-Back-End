package edu.icet.controller;

import edu.icet.dto.Guardian;
import edu.icet.service.GuardianService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/guardian")
public class GuardianController {

    final GuardianService guardianService;

    @GetMapping("/view-guardian")
    public List<Guardian> getGuardian() {
        return guardianService.getGuardian();
    }

    @PostMapping("/add-guardian")
    public void addGuardian(@RequestBody Guardian guardian) {
        guardianService.addGuardian(guardian);
    }

    @PutMapping("/update-guardian")
    public void updateGuardian(@RequestBody Guardian guardian) {
        guardianService.updateGuardian(guardian);
    }
}