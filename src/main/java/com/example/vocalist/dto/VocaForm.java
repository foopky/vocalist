package com.example.vocalist.dto;


import com.example.vocalist.entity.Bookmarked;
import com.example.vocalist.entity.Vocabulary;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class VocaForm {
    private Long id;
    private String word;
    private String meaning;
    private Integer importance;
    private Integer count;

    public Vocabulary toEntity() {
        return new Vocabulary(id ,word, meaning, importance, count);
    }

    public Bookmarked toBookmarked(){
        return new Bookmarked(id, word, meaning, importance, count);
    }

}
