/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Product;
import entity.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author BBC300198
 */
@Stateless
@LocalBean
public class ProductListSessionBean {

//    @PersistenceContext(unitName="EnterpriseApplication1-warPU")
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Product> getAll() {
        //return entityManager.createQuery("SELECT c FROM Product c").getResultList();
        Query query = entityManager.createNamedQuery("Product.findAll");
        return query.getResultList();
    }

    public Product find(String key) {
        return entityManager.find(Product.class, key);
    }
    
}
