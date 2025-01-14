package com.raven.controller;

import com.raven.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/raven/movie")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

}
