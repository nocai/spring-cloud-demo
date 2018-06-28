package com.example.eurekaclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class Trace2Application {
    public static void main(String[] args) {
        SpringApplication.run(Trace2Application.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private HttpServletRequest request;
    @RequestMapping("trace2")
    public String trace() {
        this.logger.info("----trace 2 ----");
        this.logger.info("TraceId = {}, SpanId = {}", this.request.getHeader("X-B3-TraceId"), this.request.getHeader("X-B3-SpanId"));
        this.logger.info("Header = {}", this.request.getHeaderNames());
        return "trace2";
    }
}
