package com.campus360.backend.organization.mapper;

import com.campus360.backend.organization.dto.request.CreateOrganizationRequest;
import com.campus360.backend.organization.dto.response.OrganizationResponse;
import com.campus360.backend.organization.entity.Organization;
import com.campus360.backend.organization.enums.OrganizationStatus;
import org.springframework.stereotype.Component;

@Component
public class OrganizationMapper {

    public Organization toEntity(CreateOrganizationRequest request, String organizationCode, OrganizationStatus organizationStatus){

        if (request == null){
            return null;
        }

        return Organization.builder()
                .organizationName(request.getOrganizationName())
                .shortName(request.getShortName())
                .organizationCode(organizationCode)
                .governmentCode(request.getGovernmentCode())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .website(request.getWebsite())
                .address(request.getAddress())
                .organizationType(request.getOrganizationType())
                .universityType(request.getUniversityType())
                .universityName(request.getUniversityName())
                .organizationStatus(organizationStatus)
                .build();
    }

    public OrganizationResponse toResponse(Organization organization){

        if (organization == null){
            return null;
        }

        return OrganizationResponse.builder()
                .organizationName(organization.getOrganizationName())
                .shortName(organization.getShortName())
                .organizationCode(organization.getOrganizationCode())
                .governmentCode(organization.getGovernmentCode())
                .email(organization.getEmail())
                .phoneNumber(organization.getPhoneNumber())
                .website(organization.getWebsite())
                .logoKey(organization.getLogoKey())
                .address(organization.getAddress())
                .organizationType(organization.getOrganizationType())
                .universityType(organization.getUniversityType())
                .universityName(organization.getUniversityName())
                .organizationStatus(organization.getOrganizationStatus())
                .createdAt(organization.getCreatedAt())
                .build();
    }
}
