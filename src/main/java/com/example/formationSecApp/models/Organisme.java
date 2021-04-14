package com.example.formationSecApp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Organisme implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="organisme_id")
    private long id ;
    private String libelle;

    @OneToMany(mappedBy="organisme")
    @JsonIgnore
    private List<Session> sessions;

    @OneToMany(mappedBy="organisme")
    @JsonIgnore
    private List<Formateur> formateurs;

    public Organisme()
    {}

    public Organisme(long id, String libelle) {
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
