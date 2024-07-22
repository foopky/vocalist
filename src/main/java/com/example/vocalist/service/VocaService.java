package com.example.vocalist.service;

import com.example.vocalist.entity.Vocabulary;
import com.example.vocalist.repository.SortingRepository;
import com.example.vocalist.repository.VocaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class VocaService {
    @Autowired
    private VocaRepository vocaRepository;
    @Autowired
    private SortingRepository sortingRepository;

    // 0: default 1: OrderById 2: OrderByWord 3: OrderByImportance 4: OrderByCount
    private int showtype=0;

    public List<Vocabulary> show(Integer type){
        if (type!=null){
            this.showtype=type;
        }
        List<Vocabulary> vocabularies = switch (this.showtype) {
            case 1 -> sortingRepository.findAllByOrderByIdDesc();
            case 2 -> sortingRepository.findAllByOrderByWordDesc();
            case 3 -> sortingRepository.findAllByOrderByImportanceDesc();
            case 4 -> sortingRepository.findAllByOrderByCountDesc();
            case 5 -> sortingRepository.findAllByOrderByIdAsc();
            case 6 -> sortingRepository.findAllByOrderByWordAsc();
            case 7 -> sortingRepository.findAllByOrderByImportanceAsc();
            case 8 -> sortingRepository.findAllByOrderByCountAsc();
            default -> sortingRepository.findAll();
        };
        return vocabularies;
    }
}
