package com.openmaze.sentryservice.controller;

import com.openmaze.sentryservice.model.ProjectIssue;
import com.openmaze.sentryservice.model.SentryProject;
import com.openmaze.sentryservice.service.ISentryProjectIssuesService;
import com.openmaze.sentryservice.service.ISentryProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ISentryProjectService projectService;

    @Autowired
    private ISentryProjectIssuesService projectIssueService;

    @GetMapping("/{organizationSlug}")
    public List<SentryProject> getAllSentryProjects(@PathVariable String organizationSlug) {
        return projectService.getAllSentryProjects(organizationSlug);
    }
    @GetMapping("/{organizationSlug}/{projectSlug}")
    public List<ProjectIssue> getAllSentryProjectIssues(@PathVariable String organizationSlug,
                                                        @PathVariable String projectSlug) {
        return projectIssueService.getAllSentryProjectIssues(organizationSlug,projectSlug);
    }
}
