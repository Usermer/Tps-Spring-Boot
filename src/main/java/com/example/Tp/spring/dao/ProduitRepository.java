package com.example.Tp.spring.dao;

import com.example.Tp.spring.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit ,Long> {
}
