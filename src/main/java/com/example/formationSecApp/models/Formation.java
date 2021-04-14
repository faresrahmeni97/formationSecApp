package com.example.formationSecApp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Formation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="formation_id")
    private long id;
    private String titre;
    private String type_formation;
    private int annee;
    private int nbSession;
    private int duree;
    private int budget;
    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
    public Formation(){};



    private Domaine domaine;


    @OneToMany(mappedBy="formation")
    @JsonIgnore
    private List<Session> sessions;

    public Formation(long id, String titre, String type_formation, int annee, int nbSession, int duree, int budget,Domaine domaine) {
        this.id = id;
        this.titre = titre;
        this.type_formation = type_formation;
        this.annee = annee;
        this.nbSession = nbSession;
        this.duree = duree;
        this.budget = budget;
        this.domaine = domaine;
    }


/*@ManyToMany (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "FORMATION_SESSION", joinColumns = {
            @JoinColumn(name = "FORMATION_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "SESSION_ID") })
    @JsonIgnore
    private Set<Session> sessions;*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType_formation() {
        return type_formation;
    }

    public void setType_formation(String type_formation) {
        this.type_formation = type_formation;
    }

    public int getNbSession() {
        return nbSession;
    }

    public void setNbSession(int nbSession) {
        this.nbSession = nbSession;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "domaine_code", referencedColumnName = "domaine_id")
    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }
}
