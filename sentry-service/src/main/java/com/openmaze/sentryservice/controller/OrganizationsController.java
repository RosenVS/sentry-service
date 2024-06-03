package com.openmaze.sentryservice.controller;

import com.openmaze.sentryservice.model.Organizations;
import com.openmaze.sentryservice.service.IOrganizationsService;
import com.openmaze.sentryservice.service.OrganizationsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationsController {

    @Autowired
    private IOrganizationsService organizationsService;

    @GetMapping
    public List<Organizations> getAllOrganizations() {
        return organizationsService.getAllOrganizations();
    }

    @GetMapping("/{id}")
    public Organizations getOrganizationById(@PathVariable Long id) {
        return organizationsService.getOrganizationById(id);
    }

    @GetMapping("/organization/{organizationId}")
    public Organizations getOrganizationByOrganizationId(@PathVariable String organizationId) {
        Optional<Organizations> organization = organizationsService.getOrganizationByOrganizationId(organizationId);
        return organization.orElse(null);
    }


    @PostMapping
    public Organizations createOrganization(@RequestBody Organizations organization) {
        return organizationsService.createOrganization(organization);
    }

    @PutMapping("/{id}")
    public Organizations updateOrganization(@PathVariable Long id, @RequestBody Organizations organization) {
        return organizationsService.updateOrganization(id, organization);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganization(@PathVariable Long id) {
        organizationsService.deleteOrganization(id);
    }
}