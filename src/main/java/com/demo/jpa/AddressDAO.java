package com.demo.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class AddressDAO {

    public static void save(Address address) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();
            entityManager.persist(address);
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Erreur lors de l'enregistrement !");
            tx.rollback();
        }
    }

    public static Address findById(Integer id){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        return entityManager.find(Address.class, id);
    }

    public static List<Address> findAll(){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        // JPQL : sorte de requete SQL mais avec les classes Java
        Query query  = entityManager.createQuery("SELECT a FROM Address a");// SELECT * FROM persons;
        return query.getResultList();
    }


    public static void delete(Address address) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();
            entityManager.remove(address);
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Erreur lors de la suppression !");
            tx.rollback();
        }
    }

    public static void deleteById(Integer id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();
            Query query = entityManager.createQuery("DELETE FROM Address a WHERE a.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Erreur lors de la suppression avec params !");
            tx.rollback();
        }
    }

    public static void update(Address address){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();
            entityManager.merge(address);
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Erreur lors de la modification !");
            tx.rollback();
        }
    }

}
