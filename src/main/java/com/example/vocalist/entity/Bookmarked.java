package com.example.vocalist.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Bookmarked {
    @Id
    private Long id;
    @Column
    private String word;
    @Column
    private String meaning;
    @Column
    private Integer importance;
    @Column
    private Integer count;
}
