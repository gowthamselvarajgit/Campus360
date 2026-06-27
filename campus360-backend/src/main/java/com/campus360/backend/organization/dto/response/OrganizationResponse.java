package com.campus360.backend.organization.dto.response;

import com.campus360.backend.common.model.Address;
import com.campus360.backend.organization.enums.OrganizationStatus;
import com.campus360.backend.organization.enums.OrganizationType;
import com.campus360.backend.organization.enums.UniversityType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class OrganizationResponse {

    private String organizationName;
    private String shortName;

    private String organizationCode;
    private String governmentCode;

    private String email;
    private String phoneNumber;
    private String website;

    private String logoKey;

    private Address address;

    private OrganizationType organizationType;
    private UniversityType universityType;

    private String universityName;

    private OrganizationStatus organizationStatus;

    private LocalDateTime createdAt;

}
