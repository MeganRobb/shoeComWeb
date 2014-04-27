/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Repository;

import static Repository.StoreRepoTest.ctx;
import com.megan.shoecoweb.app.config.ConnectionConfig;
import com.megan.shoecoweb.domain.admin.Salary;
import com.megan.shoecoweb.domain.admin.StoreEmployees;
import com.megan.shoecoweb.domain.admin.Stores;
import com.megan.shoecoweb.repository.StoreEmployeesRepository;
import com.megan.shoecoweb.repository.StoreRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Megan
 */
public class StoreEmpRepoTest {
    public static ApplicationContext ctx;
    private Long store_id;
    private StoreEmployeesRepository repo;
    
    public StoreEmpRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createStore() {
    repo = ctx.getBean(StoreEmployeesRepository.class);
    Salary sal = new Salary.Builder(22.5)
            .empHour(8.0)
            .salary(1500.0)
            .build();
    StoreEmployees e = new StoreEmployees.Builder("Megan")
            .storeEmpDes("Casual Brah")
            .salary(sal)
            .build();
    
    
    repo.save(e);
    store_id = e.getStoreEmpID();
    Assert.assertNotNull(e);
    }
    @Test(dependsOnMethods = "createStore")
     public void readStore(){
         repo = ctx.getBean(StoreEmployeesRepository.class);
         StoreEmployees store = repo.findOne(store_id);
         Assert.assertEquals(store.getStoreEmpName(), "Megan");
         
     }
     
    @Test(dependsOnMethods = "readStore")
     private void updateStore(){
         repo = ctx.getBean(StoreEmployeesRepository.class);
         StoreEmployees store = repo.findOne(store_id);
         
         Salary sal = new Salary.Builder(22.5)
            .empHour(8.0)
            .salary(1500.0)
            .build();
    StoreEmployees updateStore = new StoreEmployees.Builder("Tracy")
            .storeEmpDes("Casual")
            .salary(sal)
            .build();
        
         repo.save(updateStore);
         
         StoreEmployees newStores = repo.findOne(store_id);
         Assert.assertEquals(newStores.getStoreEmpName(), "Megan");
         
     }
     
     @Test(dependsOnMethods = "updateStore")
     private void deleteStore(){
         repo = ctx.getBean(StoreEmployeesRepository.class);
         StoreEmployees store = repo.findOne(store_id);
         repo.delete(store);
         
         StoreEmployees deleteStore = repo.findOne(store_id);
         
         Assert.assertNull(deleteStore);
         
         
     }


    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
