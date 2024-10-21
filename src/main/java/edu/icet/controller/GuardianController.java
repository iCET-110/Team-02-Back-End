package edu.icet.controller;

import edu.icet.service.GuardianService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/Guardian")
@RestController
@Slf4j
public class GuardianController {
    final GuardianService guardianService;

    @DeleteMapping("/delete/all")
    public void deleteGuardianAll(HttpServletRequest request){
        String ip = request.getRemoteAddr();
        log.info("Request Received Delete-All {}",ip);

    }
    @DeleteMapping("/delete/{id}")
    public void deleteGuardianById(@PathVariable String id ,HttpServletRequest request){
        String ip = request.getRemoteAddr();
        log.info("Request Received Delete-{} {}",id,ip);
    }
}
