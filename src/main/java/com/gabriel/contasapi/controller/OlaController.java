package com.gabriel.contasapi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Essa classe vai receber requisições web e devolver dados como resposta."
@RequestMapping("ola")
public class OlaController {



    //endpoint get
    @GetMapping
    public String ola(){
        return "ola, minha primeira API JAVA SPRINGBOOT";
    }

}
