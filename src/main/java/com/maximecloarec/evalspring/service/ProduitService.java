package com.maximecloarec.evalspring.service;

import com.maximecloarec.evalspring.model.Produit;
import com.maximecloarec.evalspring.exception.ProduitAlreadyExistsException;
import com.maximecloarec.evalspring.exception.ProduitNotFoundException;
import com.maximecloarec.evalspring.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProduitService {
    private ProduitRepository produitRepository;

    //Ajouter
    public Produit addProduit(Produit produit) {
        if(produitRepository.existsByNom(produit.getNom())){
            throw new ProduitAlreadyExistsException("Un produit avec le nom " + produit.getNom() + " existe déja en base de donnée");
        }
        return produitRepository.save(produit);
    }

    //Récupérer tous les produits
    public List<Produit> getAllProduit() {
        if (produitRepository.count() == 0) {
            throw new ProduitNotFoundException("La liste des produits est vide");
        }
        return (List<Produit>) produitRepository.findAll();
    }

    //Récupérer un produit par son ID
    public Optional<Produit> getProduitById(Integer id) {
        return Optional.of(produitRepository.findById(id).orElseThrow(() -> new ProduitNotFoundException("Le produit avec l'id " + id + " n'existe pas")));
    }
}
