package com.spp.opentelemetric.traces.jaegerbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JaegerBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(JaegerBackendApplication.class, args);
    }

}
