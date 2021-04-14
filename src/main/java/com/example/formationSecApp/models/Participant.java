package com.example.formationSecApp.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Participant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private long tel ;
    private String mail;


    private Organisme organisme;

    @ManyToOne(optional = false)
    public Organisme getOrganisme() {
        return organisme;
    }

    public void setOrganisme(Organisme organisme) {
        this.organisme = organisme;
    }
    public Participant()
    {}
    public Participant(long id, String nom, String prenom, long tel, String mail,Organisme organisme,Profil profil, Set<Session> sessions, Pays pays) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.mail = mail;
        this.organisme = organisme;
        this.profil = profil;
       // this.sessions = sessions;
        this.pays = pays;
    }

    private Profil profil;

    /*@ManyToMany(fetch= FetchType.EAGER, mappedBy = "participants")
    @JsonIgnore
    private Set<Session> sessions = new HashSet<Session>();*/

    /*@ManyToMany
    @JoinTable(name = "PARTICIPANT_SESSSIONS", joinColumns = {
            @JoinColumn(name = "PARTICIPANT_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "SESSION_ID") })
    private Set<Session> sessions;*/


    private Pays pays;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @ManyToOne(optional = false)
    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    @ManyToOne(optional = false)
    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }
}
