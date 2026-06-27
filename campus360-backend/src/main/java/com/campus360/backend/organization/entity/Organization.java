package com.campus360.backend.organization.entity;

import com.campus360.backend.common.audit.BaseEntity;
import com.campus360.backend.common.model.Address;
import com.campus360.backend.organization.enums.OrganizationStatus;
import com.campus360.backend.organization.enums.OrganizationType;
import com.campus360.backend.organization.enums.UniversityType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "organizations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Organization extends BaseEntity {

    @Column(name = "organization_name", nullable = false, length = 200)
    private String organizationName;

    @Column(name = "short_name", nullable = false, length = 30)
    private String shortName;

    @Column(name = "organization_code", nullable = false, unique = true, length = 20)
    private String organizationCode;

    @Column(name = "government_code", length = 20)
    private String governmentCode;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @Column(name = "website", length = 255)
    private String website;

    @Column(name = "logo_key", length = 500)
    private String logoKey;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(name = "organization_type", nullable = false)
    private OrganizationType organizationType;

    @Enumerated(EnumType.STRING)
    @Column(name = "university_type", nullable = false)
    private UniversityType universityType;

    @Column(name = "university_name", nullable = false)
    private String universityName;

    @Enumerated(EnumType.STRING)
    @Column(name = "organization_status", nullable = false)
    private OrganizationStatus organizationStatus;
}
