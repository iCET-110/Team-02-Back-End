package edu.icet.controller;

import edu.icet.dto.Guardian;
import edu.icet.service.GuardianService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/guardian")
@RestController
@Slf4j
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
    @DeleteMapping("/delete-{id}")
    public void deleteGuardianById(@PathVariable String id ,HttpServletRequest request){
        String ip = request.getRemoteAddr();
        log.info("Request Received Delete-{} {}",id,ip);
        guardianService.deleteGuardianById(id);
    }
    @DeleteMapping("/delete-all")
    public void deleteAllGuardian(HttpServletRequest request){
        String ip = request.getRemoteAddr();
        log.info("Request Received Delete-all {}",ip);
        guardianService.deleteAllGuardian();
    }
}
