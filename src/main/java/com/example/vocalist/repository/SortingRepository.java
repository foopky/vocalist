package com.example.vocalist.repository;

import com.example.vocalist.entity.Vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface
 SortingRepository extends JpaRepository<Vocabulary,Long> {
    List<Vocabulary> findAllByOrderByIdAsc();
    List<Vocabulary> findAllByOrderByWordAsc();
    List<Vocabulary> findAllByOrderByImportanceAsc();
    List<Vocabulary> findAllByOrderByCountAsc();
    List<Vocabulary> findAllByOrderByIdDesc();
    List<Vocabulary> findAllByOrderByWordDesc();
    List<Vocabulary> findAllByOrderByImportanceDesc();
    List<Vocabulary> findAllByOrderByCountDesc();
}
