package com.maximecloarec.evalspring.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "categorie")
@Data

public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Le champs ne peut pas être vide")
    @Length(min=2,message = "Le libele doit avoir au minimum 2 caractère")
    private String libele;

}
