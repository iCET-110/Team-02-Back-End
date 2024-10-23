package edu.icet.controller;

import edu.icet.dto.Guardian;
import edu.icet.entity.GuardianEntity;
import edu.icet.service.GuardianService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public void updateGuardian(@RequestBody Guardian guardian) {guardianService.updateGuardian(guardian);}

    @GetMapping("/search-guardian/{guardianNIC}")
    public Optional<GuardianEntity> searchGuardian(@PathVariable String guardianNIC){
       return guardianService.searchGuardian(guardianNIC);
    }
}
