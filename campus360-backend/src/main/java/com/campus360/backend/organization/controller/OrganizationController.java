package com.campus360.backend.organization.controller;

import com.campus360.backend.common.constants.api.ApiConstants;
import com.campus360.backend.common.response.ApiResponse;
import com.campus360.backend.organization.dto.request.CreateOrganizationRequest;
import com.campus360.backend.organization.dto.response.OrganizationResponse;
import com.campus360.backend.organization.entity.Organization;
import com.campus360.backend.organization.service.OrganizationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.API_BASE + "/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    public ResponseEntity<ApiResponse<OrganizationResponse>> createOrganization(
            @Valid @RequestBody CreateOrganizationRequest request
            ){
        OrganizationResponse response = organizationService.createOrganization(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.success(
                                "Organization created successfully.",
                                response
                        )
                );
    }
}
