package com.example.vocalist.controller;

import com.example.vocalist.dto.VocaForm;
import com.example.vocalist.entity.Bookmarked;
import com.example.vocalist.entity.Vocabulary;
import com.example.vocalist.repository.BookmarkedRepository;
import com.example.vocalist.repository.VocaRepository;
import com.example.vocalist.service.BookmarkedService;
import com.example.vocalist.service.VocaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class VocaController {

    @Autowired
    private VocaRepository vocaRepository;
    @Autowired
    private VocaService vocaService;
    @Autowired
    private BookmarkedService bookmarkedService;

    @GetMapping("/voca/index")
    public String index(Model model){
        List<Vocabulary> vocabularies = vocaService.show(null);
        model.addAttribute("vocabularies",vocabularies);
        return "pages/index";
    }

    @GetMapping("voca/{id}/increase")
    public String countincrease(Model model, @PathVariable Long id){
        Vocabulary vocaEntity=vocaRepository.findById(id).orElse(null);
        if (vocaEntity!=null){
            vocaEntity.setCount(vocaEntity.getCount()+1);
            vocaRepository.save(vocaEntity);
        }
        return "redirect:/voca/index";
    }

    @GetMapping("voca/{id}/decrease")
    public String countdecrease(Model model, @PathVariable Long id){
        Vocabulary vocaEntity=vocaRepository.findById(id).orElse(null);
        if (vocaEntity!=null){
            vocaEntity.setCount(vocaEntity.getCount()-1);
            vocaRepository.save(vocaEntity);
        }
        return "redirect:/voca/index";
    }
    @GetMapping("voca/{id}/edit")
    public String edit(Model model, @PathVariable Long id){
        Vocabulary vocaEntity = vocaRepository.findById(id).orElse(null);
        log.info(vocaEntity.toString());
        model.addAttribute("vocabulary", vocaEntity);
        return "pages/edit";
    }
    @PostMapping("voca/{id}/update")
    public String update(VocaForm vocaForm){
        log.info("update: " + vocaForm.toString());
        Vocabulary vocaEntity = vocaForm.toEntity();
        Vocabulary target = vocaRepository.findById(vocaEntity.getId()).orElse(null);
        if (target!=null){
            vocaRepository.save(vocaEntity);
            bookmarkedService.update(vocaForm);
        }
        return "redirect:/voca/index";
    }
    @GetMapping("/voca/new")
    public String showform(){
        return "pages/new";
    }

    @PostMapping("/voca/create")
    public String createvoca(VocaForm vocaForm){
        // DTO를 Entity로 변환하기
        log.info(vocaForm.toString());
        Vocabulary vocabulary = vocaForm.toEntity();
        log.info(vocabulary.toString());
        // Entity를 Repository를 통해 DB에 저장
        Vocabulary saved = vocaRepository.save(vocabulary);
        log.info(saved.toString());
        return "pages/new";
    }



    @GetMapping("/voca/{id}/delete")
    public String delete(@PathVariable Long id){
        Vocabulary target = vocaRepository.findById(id).orElse(null);
        if (target!=null){
            vocaRepository.delete(target);
            bookmarkedService.delete(id);
        }
        return "redirect:/voca/index";
    }
}
