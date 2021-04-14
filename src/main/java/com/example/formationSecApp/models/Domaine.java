package com.example.formationSecApp.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Domaine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="domaine_id")
    private long id ;
    private String libelle;


    public Domaine(long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    public Domaine()
    {};
    @Column(name = "domaine_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
