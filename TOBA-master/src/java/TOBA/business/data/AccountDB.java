/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOBA.business.data;


import TOBA.business.Account;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;

/**
 *
 * @author Robert2
 */
public class AccountDB {
      //@Resource(name = "jdbc/toba")
    private DataSource ds;
     
       public static void insert(Account account) {
       EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("TOBA-TessnowPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            em.persist(account);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
    
    public static void UpdateAccount(Account account) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("TOBA-TessnowPU");
         EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        
        transaction.begin();
        try {
           em.merge(account);
           transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        } finally {
            em.close();
        }
}
    
   
  public static  Account selectAccount(Long id) {

        
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("TOBA-TessnowPU");
        EntityManager em = emf.createEntityManager();

       
        String qString = "SELECT u FROM Account u WHERE u.id = :id";
        TypedQuery<Account> q = em.createQuery(qString, Account.class);
        q.setParameter("id", id);

        try {
            Account account = q.getSingleResult();
            return account;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
     }
      
        
        
}

