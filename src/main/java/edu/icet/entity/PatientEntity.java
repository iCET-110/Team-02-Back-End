package edu.icet.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "patient")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Date dob;
    private String nic;
    private String contactNo;
    private String email;
    private String address;
    private String bloodGroup;
    private String gender;
    private String patientStatus; // if admitted "true" else "false"
    private LocalDateTime admittedDateTime;
    private String allergyStatus; // if has allergies "true" else "false"
    private String remarks; // allergy description
    private String guardianNic;
}