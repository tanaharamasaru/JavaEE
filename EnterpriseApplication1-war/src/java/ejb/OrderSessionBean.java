/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.OrderDetail;
import entity.Orders;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author BBC300198
 */
@Stateless
@LocalBean
public class OrderSessionBean {

//    @PersistenceContext(unitName="EnterpriseApplication1-warPU")
    @PersistenceContext
    private EntityManager entityManager;

    public void createOrder(Orders orders) {
        entityManager.persist(orders);
    }
    
    public void createOrderDetail(OrderDetail detail){
        entityManager.persist(detail);
    }


}
