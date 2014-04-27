/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Repository;

import com.megan.shoecoweb.app.config.ConnectionConfig;
import com.megan.shoecoweb.domain.admin.StoreAddress;
import com.megan.shoecoweb.domain.admin.Stores;
import com.megan.shoecoweb.domain.admin.Targets;
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
public class StoreRepoTest {
    public static ApplicationContext ctx;
    private Long store_id;
    private StoreRepository repo;
    
    public StoreRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createStore() {
    repo = ctx.getBean(StoreRepository.class);
    Targets t = new Targets.Builder(3500)
            .monthTarg(50000)
            .yearTarg(500000).build();
    
    StoreAddress a = new StoreAddress.Builder("37 Tracy Street")
            .landline("021 654 894").build();
            
    Stores store = new Stores.Builder("Canal Walk")
            .staffAmt(8)
            .storeAdd(a)
            .target(t)
            .build();
    repo.save(store);
    store_id = store.getStore_id();
    Assert.assertNotNull(store);
    }
    
    @Test(dependsOnMethods = "createStore")
     public void readStore(){
         repo = ctx.getBean(StoreRepository.class);
         Stores store = repo.findOne(store_id);
         Assert.assertEquals(store.getStoreName(), "Canal Walk");
         
     }
     
    @Test(dependsOnMethods = "readStore")
     private void updateStore(){
         repo = ctx.getBean(StoreRepository.class);
         Stores store = repo.findOne(store_id);
         
         Targets t = new Targets.Builder(3500)
            .monthTarg(50000)
            .yearTarg(500000).build();
    
    StoreAddress a = new StoreAddress.Builder("37 Orchid Street")
            .landline("021 654 894").build();
            
    Stores updateStore = new Stores.Builder("Tygervalley")
            .staffAmt(8)
            .storeAdd(a)
            .target(t)
            .build();
        
         repo.save(updateStore);
         
         Stores newStores = repo.findOne(store_id);
         Assert.assertEquals(newStores.getStoreName(), "Canal Walk");
         
     }
     
     @Test(dependsOnMethods = "updateStore")
     private void deleteStore(){
         repo = ctx.getBean(StoreRepository.class);
         Stores store = repo.findOne(store_id);
         repo.delete(store);
         
         Stores deleteStore = repo.findOne(store_id);
         
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
