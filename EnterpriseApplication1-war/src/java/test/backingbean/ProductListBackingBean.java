/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.backingbean;

import ejb.ProductListSessionBean;
import entity.Product;
import entity.ProductBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author BBC300198
 */
@Named
@SessionScoped
public class ProductListBackingBean implements Serializable {

    private String productId;
    private int amount;
    
    private List<ProductBean> cartList;
    
    @EJB
    private ProductListSessionBean productListSessionBean;
    
    public String addCart(){

        FacesContext fc=FacesContext.getCurrentInstance();
        Map<String,String> params=fc.getExternalContext().getRequestParameterMap();
        productId = params.get("productId");

        if (cartList == null) {
            cartList = new ArrayList<>();
        }
        
        Product product = productListSessionBean.find(productId);
        
        boolean isProduct = false;
        for(ProductBean pb : cartList){
            if (pb.getProductId().equals(productId)) {
                pb.setAmount(pb.getAmount() + amount);
                isProduct = true;
            }
        }
        
        if(!isProduct) {
            ProductBean productBean = new ProductBean(
                    product.getProductId(),
                    product.getProductName(),
                    product.getPrice(),
                    product.getDetail(),
                    product.getPath(),
                    product.getStock(),
                    product.getCategoryCd(),
                    amount);
            cartList.add(productBean);
        }
        
        // 入力された数量クリア
        amount = 0;
        
        return "cartList.xhtml";
    }
    
    public String back(){
        return "productList.xhtml";
    }
    
    public String delCart() {
        
        FacesContext fc=FacesContext.getCurrentInstance();
        Map<String,String> params=fc.getExternalContext().getRequestParameterMap();
        productId = params.get("productId");
        System.out.println(productId);

        //念のため
        if (cartList == null) {
            cartList = new ArrayList<>();
        }
        
        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getProductId().equals(productId)) {
                cartList.remove(i);
            }
        }

        return null;
    }
    
    public String orderReview() {
        
        return "orderReview.xhtml";
    }
    
    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    /**
     * @return the cartList
     */
    public List<ProductBean> getCartList() {
        return cartList;
    }

    /**
     * @param cartList the cartList to set
     */
    public void setCartList(List<ProductBean> cartList) {
        this.cartList = cartList;
    }
    
}
