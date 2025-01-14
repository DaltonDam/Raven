package com.raven.controller;

import com.raven.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/raven/developer")
public class DeveloperController {

    private final DeveloperService developerService;

}
