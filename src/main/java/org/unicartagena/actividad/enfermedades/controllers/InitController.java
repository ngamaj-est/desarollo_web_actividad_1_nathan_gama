package org.unicartagena.actividad.enfermedades.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

    @Controller
    public class InitController {

        @GetMapping("/")
        public String index() {
            return "redirect:/login";
        }
    }

