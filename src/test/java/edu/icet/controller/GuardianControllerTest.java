package edu.icet.controller;

import edu.icet.service.GuardianService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GuardianControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GuardianService guardianService;

    @Test
    public void testDeleteGuardianById() throws Exception {
        String guardianId = "123";

        // Mock the service layer behavior
        Mockito.doNothing().when(guardianService).deleteGuardianById(guardianId);

        // Perform a DELETE request to /guardian/delete-{id}
        mockMvc.perform(MockMvcRequestBuilders.delete("/guardian/delete-" + guardianId))
                .andExpect(status().isOk());

        // Verify the service was called
        Mockito.verify(guardianService, Mockito.times(1)).deleteGuardianById(guardianId);
    }

    @Test
    public void testDeleteAllGuardian() throws Exception {

        // Mock the service layer behavior
        Mockito.doNothing().when(guardianService).deleteAllGuardian();

        // Perform a DELETE request to /guardian/delete-all
        mockMvc.perform(MockMvcRequestBuilders.delete("/guardian/delete-all"))
                .andExpect(status().isOk());

        // Verify the service was called
        Mockito.verify(guardianService, Mockito.times(1)).deleteAllGuardian();
    }
}
