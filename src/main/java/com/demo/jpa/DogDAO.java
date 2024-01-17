package com.demo.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class DogDAO {
        private static EntityManager entityManager = EntityManagerSingleton.getEntityManager("demojpa");
        public static void save(Dog dog) {
            EntityTransaction tx = entityManager.getTransaction();

            try{
                tx.begin();
                entityManager.persist(dog);
                tx.commit();
            }
            catch (Exception e) {
                System.out.println("Erreur lors de l'enregistrement !");
                tx.rollback();
            }
        }

        public static Dog findById(Integer id){
            return entityManager.find(Dog.class, id);
        }

        public static List<Dog> findAll(){
            // JPQL : sorte de requete SQL mais avec les classes Java
            Query query  = entityManager.createQuery("SELECT d FROM Dog d");// SELECT * FROM persons;
            return query.getResultList();
        }


        public static void delete(Dog dog) {
            EntityTransaction tx = entityManager.getTransaction();

            try{
                tx.begin();
                entityManager.remove(dog);
                tx.commit();
            }
            catch (Exception e) {
                System.out.println("Erreur lors de la suppression !");
                tx.rollback();
            }
        }

        public static void deleteById(Integer id) {
            EntityTransaction tx = entityManager.getTransaction();

            try{
                tx.begin();
                Query query = entityManager.createQuery("DELETE FROM Dog d WHERE d.id = :id");
                query.setParameter("id", id);
                query.executeUpdate();
                tx.commit();
            }
            catch (Exception e) {
                System.out.println("Erreur lors de la suppression avec params !");
                tx.rollback();
            }
        }

        public static void update(Dog dog){
            EntityTransaction tx = entityManager.getTransaction();

            try{
                tx.begin();
                entityManager.merge(dog);
                tx.commit();
            }
            catch (Exception e) {
                System.out.println("Erreur lors de la modification !");
                tx.rollback();
            }
        }

}
