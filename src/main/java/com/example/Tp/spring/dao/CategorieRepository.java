package com.example.Tp.spring.dao;

import com.example.Tp.spring.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie , Long> {
}
