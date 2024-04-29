package com.example.javacrm.dal.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Article_produit extends Article{

    @Column(name = "reference")
    private String reference = "PD-"+getId();
}
