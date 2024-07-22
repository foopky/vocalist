package com.example.vocalist.controller;

import com.example.vocalist.entity.Bookmarked;
import com.example.vocalist.entity.Vocabulary;
import com.example.vocalist.repository.BookmarkedRepository;
import com.example.vocalist.repository.VocaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class BookmarkedController {
    @Autowired
    private VocaRepository vocaRepository;
    @Autowired
    private BookmarkedRepository bookmarkedRepository;

    @PostMapping("/Bookmarked/{id}")
    public String addbookmark(@PathVariable Long id){
        Vocabulary vocabulary = vocaRepository.findById(id).orElse(null);
        Bookmarked bookmarked = vocabulary.toBookmarked();
        log.info(bookmarked.toString());
        Bookmarked result = bookmarkedRepository.save(bookmarked);
        log.info(result.toString());
        return "redirect:/voca/index";
    }

    @GetMapping("/Bookmarked/{id}/delete")
    public String deletebookmark(@PathVariable Long id){
        Bookmarked target = bookmarkedRepository.findById(id).orElse(null);
        bookmarkedRepository.delete(target);
        return "redirect:/Bookmarks";
    }

    @GetMapping("/Bookmarks")
    public String showbookmarks(Model model){
        List<Bookmarked> bookmarks = bookmarkedRepository.findAll();
        log.info(bookmarks.toString());
        model.addAttribute("Bookmarks", bookmarks);
        return "pages/bookmarks";
    }


}
