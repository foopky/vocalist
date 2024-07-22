package com.example.vocalist.repository;

import com.example.vocalist.entity.Vocabulary;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface VocaRepository extends CrudRepository<Vocabulary,Long> {
    @Override
    ArrayList<Vocabulary> findAll();
}
