package com.example.Tp.spring.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@Data
@AllArgsConstructor


@Entity


public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private BigDecimal prix;
    private String codeBarre;
    private LocalDate dateExpiration;


    @ManyToOne
    private Categorie categorie;

    @ManyToOne
    private Fournisseur fournisseur;

    @OneToOne(cascade = CascadeType.ALL)
    private DetailProduit detailProduit;

    @ManyToMany
    @JoinTable(
            name = "produit_tag",
            joinColumns = @JoinColumn(name = "produit_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;



}
