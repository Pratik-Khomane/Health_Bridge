package com.hospital.dto;

import com.hospital.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRespDTO extends BaseDTO{
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private UserRole role;
    private String profilePhotoUrl;
    private LocalDate dateOfBirth;
    private String gender;
    private String address;
    private String specialization;
    private String licenseNumber;
    private Integer experienceYears;
    private String departmentId; // Only send department ID

    // Note: Password is excluded for security reasons.
}