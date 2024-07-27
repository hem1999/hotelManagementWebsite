package com.HotelBookingService.HotelBookingBackend;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
public class AppController {

    @GetMapping(path = "/")
    public String index() {
        return "Manage your hotel at ease!";
    }
}
