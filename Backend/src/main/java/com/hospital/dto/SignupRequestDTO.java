package com.hospital.dto;

import com.hospital.entities.UserRole; // Corrected import for UserRole enum
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL; // Added for profilePhotoUrl

import java.time.LocalDate;

@Data // Lombok annotation for getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder // Lombok annotation for builder pattern
public class SignupRequestDTO {

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
             message = "Password must contain at least one digit, one lowercase, one uppercase, one special character, and no whitespace.")
    private String password;

    @NotBlank(message = "Confirm password cannot be empty")
    private String confirmPassword; // To ensure password confirmation on client side

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
    private UserRole role; // Aligned with 'role' field name in User entity

    @URL(message = "Invalid profile photo URL format")
    private String profilePhotoUrl;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth; // Aligned with 'dateOfBirth' field name in User entity

    @Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other")
    private String gender;

    // No specific size constraint for TEXT type in DTO, handled by DB columnDefinition
    private String address;

    // Doctor specific fields (can be null for non-doctors)
    @Size(max = 100, message = "Specialization cannot exceed 100 characters")
    private String specialization;

    @Size(max = 50, message = "License number cannot exceed 50 characters")
    private String licenseNumber;

    @Min(value = 0, message = "Experience years cannot be negative")
    private Integer experienceYears;
}
