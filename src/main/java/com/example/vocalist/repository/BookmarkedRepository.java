package com.example.vocalist.repository;

import com.example.vocalist.entity.Bookmarked;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface BookmarkedRepository extends CrudRepository<Bookmarked, Long> {
    @Override
    ArrayList<Bookmarked> findAll();
}
