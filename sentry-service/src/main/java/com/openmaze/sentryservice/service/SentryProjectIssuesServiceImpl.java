package com.openmaze.sentryservice.service;

import com.openmaze.sentryservice.model.ProjectIssue;
import com.openmaze.sentryservice.model.SentryProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SentryProjectIssuesServiceImpl implements ISentryProjectIssuesService {
    @Autowired
    private IOrganizationsService organizationsService;
    @Value("${sentry.api.url}")
    private String sentryApiUrl;


    public List<ProjectIssue> getAllSentryProjectIssues(String organizationId, String slugID) {
        String url = sentryApiUrl + "/projects/" + organizationId +"/"+slugID+ "/issues/";
        String integrationToken = organizationsService.getOrganizationByOrganizationId(organizationId).get().getIntegrationToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + integrationToken);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProjectIssue[]> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                ProjectIssue[].class
        );

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return Arrays.asList(responseEntity.getBody());
        } else {
            return Collections.emptyList();
        }
    }


}