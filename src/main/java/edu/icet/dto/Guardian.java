package edu.icet.dto;
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

    @NotBlank(message = "Guardian name is required")
    private String guardianName;

    @NotBlank(message = "Guardian NIC is required")
    @Pattern(regexp = "^[0-9]{9}[Vv]$", message = "Guardian NIC should be 9 digits followed by 'V' or 'v'")
    private String guardianNIC;

    @NotBlank(message = "Guardian contact is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Guardian contact should be a 10-digit number")
    private String guardianContact;
}

