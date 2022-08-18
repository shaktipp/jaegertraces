package com.spp.opentelemetric.traces.jaegerfrontend.controller;


import com.spp.opentelemetric.traces.jaegerfrontend.service.SpringOperationBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/stroperationFrontend")
public class StringOperationFrontendController
{

    @Autowired
    private SpringOperationBaseService springOperationBaseService;

    private static final Logger logger = LoggerFactory.getLogger(StringOperationFrontendController.class);

    /**
     * URL: http://localhost:8080/stroperationFrontend/changeUppercase/shakti
     * @param name
     * @return
     */
    @GetMapping("/changeUppercase/{name}")
    public ResponseEntity<String> change2Uppercase(@PathVariable String name)
    {
        logger.info("Executing Rest Endpoint /changeUppercase/{}",name);
        String response = "";
        try
        {
            response = springOperationBaseService.getBackendUrl(name);
            logger.info("Inside Controller, Response Received from Backend Server:{}",response);
        }
        catch(Exception e)
        {
            logger.error("Error occurred while calling Rest EndPoint of Backend Service,Actual Error:{}",e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}//End of class StringOperationController
