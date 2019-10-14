package DatingApplication;

import org.junit.Test;
import static org.junit.Assert.*;
import org.testng.Assert;

/**
 * A test class that test the responder class
 * 
 * @version 1.02 12 Apr 2018
 * @author Joseph Sigar
 */
public class ResponderTest {
    
    public ResponderTest() {
    }

    /**
     * Test of clear method, of class Responder.
     */
    @Test
    public void testClear() {
        // Given
        String firstName = "Jose";
        String lastName = "Bone";
        int age = 31;
        int income = 1000;
        String gender = "m";
        String userName = "Bool";
        String passWord = "Bool2";
        
        // When
        try {
        Login login = new Login(userName, passWord);
        Responder responder = new Responder(firstName, lastName, gender, age, income, login);
        responder.clear();
        
        // Then
        Assert.assertEquals("", responder.getFirstName());
        Assert.assertEquals("", responder.getLastName());
        Assert.assertEquals("", responder.getGender());
        Assert.assertEquals(0, responder.getAge());
        Assert.assertEquals(0, responder.getIncome());
        Assert.assertEquals("", responder.getLogin().getUserName());
        Assert.assertEquals("", responder.getLogin().getPassWord());
        } catch (Exception e){
            
        }
        
    }

    /**
     * Test of clone method, of class Responder.
     */
    @Test
    public void testClone() throws Exception {
    // Given
    String firstName = "Jose";
    String lastName = "Bone";
    int age = 31;
    int income = 1000;
    String gender = "m";
    String userName = "Bool";
    String passWord = "Bool2";

    // When
    try {
        Login login = new Login(userName, passWord);
        Responder testCust = new Responder(firstName, lastName, gender, age, income, login);
        Responder test2 = testCust.clone();

        // Then
        Assert.assertEquals(testCust, test2);
        fail("Objects shouldn't point to the same memory reference");

    } catch (UnknownOpException e){
        fail("Shouldn't throw this Error");
    } catch (CloneNotSupportedException e2){
        fail("Clone method doesnt work");
    } catch (AssertionError e3){

    }
    }
    
}
