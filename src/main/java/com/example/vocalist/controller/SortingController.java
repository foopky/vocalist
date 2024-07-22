package com.example.vocalist.controller;

import com.example.vocalist.entity.Vocabulary;
import com.example.vocalist.repository.SortingRepository;
import com.example.vocalist.repository.VocaRepository;
import com.example.vocalist.service.VocaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class SortingController {
    @Autowired
    private VocaService vocaService;
    @GetMapping("/voca/sort")
    public String order(Model model, @RequestParam("condition") Integer condition){
        List<Vocabulary> Vocabularies = vocaService.show(condition);
        model.addAttribute("vocabularies",Vocabularies);
        return "pages/index";
    }
}
