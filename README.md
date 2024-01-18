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

## tpProjetsEntreprises
### Database name : tp_projets_entreprises
### persistence-unit name : tpProjets
#
#
# Tasks
#
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
#
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
#
## TP Chien (ManyToOne)
### - créer le classe Chien
### - créer un relation @ManyToOne qui permet d’ajouter un maitre à un Chien
###   (Une personne pourra être le maitre de plusieurs chiens)
### - Affecter des Personnes à des Chiens et Vérifier que les données sont correctement enregistrées en base de données
#
## TP Sport (ManytoMany)
### On souhaite avoir une table SQL sports.
### Faire en sorte qu'une personne puisse pratiquer plusieurs sports.
### Et qu'un sport puisse être pratiqué par plusieurs personnes.
#
## TP Projets d’entreprises

### Créer un projet dans lequel on manipule des :
### - Entreprises
### - Employés
### - Projets

### Voici les règles à respecter:
### - Une entreprise contient une liste d’employés
### - Un employé peut participer à plusieurs projets et un projet implique plusieurs employés
### - Un employé appartient à une seule entreprise

### Objectif:
### Créer les Entity et DAO JPA ainsi que les tables SQL pour tester les différents “Use Cases”