package com.openmaze.sentryservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SentryProject {
    private String id;
    private String name;
    private String slug;
    private boolean isBookmarked;
    private boolean isMember;
    private Team team;
    private List<Team> teams;
    private String dateCreated;
    private List<String> environments;
    private EventProcessing eventProcessing;
    private List<String> features;
    private String firstEvent;
    private boolean firstTransactionEvent;
    private boolean hasSessions;
    private boolean hasProfiles;
    private boolean hasReplays;
    private boolean hasFeedbacks;
    private boolean hasNewFeedbacks;
    private boolean hasCustomMetrics;
    private boolean hasMonitors;
    private boolean hasMinifiedStackTrace;
    private String platform;
    private List<String> platforms;
    private String latestRelease;
    private boolean hasUserReports;
    private String latestDeploys;
}