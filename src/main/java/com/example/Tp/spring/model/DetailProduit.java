package com.example.Tp.spring.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@AllArgsConstructor

@Entity
public class DetailProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String fabricant;
    private String paysOrigine;
    private String composition;
    private String dosage;
    private String indications;
}
