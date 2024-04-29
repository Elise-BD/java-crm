package com.example.javacrm.dal.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Sujet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
}
