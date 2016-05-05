/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOBA.business.data;


import Control.UserJpaController;
import TOBA.business.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Robert2
 */
public class UserDB {
  

   

   
    
     public static void create(Users user) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("TOBA-TessnowPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(user);
            em.getTransaction().commit();
            
        } catch (Exception e) {
           
           // em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static void insert(Users user) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("TOBA-TessnowPU");
//        UserJpaController control = new UserJpaController(emf);
//        Users newuser = new Users();
//             
//        
//        control.create(newuser);
//        
//    }

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
           
            //em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Users user) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("TOBA-TessnowPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(user);
             
            em.getTransaction().commit();
        } catch (Exception e) {
         
           // em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Users user) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("TOBA-TessnowPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(em.merge(user));
            em.getTransaction().commit();
        } catch (Exception e) {
           
           // em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
