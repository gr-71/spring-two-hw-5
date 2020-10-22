package com.rga.springwebapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public interface WelcomeController {
    @RequestMapping("/greeting")
    String greeting();

    @GetMapping("/parametrized/{str}")
    String parametrized(@PathVariable(value = "str") String str);
}
