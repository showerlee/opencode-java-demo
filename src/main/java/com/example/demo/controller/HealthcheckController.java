package com.example.demo.controller;

import org.springframework.boot.info.BuildProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
public class HealthcheckController {

    private final BuildProperties buildProperties;

    public HealthcheckController(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    @GetMapping("/.well-known/health")
    public ResponseEntity<Map<String, String>> health() {
        String apiVersion = buildProperties.getVersion();
        String status = "OK";
        String datetime = OffsetDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        String hostInstanceId = getHostInstanceId();

        return ResponseEntity.ok(Map.of(
            "apiVersion", apiVersion,
            "status", status,
            "datetime", datetime,
            "hostInstanceId", hostInstanceId
        ));
    }

    private String getHostInstanceId() {
        String hostname = System.getenv("HOSTNAME");
        if (hostname != null && !hostname.isBlank()) {
            return hostname;
        }

        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "unknown";
        }
    }
}
