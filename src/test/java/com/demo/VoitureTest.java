package com.demo;

import org.junit.jupiter.api.Test;

import com.demo.tpVoiture.Voiture;
import com.demo.tpVoiture.VoitureDAO;

import java.util.List;

public class VoitureTest {

        @Test
        public void testSaveVoiture(){
            Voiture v1 = new Voiture("Toyota",
                    "CH-R", 2020,
                    "FN4578639N", 300);
            VoitureDAO.save(v1);

            Voiture v2 = new Voiture("Renault",
                    "Captur", 2022,
                    "FN3678735H", 120);
            VoitureDAO.save(v2);

            List<Voiture> voitures = VoitureDAO.findAll();
            for (Voiture v : voitures) {
                System.out.println(v);
            }
        }

        @Test
        public void testFindVoitureById(){
            Voiture v = VoitureDAO.findById(3);
            System.out.println(v);
        }

        @Test
        public void testFindAllVoitures(){
            List<Voiture> voitures = VoitureDAO.findAll();
            for (Voiture v : voitures) {
                System.out.println(v);
            }
        }

        @Test
        public void testDeleteVoiture(){
            Voiture v = VoitureDAO.findById(3);
            VoitureDAO.delete(v);

            List<Voiture> voitures = VoitureDAO.findAll();
            for (Voiture voiture : voitures) {
                System.out.println(voiture);
            }
        }

        @Test
        public void testDeleteVoitureById(){
            VoitureDAO.deleteById(4);

            List<Voiture> voitures = VoitureDAO.findAll();
            for (Voiture voiture : voitures) {
                System.out.println(voiture);
            }
        }

        @Test
        public void testUpdateVoiture(){
            Voiture v = VoitureDAO.findById(3);
            System.out.println(v);

            v.setAnneeFabrication(2021);
            v.setKilometrage(350);
            VoitureDAO.update(v);

            System.out.println(v);
        }

}
