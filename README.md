# Database Setup Info

## Demo
### Database name : poe20231204demo
### persistence-unit name : demojpa

## tpProduit
### Database name : stock
### persistence-unit name : tpProduit

## tpVoiture
### Database name : tp_voitures
### persistence-unit name : tpVoiture
#
#
# Tasks

## TP Produit

### - Créer une nouvelle base de données : stock
### - Créer un nouveau projet et le configurer pour se connecter à la base de données
### - Créer un Entity Produit pour un système de gestion de stock, dont voici les attributs:
###     id,
###     nom,
###     description,
###     prix,
###     quantiteEnStock,
###     dateDerniereCommande,
###     poids,
###     fournisseur
### - Créer un **DAO** pour lire, écrire et supprimer des objets de ce type dans la base : create(), findAll(),findById(), delete()
### - Ecrire du code pour tester chacun des cas (éventuellement dans des JUnit)

##
## TP Voiture

### Voici le script d’un schéma sql que vous devez exécuter dans une base de données tp_voitures

###     CREATE TABLE voitures (
###         id SERIAL PRIMARY KEY,
###         marque VARCHAR(50),
###         modele VARCHAR(50),
###         annee_fabrication INTEGER,
###         immatriculation VARCHAR(20),
###         kilometrage INTEGER
###     );

### Il vous est demandé de :
### - Configurer hibernate en mode DDL-auto : validate
### - Ecrivez l’Entity et le DAO pour les opérations CRUD
### - Testez les différentes méthodes du DAO
