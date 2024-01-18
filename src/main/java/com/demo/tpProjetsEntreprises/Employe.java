package com.demo.tpProjetsEntreprises;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employes")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String prenom;
    private String nom;
    @ManyToOne
    private Entreprise entreprise;

    @ManyToMany
    @JoinTable(
            name="projets_employes",
            joinColumns = @JoinColumn(name="participant_id"),
            inverseJoinColumns = @JoinColumn(name="projet_id")
    )
    private List<Projet> projets = new ArrayList<>();

    public Employe() {
    }

    public Employe(String prenom, String nom, Entreprise entreprise) {
        this.prenom = prenom;
        this.nom = nom;
        this.entreprise = entreprise;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

    public void addProjet(Projet projet) {
        projets.add(projet);
    }

    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
