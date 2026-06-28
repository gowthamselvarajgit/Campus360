package com.campus360.backend.organization.service;

import com.campus360.backend.organization.dto.request.CreateOrganizationRequest;
import com.campus360.backend.organization.dto.response.OrganizationResponse;

public interface OrganizationService {

    OrganizationResponse createOrganization(CreateOrganizationRequest request);
}
