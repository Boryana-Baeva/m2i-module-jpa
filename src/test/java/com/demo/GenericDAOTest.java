package com.demo;

import com.demo.jpa.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GenericDAOTest {
    @Test
    public void testGenericSavePerson() {
        GenericDAO<Person> genericDao = new GenericDAO<>(Person.class);
        Person person = new Person("Fred", "Cook");
        genericDao.save(person);

        // Display the newly added Person
        System.out.println("NEW : " + genericDao.findById(person.getId()));
    }

    @Test
    public void testGenericFindPersonById() {
        GenericDAO<Person> genericDao = new GenericDAO<>(Person.class);
        Person person = genericDao.findById(18);
        System.out.println(person);
    }

    @Test
    public void testGenericDisplayFirstPerson() {
        // PERSON -------------------
        GenericDAO<Person> genericDAO = new GenericDAO<>(Person.class);
        int firstExistingId = genericDAO.findAll().get(0).getId();
        List<Person> list = genericDAO.findAll();

        if(!list.isEmpty()) {
            // Get the first existing object of the chosen type to avoid testing with non existant element id
            Person person = genericDAO.findById(firstExistingId);
            //Display result
            System.out.println("First found " + genericDAO.getEntityClass().getSimpleName() +" : " + person);
        } else {
            System.out.println("No " +  genericDAO.getEntityClass().getSimpleName() + " found.");
        }
    }


    @Test
    public void testGenericFindAllPersons() {
        GenericDAO<Person> genericDao = new GenericDAO<>(Person.class);
        List<Person> list = genericDao.findAll();

        if(!list.isEmpty()) {
            // Display results
            System.out.println("All " + genericDao.getEntityClass().getSimpleName() + "s :");
            for (Person p : list) {
                System.out.println(p);
            }
        } else {
            System.out.println("No " +  genericDao.getEntityClass().getSimpleName() + " found.");
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

    private <T> void displayAll(Class<T> entityClass) {
        GenericDAO<T> genericDAO = new GenericDAO<>(entityClass);
        List<T> list = genericDAO.findAll();

        if(!list.isEmpty()) {
            // Display results
            System.out.println("All " + entityClass.getSimpleName() + "s :");
            for (T element : list) {
                System.out.println(element);
            }
        } else {
            System.out.println("No " +  entityClass.getSimpleName() + " found.");
        }
    }

    @Test
    public void testGenericDeleteAddress() {
        // Exemple : DELETE Address
        GenericDAO<Address> genericDAO = new GenericDAO<>(Address.class);
        List<Address> list = genericDAO.findAll();

        if(!list.isEmpty()) {
            int firstExistingId = genericDAO.findAll().get(0).getId();
            Address address = genericDAO.findById(firstExistingId);
            genericDAO.delete(address);

            System.out.println("All Adresses after DELETE: ");
            for (Address a : list) {
                System.out.println(a);
            }
        } else {
            System.out.println("La table est vide !");
        }
    }

    @Test
    public void testGenericUpdateSport() {
        // Example : UPDATE Sport
        GenericDAO<Sport> genericDAO = new GenericDAO<>(Sport.class);
        List<Sport> sports = genericDAO.findAll();

        if(!sports.isEmpty()) {
            int firstExistingId = genericDAO.findAll().get(0).getId();
            Sport sport = genericDAO.findById(firstExistingId);
            // Display before
            System.out.println(sport);
            // Update
            sport.setName("baseball");
            MyGenericDAO.update(sport);
            // Display after
            System.out.println(sport);
        } else {
            System.out.println("La table est vide !");
        }
    }

}
