package com.example.eurekaclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class DcController {

    private Logger logger = LoggerFactory.getLogger(DcController.class);
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() throws InterruptedException {
        Thread.sleep(new Random().nextInt(2000));
        String services = "Services: " + discoveryClient.getServices();
        logger.info(services);
        return services;
    }

}