package com.openmaze.sentryservice.service;

import com.openmaze.sentryservice.model.SentryProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SentryProjectServiceImpl implements ISentryProjectService {
    @Autowired
    private IOrganizationsService organizationsService;

    @Value("${sentry.api.url}")
    private String sentryApiUrl;


    public List<SentryProject> getAllSentryProjects(String organizationId) {
        String integrationToken = organizationsService.getOrganizationByOrganizationId(organizationId).get().getIntegrationToken();

        String url = sentryApiUrl + "/organizations/" + organizationId + "/projects/";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + integrationToken);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SentryProject[]> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                SentryProject[].class
        );

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return Arrays.asList(responseEntity.getBody());
        } else {
            return Collections.emptyList();
        }
    }
}