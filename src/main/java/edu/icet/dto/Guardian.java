package edu.icet.dto;


import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Guardian {
    @NotBlank(message = "Guardian NIC cannot be blank")
    @Size(min = 10, max = 12, message = "Guardian NIC must be between 10 and 12 characters")
    private String guardianNIC;

    @NotBlank(message = "Guardian Name cannot be blank")
    @Size(min = 2, message = "Guardian Name must be at least 2 characters")
    private String guardianName;

    @NotBlank(message = "Guardian Contact cannot be blank")
    @Pattern(regexp = "\\d{10}", message = "Guardian Contact must be a 10-digit number")
    private String guardianContact;
}
