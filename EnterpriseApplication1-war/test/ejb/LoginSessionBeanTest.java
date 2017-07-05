/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Users;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BBC300198
 */
public class LoginSessionBeanTest {
    
    public LoginSessionBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of find method, of class LoginSessionBean.
     */
    @Test
    public void testFind() throws Exception {
        Map props = new HashMap();
//        props.put("org.glassfish.ejb.embedded.glassfish.instance.root",
//               "/Applications/GlassFish/glassfishv3-webprofile/glassfish/domains/domain1");
        props.put(EJBContainer.MODULES, new File[]{
                new File("web/WEB-INF/classes"),
                new File("test/conf/")
        });

        
        System.out.println("find");
        String key = "";
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer(props);
        LoginSessionBean instance = (LoginSessionBean)container.getContext().lookup("java:global/classes/LoginSessionBean");
        Users expResult = null;
        Users result = instance.find(key);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
