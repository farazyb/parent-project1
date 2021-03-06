package com.fyb.somewebtest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RequestMapping("/employee")
public class SomeWebTestApplication {

    @Value("${my.prop}")
    private String myProp;

    @RefreshScope
    @GetMapping("/get")
    public String getMyProp() {
        return "Prop value: " + myProp;
    }
    public static void main(String[] args) {
        SpringApplication.run(SomeWebTestApplication.class, args);
    }

}
