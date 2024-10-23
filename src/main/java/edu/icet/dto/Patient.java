package edu.icet.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient {
    private Long id;

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @NotNull(message = "Age is required")
    @Min(value = 0, message = "Age must be a positive number")
    @Max(value = 150, message = "Age must be less than or equal to 150")
    private Integer age;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private Date dob;

    @NotBlank(message = "NIC is required")
    @Pattern(regexp = "^[0-9]{9}[vVxX]$", message = "Invalid NIC format")
    private String nic;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^\\+?[0-9]{10,12}$", message = "Invalid contact number")
    private String contactNo;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Blood group is required")
    @Pattern(regexp = "^(A|B|AB|O)[+-]$", message = "Invalid blood group")
    private String bloodGroup;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Invalid gender")
    private String gender;

    @NotBlank(message = "Patient status is required")
    @Pattern(regexp = "^(true|false)$", message = "Patient status must be either 'true' or 'false'")
    private String patientStatus;

    private LocalDateTime admittedDateTime;

    @NotBlank(message = "Allergy status is required")
    @Pattern(regexp = "^(true|false)$", message = "Allergy status must be either 'true' or 'false'")
    private String allergyStatus;

    private String remarks;

    @Pattern(regexp = "^[0-9]{9}[vVxX]$", message = "Invalid guardian NIC format")
    private String guardianNic;
}