/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.backingbean;

import ejb.OrderSessionBean;
import entity.OrderDetail;
import entity.Orders;
import entity.Product;
import entity.ProductBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author BBC300198
 */
@Named
@RequestScoped
public class OrderBackingBean {

    @Inject
    private LoginBackingBean loginBackingBean;
    @Inject
    private ProductListBackingBean productListBackingBean;
    @EJB
    private OrderSessionBean orderSessionBean;
    
    public String back() {
        
        return "cartList.xhtml";
    }
    
    public String order() {
        System.out.println(loginBackingBean.getUsers().getName());
        
        List<ProductBean> cartList = productListBackingBean.getCartList();
        
        Orders orders = new Orders();
        orders.setUserId(loginBackingBean.getUsers());
        orders.setOrderDate(new Date());
        
//        // insert
//        orderSessionBean.createOrder(orders);

        List<OrderDetail> orderDetails = new ArrayList<>();
        int index = 1;
        for(ProductBean productBean : cartList) {
            
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orders);
            orderDetail.setOrderDate(new Date());
            orderDetail.setDetailNo(index);
            orderDetail.setProductId(new Product(productBean.getProductId()));
            orderDetail.setQuantity(productBean.getAmount());
            
            // insert
            //orderSessionBean.createOrderDetail(orderDetail);
            
            orderDetails.add(orderDetail);
            
            index++;
        }

        orders.setOrderDetailCollection(orderDetails);
        // insert まとめてドン
        orderSessionBean.createOrder(orders);
        
        // クリア
        productListBackingBean.setCartList(null);
        
        return "orderConfirm.xhtml";
    }

    /**
     * @return the loginBackingBean
     */
    public LoginBackingBean getLoginBackingBean() {
        return loginBackingBean;
    }

    /**
     * @return the productListBackingBean
     */
    public ProductListBackingBean getProductListBackingBean() {
        return productListBackingBean;
    }

    /**
     * @param loginBackingBean the loginBackingBean to set
     */
    public void setLoginBackingBean(LoginBackingBean loginBackingBean) {
        this.loginBackingBean = loginBackingBean;
    }

    /**
     * @param productListBackingBean the productListBackingBean to set
     */
    public void setProductListBackingBean(ProductListBackingBean productListBackingBean) {
        this.productListBackingBean = productListBackingBean;
    }

    /**
     * @return the orderSessionBean
     */
    public OrderSessionBean getOrderSessionBean() {
        return orderSessionBean;
    }

    /**
     * @param orderSessionBean the orderSessionBean to set
     */
    public void setOrderSessionBean(OrderSessionBean orderSessionBean) {
        this.orderSessionBean = orderSessionBean;
    }
    
}
