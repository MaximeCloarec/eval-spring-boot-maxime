package com.maximecloarec.evalspring.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "produit")
@Data

public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @NotNull(message = "Le champs ne peut pas être vide")
    @Length(min = 2, max = 50,message = "Le nom doit être compris entre 2 et 50 caractères")
    private String nom;

    @Column(nullable = false)
    @NotBlank(message = "Le champs ne peut pas être vide")
    @Positive(message = "Le prix doit être positif et supérieur à zéro")
    private Integer prix;
}
