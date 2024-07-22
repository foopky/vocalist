package com.example.vocalist.service;

import com.example.vocalist.dto.VocaForm;
import com.example.vocalist.entity.Bookmarked;
import com.example.vocalist.repository.BookmarkedRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class BookmarkedService {
    @Autowired
    private BookmarkedRepository bookmarkedRepository;

    public boolean update(VocaForm vocaForm) {
        Bookmarked bookmarked = vocaForm.toBookmarked();
        log.info(bookmarked.toString());
        Bookmarked target = bookmarkedRepository.findById(bookmarked.getId()).orElse(null);
        if (target!=null){
            bookmarkedRepository.save(bookmarked);
            return true;
        }
        return false;
    }

    public void delete(Long id) {
        Bookmarked deleted = bookmarkedRepository.findById(id).orElse(null);
        if (deleted!=null){
            bookmarkedRepository.delete(deleted);
        }
    }
}
