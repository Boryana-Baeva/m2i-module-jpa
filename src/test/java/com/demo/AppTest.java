package com.demo;

import static org.junit.jupiter.api.Assertions.*;

import com.demo.jpa.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class AppTest
{
    // TESTS ADDRESS ---------------------------------------------------------------------
    @Test
    public void testSaveAddress(){
        Address address = new Address("rue de la Paix", "Paris", 33);
        AddressDAO.save(address);
    }

    @Test
    public void testSavePersonAddress(){
        Address address = new Address("rue de la Paix", "Paris", 85);
        AddressDAO.save(address);

        Person marie = new Person("Marie", "Dupont");
        marie.setAddress(address);

        PersonDAO.save(marie);
    }
    // TESTS STAGE   ---------------------------------------------------------------------
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

    // TESTS DOG   ---------------------------------------------------------------------
    @Test
    public void testAddDogToPerson() {
        Person owner = new Person("Ludovic", "Rault");
        PersonDAO.save(owner);

        Dog dog = new Dog("Tommy", "caniche",9);
        dog.setOwner(owner);
        DogDAO.save(dog);

//        Dog dog2 = new Dog("Frank", "bouledogue français",5);
//        dog2.setOwner(owner);
//        DogDAO.save(dog2);
//
//        Dog dog3 = new Dog("Felix", "westie",1);
//        dog3.setOwner(owner);
//        DogDAO.save(dog3);
//
////        System.out.println("Dog: " + dog);
//        System.out.println("Dog: " + dog2);
//        System.out.println("Dog: " + dog3);
    }

    @Test
    public void testFindDogById() {
        Dog dog = DogDAO.findById(2);
        System.out.println("Dog: " + dog);
    }

    @Test
    public void testFindAllDogs() {
        List<Dog> dogs = DogDAO.findAll();
        System.out.println("All Dogs: ");
        for (Dog d : dogs) {
            System.out.println(d);
        }
    }

    @Test
    public void testDeleteDog() {
        Dog dog = DogDAO.findById(2);
        DogDAO.delete(dog);

        List<Dog> dogs = DogDAO.findAll();
        System.out.println("All Dogs: ");
        for (Dog d : dogs) {
            System.out.println(d);
        }
    }

    @Test
    public void testUpdateDog() {
        Dog dog = DogDAO.findById(3);
        System.out.println(dog);

        dog.setAge(15);
        DogDAO.update(dog);

        System.out.println(dog);
    }


    // TESTS SPORT   ---------------------------------------------------------------------
    @Test
    public void testAddSportToPerson() {
        Person player = new Person("John", "Smith");
        PersonDAO.save(player);

        Sport sport1 = new Sport("football");
        SportDAO.save(sport1);

        Sport sport2 = new Sport("tennis");
        SportDAO.save(sport2);

        player.addSport(sport1);
        player.addSport(sport2);

        List<Sport> sports = player.getSports();
        for (Sport s : sports) {
            System.out.println(s);
        }
    }

    @Test
    public void findSportById() {
        Sport sport = SportDAO.findById(2);
        System.out.println("Sport found: " + sport);
    }

    @Test
    public void testFindAllSports() {
        List<Sport> sports = SportDAO.findAll();
        System.out.println("All Sports: ");
        for (Sport s : sports) {
            System.out.println(s);
        }
    }

    @Test
    public void testDeleteSport() {
        Sport sport = SportDAO.findById(6);
        SportDAO.delete(sport);

        List<Sport> sports = SportDAO.findAll();
        System.out.println("All Sports: ");
        for (Sport s : sports) {
            System.out.println(s);
        }
    }

    @Test
    public void testUpdateSport() {
        Sport sport = SportDAO.findById(8);
        System.out.println(sport);

        sport.setName("basketball");
        SportDAO.update(sport);

        System.out.println(sport);
    }
}
