package com.campus360.backend.organization.repository;

import com.campus360.backend.organization.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    boolean existsByEmail(String email);

    boolean existsByOrganizationCode(String organizationCode);

    Optional<Organization> findByOrganizationCode(String organizationCode);
}
