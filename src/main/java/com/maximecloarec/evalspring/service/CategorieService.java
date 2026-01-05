package com.maximecloarec.evalspring.service;

import com.maximecloarec.evalspring.entity.Categorie;
import com.maximecloarec.evalspring.exception.CategorieAlreadyExistsException;
import com.maximecloarec.evalspring.exception.CategorieNotFoundException;
import com.maximecloarec.evalspring.repository.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategorieService {
    private CategorieRepository categorieRepository;

    //Ajouter
    public Categorie addCategorie(Categorie categorie) {
        if (categorieRepository.existsByLibele(categorie.getLibele())) {
            throw new CategorieAlreadyExistsException("Une categorie avec le libele " + categorie.getLibele() + " existe déja");
        }
        return categorieRepository.save(categorie);
    }

    //Récupérer toutes les catégories
    public List<Categorie> getAllCategorie() {
        if (categorieRepository.count() == 0) {
            throw new CategorieNotFoundException("La liste de categorie est vide");
        }
        return (List<Categorie>) categorieRepository.findAll();
    }

    //Récupérer une catégorie par son id
    public Optional<Categorie> getCategorieById(Integer id) {
        return Optional.of(categorieRepository.findById(id).orElseThrow(() -> new CategorieNotFoundException("Il n'existe pas de categorie avec l'id " + id)));
    }
}
