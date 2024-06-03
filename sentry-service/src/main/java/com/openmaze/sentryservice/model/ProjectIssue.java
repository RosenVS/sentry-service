package com.openmaze.sentryservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectIssue {
    private String id;
    private String shareId;
    private String shortId;
    private String title;
    private String culprit;
    private String permalink;
    private String logger;
    private String level;
    private String status;
    private Map<String, Object> statusDetails;
    private String substatus;
    private boolean isPublic;
    private String platform;
    private String projectId;
    private String projectName;
    private String projectSlug;
    private String projectPlatform;
    private String type;
    private String metadataValue;
    private String metadataType;
    private String metadataFilename;
    private String metadataFunction;
    private String metadataDisplayTitleWithTreeLabel;
    private String metadataInAppFrameMix;
    private String metadataSdkName;
    private String metadataNormalizedSdkName;
    private int numComments;
    private String assignedTo;
    private boolean isBookmarked;
    private boolean isSubscribed;
    private String subscriptionDetails;
    private boolean hasSeen;
    private List<String> annotations;
    private String issueType;
    private String issueCategory;
    private String priority;
    private String priorityLockedAt;
    private boolean isUnhandled;
    private String count;
    private String userCount;
    private String firstSeen;
    private String lastSeen;
    private Stats stats;

    @Data
    public static class Stats {
        private List<List<Object>> twentyFourHours;
        private List<List<Object>> thirtyDays;
    }
}