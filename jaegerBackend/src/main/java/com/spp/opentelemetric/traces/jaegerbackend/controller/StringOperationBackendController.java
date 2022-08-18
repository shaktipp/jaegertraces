package com.spp.opentelemetric.traces.jaegerbackend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/stroperationBackend")
public class StringOperationBackendController
{
    private static final Logger logger = LoggerFactory.getLogger(StringOperationBackendController.class);

    /**
     * URL: http://localhost:8081/stroperationBackend/uppercase/shakti123
     * @param name
     * @return
     */
    @GetMapping("/uppercase/{name}")
    public ResponseEntity<String> uppercase(@PathVariable String name)
    {
        logger.info("Executing Rest Endpoint /uppercase/{}",name);
        return new ResponseEntity<>(name.toUpperCase(), HttpStatus.OK);
    }
}

