package com.demo.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class PersonDAO {
    // Objectif du DAO (Database Access Object)
    // Implementer les opérations de base de type CRUD

    public static void save(Person person) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();
            entityManager.persist(person);
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Erreur lors de l'enregistrement !");
            tx.rollback();
        }
    }

    public static Person findById(Integer id){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        return entityManager.find(Person.class, id);
    }

    public static List<Person> findAll(){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        // JPQL : sorte de requete SQL mais avec les classes Java
        Query query  = entityManager.createQuery("SELECT p FROM Person p");// SELECT * FROM persons;
        return query.getResultList();
    }

    public static List<Person> findAllV2(){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        // Native Query
        Query query = entityManager.createNativeQuery("SELECT * FROM persons", Person.class);
        return query.getResultList();
    }

    public static List<String> findNames(){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        // JPQL : sorte de requete SQL mais avec les classes Java
        Query query  = entityManager.createQuery("SELECT p.lastName FROM Person p");// SELECT * FROM persons;
        return query.getResultList();
    }

    public static void delete(Person person) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();
            entityManager.remove(person);
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Erreur lors de la suppression !");
            tx.rollback();
        }
    }

    public static void update(Person person){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();
            entityManager.merge(person);
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Erreur lors de la modification !");
            tx.rollback();
        }
    }

    // 2 queries --> heavy to execute
    public static void deleteById(Integer id) {
        Person person = findById(id);
        delete(person);
    }

    public static void deleteByIdV2(Integer id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();

            // Query with params
            Query query = entityManager.createQuery("DELETE FROM Person p WHERE p.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();

            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Erreur lors de la suppression avec params !");
            tx.rollback();
        }
    }

    public static List<Person> findByLastname(String lastname) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        // Query with params
        Query query = entityManager.createQuery("SELECT p FROM Person p WHERE p.lastName = :lastname");
        query.setParameter("lastname", lastname);

        return query.getResultList();
    }

}
