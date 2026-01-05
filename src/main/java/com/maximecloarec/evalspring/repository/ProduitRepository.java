package com.maximecloarec.evalspring.repository;

import com.maximecloarec.evalspring.entity.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Integer> {

    boolean existsByNom(String nom);
}
