package com.example.Tp.spring.dao;

import com.example.Tp.spring.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository <Tag ,Long> {
}
