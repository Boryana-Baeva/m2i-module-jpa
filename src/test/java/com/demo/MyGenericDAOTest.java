package com.demo;

import com.demo.jpa.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MyGenericDAOTest {
    // TESTS MYGENERICDAO   ---------------------------------------------------------------------
    @Test
    public void testGenericSave() {
        Person person = new Person("Jane", "Doe");
        MyGenericDAO.save(person);

        // Display the newly added Person
        System.out.println("NEW : " + MyGenericDAO.findById(Person.class, person.getId()));
    }

    @Test
    public void testGenericFindById() {
        // PERSON -------------------
        int firstExistingPersonId = MyGenericDAO.findAll(Person.class).get(0).getId();
        displayFirst(Person.class, firstExistingPersonId);

        // ADDRESS -------------------
        int firstExistingAddressId = MyGenericDAO.findAll(Address.class).get(0).getId();
        displayFirst(Address.class, firstExistingAddressId);

        // DOG -------------------
        int firstExistingDogId = MyGenericDAO.findAll(Dog.class).get(0).getId();
        displayFirst(Dog.class, firstExistingDogId);

        // SPORT -------------------
        int firstExistingSportId = MyGenericDAO.findAll(Sport.class).get(0).getId();
        displayFirst(Sport.class, firstExistingSportId);
    }

    private <T> void displayFirst(Class<T> varType, int firstIndex) {
        if(!MyGenericDAO.findAll(varType).isEmpty()) {
            // Get the first existing object of the chosen type to avoid testing with non existant element id
            T t = MyGenericDAO.findById(varType,firstIndex);
            //Display result
            System.out.println("First found " + varType.getSimpleName() +" : " + t);
        } else {
            System.out.println("No " +  varType.getSimpleName() + " found.");
        }
    }

    @Test
    public void testGenericFindAll() {
        // PERSON -------------------
        displayAll(Person.class);

        // ADDRESS -------------------
        displayAll(Address.class);

        // DOG -------------------
        displayAll(Dog.class);

        // SPORT -------------------
        displayAll(Sport.class);
    }

    private <T> void displayAll(Class<T> varType) {
        if(!MyGenericDAO.findAll(varType).isEmpty()) {
            // Find all results for the chosen Object type
            List<T> list = MyGenericDAO.findAll(varType);

            // Display results
            System.out.println("All " + varType.getSimpleName() + "s :");
            for (T element : list) {
                System.out.println(element);
            }

        } else {
            System.out.println("No " +  varType.getSimpleName() + " found.");
        }
    }

    @Test
    public void testGenericDelete() {
        // EXAMPLE : DELETE PERSON
        List<Person> persons = MyGenericDAO.findAll(Person.class);
        if(!persons.isEmpty()) {
            int firstExistingId = MyGenericDAO.findAll(Person.class).get(0).getId();
            Person person = MyGenericDAO.findById(Person.class,firstExistingId);
            MyGenericDAO.delete(person);

            System.out.println("All Persons: ");
            for (Person p : persons) {
                System.out.println(p);
            }
        } else {
            System.out.println("La table est vide !");
        }
    }

    @Test
    public void testGenericUpdate() {
        // EXAMPLE : UPDATE SPORT
        List<Sport> sports = MyGenericDAO.findAll(Sport.class);
        if(!sports.isEmpty()) {
            int firstExistingId = MyGenericDAO.findAll(Sport.class).get(0).getId();
            Sport sport = MyGenericDAO.findById(Sport.class,firstExistingId);
            // Display before
            System.out.println(sport);
            // Update
            sport.setName("basketball");
            MyGenericDAO.update(sport);
            // Display after
            System.out.println(sport);
        } else {
            System.out.println("La table est vide !");
        }
    }
}
