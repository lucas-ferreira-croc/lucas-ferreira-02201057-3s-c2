package com.provacontinuada.controle;

import com.provacontinuada.dominio.Lutador;
import com.provacontinuada.repositorio.LutadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/lutadores")
public class LutadorController {

    @Autowired
    private LutadorRepository repository;

    @PostMapping
    public ResponseEntity postLutador(@RequestBody @Valid Lutador novoLutador){
        repository.save(novoLutador);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getLutador(){

        return ResponseEntity.status(200).body(repository.findByOrderByForcaGolpeDesc());
    }

    @GetMapping("/contagem-vivos")
    public ResponseEntity getLutadorVivo(){

        return  ResponseEntity.status(200).body(repository.findByVidaGreaterThan(0.0));


    }

    @GetMapping("/mortos")
    public ResponseEntity getMortos(){
        return ResponseEntity.status(200).body(repository.findByVidaLessThanEqual(0.0));
    }

}
