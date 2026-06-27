package com.campus360.backend.organization.dto.request;

import com.campus360.backend.common.model.Address;
import com.campus360.backend.organization.enums.OrganizationType;
import com.campus360.backend.organization.enums.UniversityType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateOrganizationRequest {

    @NotBlank(message = "Organization name is required")
    @Size(max = 200, message = "Organization name must not exceed 200 characters")
    private String organizationName;

    @NotBlank(message = "Short name is required")
    @Size(max = 30, message = "Short name must not exceed 30 characters")
    private String shortName;

    @Size(max = 20, message = "Government code must not exceed 20 characters")
    private String governmentCode;

    @NotBlank(message = "Email is required")
    @Email(message = "Email format is invalid")
    @Size(max = 150, message = "Email must not exceed 150 characters")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Size(max = 15, message = "Phone number must not exceed 15 characters")
    private String phoneNumber;

    @Size(max = 255, message = "Website URL must not exceed 255 characters")
    private String website;

    @Valid
    @NotNull(message = "Address is required")
    private Address address;

    @NotNull(message = "Organization type is required")
    private OrganizationType organizationType;

    @NotNull(message = "University type is required")
    private UniversityType universityType;

    @NotBlank(message = "University name is required")
    @Size(max = 150, message = "University name must not exceed 150 characters")
    private String universityName;

}
