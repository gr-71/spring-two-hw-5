package com.rga.myfeignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("my-shop")
public interface GreetingClient {
    @RequestMapping("/greeting")
    String greeting();

    @GetMapping("/parametrized/{str}")
    String parametrized(@PathVariable(value = "str") String str);
}
