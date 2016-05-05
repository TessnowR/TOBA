package TOBA.business.data;


import TOBA.business.Transactions;
import TOBA.business.Users;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author 
 */
public class TransactionDB {

    public boolean insertTranction(Transactions transaction, String type) {
        transaction.setType(type);
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TOBAPU");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        entitymanager.persist(transaction);
        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();
        return true;

    }

    public void getTranction(int accountId, List<Transactions> list) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TOBAPU");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        Query q = entitymanager.createQuery("Select t FROM Transaction t WHERE t.account=:account");
        q.setParameter("account", accountId);

        List<Transactions> todoList = q.getResultList();
        
        for (Transactions rs : todoList) {

            list.add(rs);
            //  isLogin = true;
        }

        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();

    }
}

