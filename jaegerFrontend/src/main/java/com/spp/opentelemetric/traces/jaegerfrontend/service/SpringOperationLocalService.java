package com.spp.opentelemetric.traces.jaegerfrontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

@Service
@Profile("local")
public class SpringOperationLocalService implements SpringOperationBaseService
{
    private static final Logger logger = LoggerFactory.getLogger(SpringOperationLocalService.class);

    @Autowired
    private RestTemplate restTemplate;

    public String getBackendUrl(String name)
    {
        String v_backendUrl = "http://localhost:8081/stroperationBackend/uppercase/" + name ;
        logger.info("Profile :local, Input Param: {} , Backend URL : {}", name, v_backendUrl);
        String response = restTemplate.getForObject(v_backendUrl, String.class);
        logger.info("Response From Server:" + response);
        return response ;
    }
}//End of class SpringOperationLocalService