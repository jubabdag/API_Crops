package com.example.api_crops;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping(path = "/culturas")
@CrossOrigin(maxAge = 3600)

public class CulturaController {
    
    @Autowired
    private CulturaRepository culturaRepository;
    // Seleciona Todas as Culturas
    @GetMapping
    public @ResponseBody  Iterable<Cultura> obterCulturas(){
        return culturaRepository.findAll();
    }
    // Seleciona um  Cultura
    @GetMapping(value = "{id}")
    public @ResponseBody Optional<Cultura> obterCultura(@PathVariable Integer id){
        return culturaRepository.findById(id);
    }
    // Seleciona a Cultura pelo nome
    @GetMapping("/Busca")
    public @ResponseBody List<Cultura> obterCulturaPorNome(@RequestParam String nome){
        return culturaRepository.findByNomeIgnoreCaseContaining(nome);
    }
    // Inseri um Cultura
    @PostMapping
    public @ResponseBody Cultura cadastrarCultura(@RequestBody Cultura cultura){
        Cultura novaCultura = new Cultura();
        novaCultura.setNome(cultura.getNome());
        return culturaRepository.save(novaCultura);
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> excluirCultura(@PathVariable Integer id){
        Optional<Cultura> cult = culturaRepository.findById(id);
        if (cult.isPresent()){
            culturaRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping(value="{id}")
    public ResponseEntity<Object> alterarCultura(@PathVariable Integer id, @RequestBody Cultura cultura) {
        Optional<Cultura> cult = culturaRepository.findById(id);
        if (!cult.isPresent()){
            return ResponseEntity.notFound().build();
        }
        cultura.setCodigoCultura(id);
        culturaRepository.save(cultura);
        return ResponseEntity.status(201).build();
    }
}
