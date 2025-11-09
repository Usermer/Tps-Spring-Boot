package com.example.Tp.spring.controller;

import com.example.Tp.spring.dao.*;
import com.example.Tp.spring.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProduitRestController {

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Autowired
    private DetailProduitRepository detailProduitRepository;
    @Autowired
    private TagRepository tagRepository;

    //  Récupérer tous les produits
    @GetMapping("/produits")
    public List<Produit> getProduits() {
        return produitRepository.findAll();
    }

    // Récupérer toutes les catégories
    @GetMapping("/categories")
    public List<Categorie> getCategories() {
        return categorieRepository.findAll();
    }

    // Récupérer tous les fournisseurs
    @GetMapping("/fournisseurs")
    public List<Fournisseur> getFournisseurs() {
        return fournisseurRepository.findAll();
    }

    // Récupérer tous les tags
    @GetMapping("/tags")
    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    // Récupérer un produit par id
    @GetMapping("/produits/{id}")
    public Produit getProduitById(@PathVariable("id") long id) {
        return produitRepository.findById(id).orElse(null);
    }

    //  Ajouter un nouveau produit
    @PostMapping("/produits")
    public Produit ajouterProduit(@RequestBody Produit p) {
        // si le produit contient des objets liés (catégorie, fournisseur, etc.),
        // il faut s’assurer qu’ils existent déjà
        if (p.getCategorie() != null && p.getCategorie().getId() != null) {
            p.setCategorie(categorieRepository.findById(p.getCategorie().getId()).orElse(null));
        }
        if (p.getFournisseur() != null && p.getFournisseur().getId() != null) {
            p.setFournisseur(fournisseurRepository.findById(p.getFournisseur().getId()).orElse(null));
        }

        if (p.getTags() != null && !p.getTags().isEmpty()) {
            p.setTags(tagRepository.findAllById(
                    p.getTags().stream().map(Tag::getId).toList()
            ));
        }

        return produitRepository.save(p);
    }

    // Modifier un produit existant
    @PutMapping("/produits/{id}")
    public Produit modifierProduit(@PathVariable("id") long id, @RequestBody Produit p1) {
        return produitRepository.findById(id).map(produit -> {
            produit.setNom(p1.getNom());
            produit.setDescription(p1.getDescription());
            produit.setPrix(p1.getPrix());
            produit.setCodeBarre(p1.getCodeBarre());
            produit.setDateExpiration(p1.getDateExpiration());

            if (p1.getCategorie() != null && p1.getCategorie().getId() != null) {
                produit.setCategorie(categorieRepository.findById(p1.getCategorie().getId()).orElse(null));
            }
            if (p1.getFournisseur() != null && p1.getFournisseur().getId() != null) {
                produit.setFournisseur(fournisseurRepository.findById(p1.getFournisseur().getId()).orElse(null));
            }

            if (p1.getTags() != null && !p1.getTags().isEmpty()) {
                produit.setTags(tagRepository.findAllById(
                        p1.getTags().stream().map(Tag::getId).toList()
                ));
            }

            return produitRepository.save(produit);
        }).orElse(null);
    }
    @DeleteMapping("/produits/{id}")
    public void deletePersonne(@PathVariable("id") long id) {
        produitRepository.deleteById(id);
    }

}
