package com.maximecloarec.evalspring.controller;

import com.maximecloarec.evalspring.entity.Categorie;
import com.maximecloarec.evalspring.service.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CategorieController {
    private CategorieService categorieService;

    //Créer une categorie
    @PostMapping("/api/categorie")
    @ResponseStatus(HttpStatus.CREATED)
    public Categorie createCategorie(@RequestBody Categorie categorie) {
        return categorieService.addCategorie(categorie);
    }
}
