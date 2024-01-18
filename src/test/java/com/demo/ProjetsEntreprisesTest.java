package com.demo;

import com.demo.tpProjetsEntreprises.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProjetsEntreprisesTest
{
    @Test
    public void testSaveEnrepriseEmployes(){
        DAO<Entreprise> daoEntreprise = new DAO<>(Entreprise.class);
        DAO<Employe> daoEmploye = new DAO<>(Employe.class);

        // Creation Entreprise
        Entreprise google = new Entreprise("Google");
        daoEntreprise.save(google);
        Entreprise apple = new Entreprise("Apple");
        daoEntreprise.save(apple);
        // Récuperation Entreprise
//        Entreprise google = daoEntreprise.findAll().get(0);

        // Insertion Employes
        Employe e1 = new Employe("Howard", "Smith", google);
        daoEmploye.save(e1);
        Employe e2 = new Employe("Jane", "Rogers", google);
        daoEmploye.save(e2);
        Employe e3 = new Employe("Dave", "Milton", google);
        daoEmploye.save(e3);
        Employe e4 = new Employe("Hank", "Ford", google);
        daoEmploye.save(e4);
        Employe e5 = new Employe("Francis", "Stevens", apple);
        daoEmploye.save(e5);
        Employe e6 = new Employe("Steven", "Dale", apple);
        daoEmploye.save(e6);

        daoEntreprise.update(google);

    }

    @Test
    public void testSaveProjet(){
        DAO<Projet> daoProjet = new DAO<>(Projet.class);

        Projet p1 = new Projet("Google AB Testing");
        daoProjet.save(p1);
        Projet p2 = new Projet("Apple Music");
        daoProjet.save(p2);
        Projet p3 = new Projet("Apple TV+");
        daoProjet.save(p3);

    }

    @Test
    public void testUpdateProjet(){
        DAO<Projet> daoProjet = new DAO<>(Projet.class);
        DAO<Employe> daoEmploye = new DAO<>(Employe.class);

//        Projet p1 = daoProjet.findAll().get(0);
//        Employe e1 = daoEmploye.findAll().get(0);
//        p1.addParticipant(e1);
//        daoProjet.update(p1);

        // Get all Apple employees
        List<Employe> appleEmployes = daoEmploye.findAll()
                .stream()
                .filter(e -> e.getEntreprise().getNom().equals("Apple"))
                .toList();
        // Get Apple Projects
        Projet p2 = daoProjet.findById(2);
        Projet p3 = daoProjet.findById(3);

//        Employe e3 = appleEmployes.get(0);
//        p2.addParticipant(e3);
//        daoProjet.update(p2);

        Employe e4 = appleEmployes.get(1);
        p2.addParticipant(e4);
        p3.addParticipant(e4);
        daoProjet.update(p2);
        daoProjet.update(p3);
//
//        Employe e5 = appleEmployes.get(2);
//        p3.addParticipant(e5);
//        daoProjet.update(p3);
//
//        Employe e6 = appleEmployes.get(3);
//        e6.addProjet(p3);
//        daoEmploye.update(e6);
    }

    @Test
    public void testUpdateEmploye() {
        DAO<Employe> daoEmploye = new DAO<>(Employe.class);
        DAO<Entreprise> daoEntreprise = new DAO<>(Entreprise.class);

        Entreprise apple = daoEntreprise.findById(2);

        Employe e3 = daoEmploye.findById(3);
        e3.setEntreprise(apple);
        daoEmploye.update(e3);

        Employe e4 = daoEmploye.findById(4);
        e4.setEntreprise(apple);
        daoEmploye.update(e4);

    }

    @Test
    public void testSaveClient(){
        DAO<Projet> daoProjet = new DAO<>(Projet.class);
        DAO<Client> daoClient = new DAO<>(Client.class);

        Client deezer = new Client("Deezer");
        Projet p1 = daoProjet.findById(1);
        daoClient.save(deezer);

        p1.setClient(deezer);
        daoProjet.update(p1);

        Projet p2 = daoProjet.findById(2);
        p2.setClient(daoClient.findById(1));
        daoProjet.update(p2);

        Projet p3 = daoProjet.findById(3);
        p3.setClient(daoClient.findById(2));
        daoProjet.update(p3);

        //System.out.println(deezer);


    }

    @Test
    public void testUpdateProjetDescription(){
        DAO<Projet> daoProjet = new DAO<>(Projet.class);

        Projet projet = daoProjet.findById(1);
        projet.setDescription("Some Google project description goes here.");
        daoProjet.update(projet);
    }
}
