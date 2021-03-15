package com.devwdougherty.cloud.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod() {

        return "User Service is taking longer than Expected." +
                " Please try again later.";
    }

    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBackMethod() {

        return "Department Service is taking longer than Expected." +
                " Please try again later.";
    }
}
