package dev.marcelohd.screenmatch.frases.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marcelohd.screenmatch.frases.model.FraseDTO;
import dev.marcelohd.screenmatch.frases.service.FraseService;

@RestController
public class FraseController {

    @Autowired
    FraseService service;

    @GetMapping("/series/frases")
    public FraseDTO obterFrase (){
       return service.obterFraseAleatorios();
    }
    
}
