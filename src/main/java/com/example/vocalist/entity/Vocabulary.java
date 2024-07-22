package com.example.vocalist.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter

public class Vocabulary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String word;
    @Column
    private String meaning;
    @Column
    private Integer importance;
    @Column
    private Integer count;

    @PrePersist
    protected void onCreate() {
        if (count == null) {
            count = 0;
        }
    }
    public Bookmarked toBookmarked(){
        return new Bookmarked(id,word,meaning,importance,count);
    }
}
