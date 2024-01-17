package com.demo;

import static org.junit.jupiter.api.Assertions.*;

import com.demo.jpa.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class AppTest
{
    @Test
    public void testSaveAddress(){
        Address address = new Address("rue de la Paix", "Paris", 45);
        AddressDAO.save(address);
    }

    @Test
    public void testSavePersonAddress(){
        Address address = new Address("rue de la Paix", "Paris", 45);
        AddressDAO.save(address);

        Person marie = new Person("Marie", "Dupont");
        marie.setAddress(address);

        PersonDAO.save(marie);
    }

    @Test
    public void testStage(){
        Person marie = new Person("Marie", "Dupont");
        PersonDAO.save(marie);

        Person alain = new Person("Alain", "Dufour");
        PersonDAO.save(alain);

        Person said = new Person("Said", "Dominguez");
        PersonDAO.save(said);

        Stage salsa = new Stage("Stage Salsa", "Pratique avancée de la salsa", LocalDateTime.of(2024, 12,13, 9,30));
        salsa.addIntern(marie);
        salsa.addIntern(alain);
        StageDAO.save(salsa);

        Stage java = new Stage("Java pour les nuls", "Les fondamentaux du language Java", LocalDateTime.of(2024, 4,13, 9,30));
        java.addIntern(alain);
        java.addIntern(said);
        StageDAO.save(java);
    }
}
