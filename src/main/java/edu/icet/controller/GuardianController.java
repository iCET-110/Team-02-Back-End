package edu.icet.controller;


import edu.icet.dto.Guardian;
import edu.icet.service.GuardianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/guardian")
@Slf4j
public class GuardianController {

    final GuardianService guardianService;

    @GetMapping("/view-guardian")
    public List<Guardian> getGuardian() {
        return guardianService.getGuardian();
    }

    @PostMapping("/add-guardian")
    public ResponseEntity<String> addGuardian(@Valid @RequestBody Guardian guardian) {
        log.info("Received Guardian: {}", guardian);
        guardianService.addGuardian(guardian);
        return ResponseEntity.ok("Guardian Added Successfully");
    }

    @PutMapping("/update-guardian")
    public ResponseEntity<String> updateGuardian(@RequestBody Guardian guardian){
        guardianService.updateGuardian(guardian);
        return ResponseEntity.ok("Guardian Updated Successfully");
    }

    @DeleteMapping("/guardian-delete-by-nic/{guardianNIC}")
    public ResponseEntity<String> deleteGuardian(@Valid @PathVariable String guardianNIC) {
        guardianService.deleteGuardian(guardianNIC);
        return ResponseEntity.ok("Guardian deleted successfully");
    }
}
