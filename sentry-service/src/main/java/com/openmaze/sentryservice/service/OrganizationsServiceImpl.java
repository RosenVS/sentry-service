package com.openmaze.sentryservice.service;

import com.openmaze.sentryservice.model.Organizations;
import com.openmaze.sentryservice.model.SentryProject;
import com.openmaze.sentryservice.repository.OrganizationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationsServiceImpl implements IOrganizationsService {

    @Autowired
    private OrganizationsRepository organizationsRepository;

    @Override
    public List<Organizations> getAllOrganizations() {
        return organizationsRepository.findAll();
    }

    @Override
    public Organizations getOrganizationById(Long id) {
        Optional<Organizations> organization = organizationsRepository.findById(id);
        return organization.orElse(null);
    }

    @Override
    public Optional<Organizations> getOrganizationByOrganizationId(String organizationId) {
        return organizationsRepository.findByOrganizationsID(organizationId);
    }


    @Override
    public Organizations createOrganization(Organizations organization) {
        return organizationsRepository.save(organization);
    }

    @Override
    public Organizations updateOrganization(Long id, Organizations organization) {
        if (organizationsRepository.existsById(id)) {
            organization.setId(id);
            return organizationsRepository.save(organization);
        }
        return null;
    }

    @Override
    public void deleteOrganization(Long id) {
        organizationsRepository.deleteById(id);
    }
}