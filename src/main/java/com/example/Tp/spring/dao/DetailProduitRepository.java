package com.example.Tp.spring.dao;

import com.example.Tp.spring.model.DetailProduit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailProduitRepository extends JpaRepository <DetailProduit,Long> {
}
