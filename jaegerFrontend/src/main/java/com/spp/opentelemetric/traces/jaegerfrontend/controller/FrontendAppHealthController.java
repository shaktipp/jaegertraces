package com.spp.opentelemetric.traces.jaegerfrontend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FrontendAppHealthController
{
    private static final Logger logger = LoggerFactory.getLogger(FrontendAppHealthController.class);

    @GetMapping("/health")
    public ResponseEntity<String> getBackendAppHealth()
    {
        String v_health_status = "Frontend App Health is OK at " + LocalDateTime.now() ;
        logger.info("Backend App Health is OK at {}",v_health_status);
        return new ResponseEntity<>(v_health_status, HttpStatus.OK);
    }
}//End of class FrontendAppHealthController
