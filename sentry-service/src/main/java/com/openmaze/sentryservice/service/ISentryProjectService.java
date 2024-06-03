package com.openmaze.sentryservice.service;

import com.openmaze.sentryservice.model.ProjectIssue;
import com.openmaze.sentryservice.model.SentryProject;

import java.util.List;

public interface ISentryProjectService {
    List<SentryProject> getAllSentryProjects(String organizationSlug);}
