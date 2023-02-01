/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import enyity.Product;
import enyity.Client;
import enyity.Purchase;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * 
 * @author user
 */
public class BaseDataManager {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPTV21shopPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
          
    public void saveProducts(List <Product> products){
        tx.begin();
        for (int i = 0; i < products.size();i++) {
            Product product = products.get(i);
            if(product.getId() == null){
                em.persist(product);
            }else{
                em.merge(product);
            }
        }
        tx.commit();
    }
    
    public List loadProduct(){
        try {
            return em.createQuery("SELECT p FROM Product p")
                    .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    public void saveClients(List <Client>  clients){
        tx.begin();
            for (int i = 0; i < clients.size(); i++) {
                Client client = clients.get(i);
                if(client.getId() == null){
                    em.persist(client);
                }else{
                    em.merge(client);
                }
            }
        tx.commit();
    }

    public List loadClients() {
        try {
            return em.createQuery("SELECT c FROM Client c")
                    .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    
    public void saveHistories(List<Purchase> histories){
        tx.begin();
            for (int i = 0; i < histories.size(); i++) {
                Purchase history = histories.get(i);
                if(history.getId() == null){
                    em.persist(history);
                }else{
                    em.merge(history);
                }
            }
        tx.commit();
    }
    
    public List<Purchase> loadHistories() {
        try {
            return em.createQuery("SELECT h FROM History h")
                    .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    


    
}