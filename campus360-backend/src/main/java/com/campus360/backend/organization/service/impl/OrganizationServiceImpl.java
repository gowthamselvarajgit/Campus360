package com.campus360.backend.organization.service.impl;

import com.campus360.backend.common.exception.DuplicateResourceException;
import com.campus360.backend.organization.dto.request.CreateOrganizationRequest;
import com.campus360.backend.organization.dto.response.OrganizationResponse;
import com.campus360.backend.organization.entity.Organization;
import com.campus360.backend.organization.enums.OrganizationStatus;
import com.campus360.backend.organization.mapper.OrganizationMapper;
import com.campus360.backend.organization.repository.OrganizationRepository;
import com.campus360.backend.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;

    @Override
    public OrganizationResponse createOrganization(CreateOrganizationRequest request) {

        validateDuplicateEmail(request.getEmail());

        Organization organization = organizationMapper.toEntity(
                request,
                null,
                OrganizationStatus.ACTIVE
        );

        organization = organizationRepository.save(organization);

        String organizationCode = generateOrganizationCode(organization.getId());

        organization.setOrganizationCode(organizationCode);

        organization = organizationRepository.save(organization);

        return organizationMapper.toResponse(organization);
    }

    private String generateOrganizationCode(Long id){
        return String.format("ORG%06d", id);
    }

    private void validateDuplicateEmail(String email){
        if (organizationRepository.existsByEmail(email)){
            throw new DuplicateResourceException("Organization email already exists.");
        }
    }
}
