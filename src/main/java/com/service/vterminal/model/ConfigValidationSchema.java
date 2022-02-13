package com.service.vterminal.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ConfigValidationSchema {

    @JsonProperty(required=true)
    String stompUrl;
    @JsonProperty(required=true)
    String serverUrlServer;
    @JsonProperty(required=true)
    long ownerId;
    @JsonProperty(required=true)
    long groupId;
    @JsonProperty(required=true)
    Settings settings;
    @JsonProperty(required=true)
    String jitsiDomain;
    @JsonProperty(required=true)
    String secret;
    @JsonProperty(required=true)
    String aud;
    @JsonProperty(required=true)
    String iss;
    @JsonProperty(required=true)
    String sub;
    @JsonProperty(required=true)
    int byeScreenTimeout;
    @JsonProperty(required=true)
    int noAgentScreenTimeout;
    @JsonProperty(required=true)
    boolean isRedirectToSurvey;

    public static class Settings {
        @JsonProperty(required=true)
        Auth auth;
        @JsonProperty(required=true)
        Sync sync;
    }

    public static class Auth {
        @JsonProperty(required=true)
        String clientId;
        @JsonProperty(required=true)
        String clientSecret;
        @JsonProperty(required=true)
        String endpointUrl;
    }

    public static class Sync {
        @JsonProperty(required=true)
        String channelId;
        @JsonProperty(required=true)
        String endpointUrl;
    }

    public ConfigValidationSchema(){}

    public ConfigValidationSchema(String stompUrl, String serverUrlServer, long ownerId, long groupId, Settings settings, String jitsiDomain, String secret, String aud, String iss, String sub, int byeScreenTimeout, int noAgentScreenTimeout, boolean isRedirectToSurvey) {
        this.stompUrl = stompUrl;
        this.serverUrlServer = serverUrlServer;
        this.ownerId = ownerId;
        this.groupId = groupId;
        this.settings = settings;
        this.jitsiDomain = jitsiDomain;
        this.secret = secret;
        this.aud = aud;
        this.iss = iss;
        this.sub = sub;
        this.byeScreenTimeout = byeScreenTimeout;
        this.noAgentScreenTimeout = noAgentScreenTimeout;
        this.isRedirectToSurvey = isRedirectToSurvey;
    }
}
