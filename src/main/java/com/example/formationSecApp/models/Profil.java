package com.example.formationSecApp.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Profil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="profil_id")
    private long id;
    private String libelle;
    public Profil()
    {};
    public Profil(long id, String libelle, List<Participant> participants) {
        this.id = id;
        this.libelle = libelle;
    }


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
