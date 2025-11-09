package com.example.Tp.spring.controller;

import com.example.Tp.spring.dao.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitRepository produitRepository;


    @GetMapping("/liste")
    public String afficherListeProduits(Model model) {

        model.addAttribute("produits", produitRepository.findAll());

        return "produits";
    }
}
