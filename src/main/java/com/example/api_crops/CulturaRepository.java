package com.example.api_crops;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CulturaRepository extends CrudRepository <Cultura, Integer>{
    List<Cultura> findByNomeIgnoreCaseContaining(String Nome);
}