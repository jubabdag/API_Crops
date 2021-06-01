package com.example.api_crops;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping(path = "/dicas")
public class DicasController {
       
    @Autowired
    private DicasRepository dicasRepository;
    // Seleciona Todas as Dicas
    @GetMapping
    public @ResponseBody  Iterable<Dicas> obterDica(){
        return dicasRepository.findAll();
    }
    // Seleciona um  Dica
    @GetMapping(value = "{id}")
    public @ResponseBody Optional<Dicas> obterDica(@PathVariable Integer id){
        return dicasRepository.findById(id);
    }
    // Inseri um Dica
    @PostMapping
    public @ResponseBody Dicas cadastrarDica(@RequestBody Dicas dicas){
        Dicas novaDica = new Dicas();
        novaDica.setNomeDicas(dicas.getNomeDicas());;
        novaDica.setDescricaoDicas(dicas.getDescricaoDicas());
        return dicasRepository.save(novaDica);
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> excluirDica(@PathVariable Integer id){
        Optional<Dicas> dica = dicasRepository.findById(id);
        if (dica.isPresent()){
            dicasRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping(value="{id}")
    public ResponseEntity<Object> alterarDica(@PathVariable Integer id, @RequestBody Dicas dicas) {
        Optional<Dicas> dica = dicasRepository.findById(id);
        if (!dica.isPresent()){
            return ResponseEntity.notFound().build();
        }
        dicas.setCodigoDicas(id);
        dicasRepository.save(dicas);
        return ResponseEntity.status(201).build();
    }

}
