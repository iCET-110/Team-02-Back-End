package edu.icet.controller;
import edu.icet.dto.Guardiant;
import edu.icet.service.GuardiantService;
import jakarta.servlet.http.HttpServletRequest;
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
    @DeleteMapping("/delete/{id}")
    public void deleteGuardiant(@PathVariable String id , HttpServletRequest request){
        String os = request.getHeader("sec-ch-ua");
        log.info("delete guardian {} {}",id,os);
        guardiantService.deleteGuardiant(id);
    }
    @DeleteMapping("/delete/all")
    public void deleteGuardiant(HttpServletRequest request){
        String os = request.getHeader("sec-ch-ua");
        log.info("delete guardian all {} ",os);
        guardiantService.deleteAllGuardiant();
    }
}
