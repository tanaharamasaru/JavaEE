/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.backingbean;


import ejb.LoginSessionBean;
import ejb.ProductListSessionBean;
import entity.Product;
import entity.Users;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author BBC300198
 */
@Named
@SessionScoped
public class LoginBackingBean implements Serializable {

 
    //@NotNull @Max(10)
    private String id;
    //@NotNull @Max(10)
    private String password;
    
    private Users users;
    
    private List<Product> productList;
    
    @EJB
    private LoginSessionBean loginSessionBean;
    @EJB
    private ProductListSessionBean productListSessionBean;

    public String login() {
        
        users = loginSessionBean.find(id);        
        if(users == null || !users.getPassword().equals(password)) {
            FacesContext.getCurrentInstance().addMessage(id, new FacesMessage("id もしくはパスワード間違い"));
            return null;
        }
        
        //商品一覧データ取得
        setProductList(productListSessionBean.getAll());
        
        return "productList.xhtml";
    }
    
    /**
     * @return the Id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the loginSessionBean
     */
    public LoginSessionBean getLoginSessionBean() {
        return loginSessionBean;
    }

    /**
     * @param loginSessionBean the loginSessionBean to set
     */
    public void setLoginSessionBean(LoginSessionBean loginSessionBean) {
        this.loginSessionBean = loginSessionBean;
    }
    
    /**
     * @return the users
     */
    public Users getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Users users) {
        this.users = users;
    }

    /**
     * @return the productListSessionBean
     */
    public ProductListSessionBean getProductListSessionBean() {
        return productListSessionBean;
    }

    /**
     * @param productListSessionBean the productListSessionBean to set
     */
    public void setProductListSessionBean(ProductListSessionBean productListSessionBean) {
        this.productListSessionBean = productListSessionBean;
    }

    /**
     * @return the productList
     */
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * @param productList the productList to set
     */
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    
}
