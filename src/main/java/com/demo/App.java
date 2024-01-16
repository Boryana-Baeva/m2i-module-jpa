package com.demo;


import com.demo.jpa.Person;
import com.demo.jpa.PersonDAO;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
          // INSERT
//        Person p1 = new Person("Boryana", "Rault");
//        System.out.println(p1);
//        PersonDAO.save(p1);
//        Person p2 = new Person("Ludovic", "Rault");
//        System.out.println(p2);
//        PersonDAO.save(p2);
        // Hibernate a mis à jour automatiquement l'id du p1
//        System.out.println(p1);

          // FIND ONE
//        Person person = PersonDAO.findById(1);
//        System.out.println(person);

          // FIND MANY
//        List<Person> persons = PersonDAO.findAll();
//        for (Person p : persons) {
//            System.out.println(p);
//        }
//
//        List<String> names = PersonDAO.findNames();
//        for (String name : names) {
//            System.out.println(name);
//        }

//        // DELETE
//        Person person = PersonDAO.findById(2);
//        PersonDAO.delete(person);


          // UPDATE
//        Person person = PersonDAO.findById(1);
//        person.setLastName("Hoffman");
//        PersonDAO.update(person);
//        Person person = new Person("Jane", "Doe");
//        PersonDAO.update(person);


        // FIND MANY V2
//        List<Person> persons = PersonDAO.findAllV2();
//        for (Person p : persons) {
//            System.out.println(p);
//        }

        // DELETE BY ID
//       PersonDAO.deleteById(1);

        // DELETE BY ID 1 query with params
//        PersonDAO.deleteByIdV2(2);

        // FIND BY LAST NAME
//        List<Person> result = PersonDAO.findByLastname("Rault");
//        for (Person p : result) {
//            System.out.println(p);
//        }

    }
}
