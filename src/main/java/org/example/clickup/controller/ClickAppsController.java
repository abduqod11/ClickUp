package org.example.clickup.controller;

import org.example.clickup.service.ClickAppsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ClickApps")

public class ClickAppsController {
    @Autowired
    ClickAppsService clickAppsService;
}
