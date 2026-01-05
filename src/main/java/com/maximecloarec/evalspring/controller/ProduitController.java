package com.maximecloarec.evalspring.controller;

import com.maximecloarec.evalspring.model.Produit;
import com.maximecloarec.evalspring.service.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ProduitController {

    private ProduitService produitService;

    //Récupérer un produit
    @GetMapping("/api/produit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Produit> getProduit(@PathVariable Integer id) {
        return produitService.getProduitById(id);
    }

    @GetMapping("/api/produits")
    @ResponseStatus(HttpStatus.OK)
    public List<Produit> getProduits() {
        return produitService.getAllProduit();
    }

    @PostMapping("/api/produit")
    @ResponseStatus(HttpStatus.CREATED)
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.addProduit(produit);
    }
}
