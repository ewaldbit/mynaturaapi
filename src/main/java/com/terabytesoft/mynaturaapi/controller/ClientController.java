package com.terabytesoft.mynaturaapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    @GetMapping
    public String getClient() {
        return "Natura API on air!";
    }
}
