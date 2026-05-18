package edu.mx.tecdesoftware.marketbackend_3A;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hola")
    public String saludar() { return "Hello World"; }
}
