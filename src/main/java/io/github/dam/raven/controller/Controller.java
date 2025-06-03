package io.github.dam.raven.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("raven")
public class Controller {

    @RequestMapping("/boasvindas")
    public String boasVindas() {
        return "Boas vindas";
    }

}
