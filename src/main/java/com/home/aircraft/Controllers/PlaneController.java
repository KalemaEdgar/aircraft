package com.home.aircraft.Controllers;

import com.home.aircraft.Models.Aircraft;
import com.home.aircraft.Services.PlaneFinderService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Component
public class PlaneController {
    private final PlaneFinderService pfService;

    public PlaneController(PlaneFinderService pfService) {
        this.pfService = pfService;
    }

    @ResponseBody
    @GetMapping("/aircraft")
    public Iterable<Aircraft> getCurrentAircraft() throws IOException {
        return pfService.getAircraft();
    }
}
