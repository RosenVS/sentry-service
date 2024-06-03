package com.openmaze.sentryservice;

import com.openmaze.sentryservice.model.Organizations;
import com.openmaze.sentryservice.repository.OrganizationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class SentryServiceApplication  implements CommandLineRunner {
    @Value("${sentry.organizations.id}")
    private String organizationsId;

    @Value("${sentry.integration.token}")
    private String integrationToken;
    @Autowired
    private OrganizationsRepository organizationsRepository;
    public static void main(String[] args) {
        SpringApplication.run(SentryServiceApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        Organizations org = new Organizations();
        org.setOrganizationsID(organizationsId);
        org.setIntegrationToken(integrationToken);
        organizationsRepository.save(org);
    }
}
