package com.floriano.com.floriano.tcc_tracker_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

    @GetMapping
    public String hi() {
        return "Hello fellas";
    }
}
