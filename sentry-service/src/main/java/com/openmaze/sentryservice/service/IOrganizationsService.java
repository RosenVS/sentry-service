package com.openmaze.sentryservice.service;

import com.openmaze.sentryservice.model.Organizations;

import java.util.List;
import java.util.Optional;

public interface IOrganizationsService {
    List<Organizations> getAllOrganizations();
    Organizations getOrganizationById(Long id);
    Organizations createOrganization(Organizations organization);
    Organizations updateOrganization(Long id, Organizations organization);
    Optional<Organizations> getOrganizationByOrganizationId(String organizationSlug);
    void deleteOrganization(Long id);
}
