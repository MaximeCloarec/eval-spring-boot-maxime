package com.maximecloarec.evalspring.repository;

import com.maximecloarec.evalspring.entity.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie,Integer> {
    boolean existsByLibele(String libele);
}
