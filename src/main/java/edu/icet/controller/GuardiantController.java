package edu.icet.controller;

import edu.icet.service.GuardiantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/Guardian")
@RequiredArgsConstructor
@Slf4j
public class GuardiantController {

    final GuardiantService guardiantService;

    @DeleteMapping("/delete-guardian/{id}")
    public void deleteGuardiant(@PathVariable String id){
        guardiantService.deleteGuardiant(id);
    }
}
