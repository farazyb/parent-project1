package com.fyb.web2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RequestMapping("/consumer")
@RefreshScope
public class Web2Application {


    @Value("${my.prop}")
    private String myProp;

    @RefreshScope
    @GetMapping("/get")
    public String getMyProp() {
        return "Prop value: " + myProp;
    }
    public static void main(String[] args) {
        SpringApplication.run(Web2Application.class, args);
    }

}
