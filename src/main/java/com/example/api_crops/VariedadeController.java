package com.example.api_crops;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping(path = "/variedades")
@CrossOrigin(maxAge = 3600)

public class VariedadeController {
    
    @Autowired
    private VariedadeRepository variedadeRepository;
    // Selecionar todas as variedades
    @GetMapping
    public @ResponseBody  Iterable<Variedade> obterVariedades(){
        return variedadeRepository.findAll();
    }
    // Selecionar uma  variedade
    @GetMapping(value = "{id}")
    public @ResponseBody Optional<Variedade> obterVariedade(@PathVariable Integer id){
        return variedadeRepository.findById(id);
    }
    // Selecionar a variedade pelo nome
    @GetMapping("/Busca")
    public @ResponseBody List<Variedade> obterVariedadePorNome(@RequestParam String nome){
        return variedadeRepository.findByNomeIgnoreCaseContaining(nome);
    }

    // Inserir uma variedade
    @PostMapping
    public ResponseEntity<Object> cadastrarVariedade(@RequestBody Variedade variedade) {
        if(variedadeRepository.save(variedade) != null) {
            return ResponseEntity.status(201).build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    // Excluir uma variedade
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> excluirVariedade(@PathVariable Integer id){
        Optional<Variedade> vari = variedadeRepository.findById(id);
        if (vari.isPresent()){
            variedadeRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.notFound().build();
    }
    // Atualizar uma variedade
    @PutMapping(value="{id}")
    public ResponseEntity<Object> alterarVariedade(@PathVariable Integer id, @RequestBody Variedade variedade) {
        Optional<Variedade> vari = variedadeRepository.findById(id);
        if (!vari.isPresent()){
            return ResponseEntity.notFound().build();
        }
        variedade.setCodigoVariedade(id);
        variedadeRepository.save(variedade);
        return ResponseEntity.status(201).build();
    }
}


