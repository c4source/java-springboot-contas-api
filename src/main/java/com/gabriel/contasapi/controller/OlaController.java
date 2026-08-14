package com.gabriel.contasapi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Essa classe vai receber requisições web e devolver dados como resposta."
public class OlaController {

    //endpoint get
    @GetMapping("/ola")
    public String ola(){
        return "ola, minha primeira API JAVA SPRINGBOOT";
    }

}
