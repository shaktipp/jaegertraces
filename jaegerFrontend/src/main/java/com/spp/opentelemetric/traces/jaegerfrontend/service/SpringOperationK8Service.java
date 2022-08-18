package com.spp.opentelemetric.traces.jaegerfrontend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Profile("k8")
public class SpringOperationK8Service  implements SpringOperationBaseService
{
    private static final Logger logger = LoggerFactory.getLogger(SpringOperationK8Service.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${BACKEND_HOST}")
    private String backend_host;

    public String getBackendUrl(String name)
    {
        //String v_backendUrl = "http://" + backend_host + ":8081/stroperationBackend/uppercase/" + name + "/";
        String v_backendUrl = String.format("http://%s:8081/stroperationBackend/uppercase/%s" , backend_host , name);


        logger.info("Profile :k8, Input Param: {} , Backend URL : {}", name, v_backendUrl);
        String response = restTemplate.getForObject(v_backendUrl, String.class);
        logger.info("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info("Response From Server:" + response);
        logger.info("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        return response ;
    }
}
