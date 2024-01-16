package com.demo.tpProduit;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "produits")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    private String description;

    private double prix;

    @Column(name = "quantite_en_stock")
    private int quantiteEnStock;

    @Column(name = "date_derniere_commande")
    private LocalDate dateDerniereCommande;

    private double poids;

    private String fournisseur;

    public Produit() {
    }

    public Produit(String nom, String description,
                   double prix, int quantiteEnStock,
                   LocalDate dateDerniereCommande,
                   double poids, String fournisseur) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantiteEnStock = quantiteEnStock;
        this.dateDerniereCommande = dateDerniereCommande;
        this.poids = poids;
        this.fournisseur = fournisseur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    public LocalDate getDateDerniereCommande() {
        return dateDerniereCommande;
    }

    public void setDateDerniereCommande(LocalDate dateDerniereCommande) {
        this.dateDerniereCommande = dateDerniereCommande;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", quantiteEnStock=" + quantiteEnStock +
                ", dateDerniereCommande=" + dateDerniereCommande +
                ", poids=" + poids +
                ", fournisseur='" + fournisseur + '\'' +
                '}';
    }
}
