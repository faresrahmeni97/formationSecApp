package com.example.formationSecApp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Session implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date_deb;
    private Date date_fin;
    private long nbparticipant;
    private String lieu;


   // @JsonIgnoreProperties("sessions")
   @ManyToOne(optional = true)
   @JoinColumn(name="formation_id")
    private Formation formation;


   // @JsonIgnoreProperties("sessions")
   @ManyToOne(optional = true)
   @JoinColumn(name="organisme_id")
    private Organisme organisme;

    @ManyToOne(optional = true)
    @JoinColumn(name="formateur_id")
    private Formateur formateur;

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }
// @JsonIgnoreProperties("sessions")
    //private Formateur formateur;

    /*@ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "SESSION_PARTICIPANT",
            joinColumns = { @JoinColumn(name = "SESSION_ID")},
            inverseJoinColumns = { @JoinColumn(name = "PARTICIPANT_ID")})
    private Set<Participant> participants = new HashSet<Participant>(); */


    public Session(){

    };
        public Session(long id, Date date_deb, Date date_fin, long nbparticipant, String lieu, Formation formation, Organisme organisme, Formateur formateur, Set<Participant> participants) {
        this.id = id;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.nbparticipant = nbparticipant;
        this.lieu = lieu;
        this.formation = formation;
        this.organisme = organisme;
     this.formateur = formateur;
  //      this.participants = participants;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate_deb() {
        return date_deb;
    }

    public void setDate_deb(Date date_deb) {
        this.date_deb = date_deb;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public long getNbparticipant() {
        return nbparticipant;
    }

    public void setNbparticipant(long nbparticipant) {
        this.nbparticipant = nbparticipant;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Organisme getOrganisme() {
        return organisme;
    }

    public void setOrganisme(Organisme organisme) {
        this.organisme = organisme;
    }

   /*
    public Set<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }*/
}
