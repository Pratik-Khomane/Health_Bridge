package com.hospital.dto;

import com.hospital.entities.UserRole;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Getter
@Setter
public class UserRequestDTO {

    // For creation, most fields will be @NotBlank/@NotNull
    // For updates, they can be nullable for partial updates,
    // so we apply validation based on the field's nature.

    // Password is handled separately for security (e.g., in SignUpRequestDto or a dedicated password change DTO)
    // For update, this field is typically not included or is optional and handled with specific logic.
    private String password; // This would typically be for creation only, or a separate DTO for password change

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    @Size(max = 100, message = "Email cannot exceed 100 characters")
    private String email;

    @NotBlank(message = "First name cannot be empty")
    @Size(max = 50, message = "First name cannot exceed 50 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Size(max = 50, message = "Last name cannot exceed 50 characters")
    private String lastName;

    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Invalid phone number format")
    private String phoneNumber;

    @NotNull(message = "User role cannot be empty")
    private UserRole role;

    @URL(message = "Invalid profile photo URL format")
    private String profilePhotoUrl;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other")
    private String gender;

    private String address; // TEXT type, no specific size constraint here

    @Size(max = 100, message = "Specialization cannot exceed 100 characters")
    private String specialization;

    @Size(max = 50, message = "License number cannot exceed 50 characters")
    private String licenseNumber;

    @Min(value = 0, message = "Experience years cannot be negative")
    private Integer experienceYears;

    private String departmentId; // For linking to Department by ID
}
