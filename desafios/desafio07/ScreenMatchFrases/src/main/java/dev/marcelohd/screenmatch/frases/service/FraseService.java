package dev.marcelohd.screenmatch.frases.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcelohd.screenmatch.frases.model.Frase;
import dev.marcelohd.screenmatch.frases.model.FraseDTO;
import dev.marcelohd.screenmatch.frases.repository.FraseRepository;

@Service
public class FraseService{
   
    @Autowired
    FraseRepository fraseRepository;

    public FraseDTO obterFraseAleatorios(){
        var frase = fraseRepository.obterFrasesAleatorias();
        if(frase.isPresent()){
            Frase f = frase.get();
            return new FraseDTO(f.getFrase(),f.getPersonagem(),f.getPoster(),f.getTitulo());
        } else {
            return null;
        }
        
    }
}