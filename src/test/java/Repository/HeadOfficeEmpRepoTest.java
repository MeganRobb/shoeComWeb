/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Repository;

import com.megan.shoecoweb.app.config.ConnectionConfig;
import com.megan.shoecoweb.domain.admin.HeadOfficeEmployees;
import com.megan.shoecoweb.domain.admin.Salary;
import com.megan.shoecoweb.repository.HeadofficeEpmloyeesRepository;
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
public class HeadOfficeEmpRepoTest {
    public static ApplicationContext ctx;
    private Long HOEmpID;
    private HeadofficeEpmloyeesRepository repo;
    
    public HeadOfficeEmpRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void createHeadOffice() {
    repo = ctx.getBean(HeadofficeEpmloyeesRepository.class);
    Salary sal = new Salary.Builder(22.5)
            .empHour(8.0)
            .salary(15000.0)
            .build();
    HeadOfficeEmployees h = new HeadOfficeEmployees.Builder("Tanya")
            .HOEmpDes("Buyer")
            .salary(sal)
            .build();
    
    
    repo.save(h);
    HOEmpID = h.getHOEmpID();
    Assert.assertNotNull(h);
    }
     @Test(dependsOnMethods = "createHeadOffice")
     public void readHeadOffice(){
         repo = ctx.getBean(HeadofficeEpmloyeesRepository.class);
         HeadOfficeEmployees store = repo.findOne(HOEmpID);
         Assert.assertEquals(store.getHOEmpName(), "Tanya");
         
     }
     
    @Test(dependsOnMethods = "readHeadOffice")
     private void updateHeadOffice(){
         repo = ctx.getBean(HeadofficeEpmloyeesRepository.class);
         HeadOfficeEmployees head = repo.findOne(HOEmpID);
         
        Salary sal = new Salary.Builder(22.5)
            .empHour(8.0)
            .salary(16000.0)
            .build();
        HeadOfficeEmployees updateHeadOffice = new HeadOfficeEmployees.Builder("Tanya")
            .HOEmpDes("Manager")
            .salary(sal)
            .build();
    
         repo.save(updateHeadOffice);
         
         HeadOfficeEmployees newStores = repo.findOne(HOEmpID);
         Assert.assertEquals(newStores.getHOEmpName(), "Tanya");
         
     }
     
     @Test(dependsOnMethods = "updateHeadOffice")
     private void deleteHeadOffice(){
         repo = ctx.getBean(HeadofficeEpmloyeesRepository.class);
         HeadOfficeEmployees store = repo.findOne(HOEmpID);
         repo.delete(store);
         
         HeadOfficeEmployees deleteHeadOffice = repo.findOne(HOEmpID);
         
         Assert.assertNull(deleteHeadOffice);
         
         
     }

    // public void hello() {}

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
