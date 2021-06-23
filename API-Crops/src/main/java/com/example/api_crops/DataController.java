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
@RequestMapping(path = "/datas")

public class DataController {
    
    @Autowired
    private DataRepository dataRepository;
    // Seleciona Todas as Data
    @GetMapping
    public @ResponseBody  Iterable<Data> obterDatas(){
        return dataRepository.findAll();
    }
    // Seleciona um  Data
    @GetMapping(value = "{id}")
    public @ResponseBody Optional<Data> obterData(@PathVariable Integer id){
        return dataRepository.findById(id);
    }
    // Inseri um Data
    @PostMapping
    public @ResponseBody Data cadastraData(@RequestBody Data data){
        Data novaData = new Data();
        novaData.setDataSemeadura(data.getDataSemeadura());
        novaData.setDataColheita(data.getDataColheita());
        return dataRepository.save(novaData);
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> excluirData(@PathVariable Integer id){
        Optional<Data> vari = dataRepository.findById(id);
        if (vari.isPresent()){
            dataRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping(value="{id}")
    public ResponseEntity<Object> alterarData(@PathVariable Integer id, @RequestBody Data data) {
        Optional<Data> dat = dataRepository.findById(id);
        if (!dat.isPresent()){
            return ResponseEntity.notFound().build();
        }
        data.setCodigoData(id);
        dataRepository.save(data);
        return ResponseEntity.status(201).build();
    }
}
