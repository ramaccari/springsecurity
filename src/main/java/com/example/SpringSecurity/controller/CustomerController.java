package com.example.SpringSecurity.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringSecurity.service.CustomerService;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/index")
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/index2")
    public String index2() {
        return "Hello World! NOT Secured";
    }

    @GetMapping("/session")
    public ResponseEntity<Map<String, Object>> getDetailsSession() {
    	Map<String, Object> response = customerService.getSessionData();
        return ResponseEntity.ok(response);
    }
}
