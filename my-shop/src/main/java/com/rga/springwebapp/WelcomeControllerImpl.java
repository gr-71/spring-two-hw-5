package com.rga.springwebapp;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeControllerImpl implements WelcomeController {
    @Qualifier("eurekaClient")
    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appTitle;

    @Override
    @RequestMapping("/greeting")
    public String greeting() {
        return String.format("Hi there from '%s'!", eurekaClient.getApplication(appTitle).getName());
    }

    @GetMapping("/qwerty")
    public String qwerty() {
        return "QWERTY";
    }

    @GetMapping("/hi")
    public void test() {
        System.out.println("--Hi there!--");
    }

    @GetMapping("/parametrized/{str}")
    public String parametrized(@PathVariable(value = "str") String str) {
        return "Answer-echo: " + str;
    }
}
