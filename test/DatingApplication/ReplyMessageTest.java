
package DatingApplication;

import java.util.InputMismatchException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.testng.Assert;

/**
 * A test class that test the ReplyMessage class
 * 
 * @version 1.02 12 Apr 2018
 * @author Joseph Sigar
 */
public class ReplyMessageTest {
    
    public ReplyMessageTest() {
        
    }

    /**
     * Test of getResponder method, of class ReplyMessage.
     */
    @Test
    public void testGetResponder() throws CloneNotSupportedException, UnknownOpException {
        // Given
        String firstName = "Jose";
        String lastName = "Bone";
        int age = 31;
        int income = 1000;
        String gender = "m";
        String userName = "Bool";
        String passWord = "Bool2";
        String replyText = "Your face is lovely";
        
        // When
        Login login = new Login(userName, passWord);
        Responder responder = new Responder(firstName, lastName, gender, age, income, login);
        ReplyMessage reply = new ReplyMessage(responder, replyText);
        
        
        // Then
        
        Assert.assertEquals(firstName, reply.getResponder().getFirstName());
        Assert.assertEquals(lastName, reply.getResponder().getLastName());
        Assert.assertEquals(gender, reply.getResponder().getGender());
        Assert.assertEquals(age, reply.getResponder().getAge());
        Assert.assertEquals(income, reply.getResponder().getIncome());
        Assert.assertEquals(userName, reply.getResponder().getLogin().getUserName());
        Assert.assertEquals(passWord, reply.getResponder().getLogin().getPassWord());
        
    }

    /**
     * Test of setResponder method, of class ReplyMessage.
     */
    @Test
    public void testSetResponder() throws UnknownOpException, CloneNotSupportedException {
        // Given
        String firstName = "Jose";
        String lastName = "Bone";
        int age = 31;
        int income = 1000;
        String gender = "m";
        String userName = "Bool";
        String passWord = "Bool2";
        
        // When
        Login login = new Login(userName, passWord);
        Responder responder = new Responder(firstName, lastName, gender, age, income, login);
        ReplyMessage reply = new ReplyMessage();
        reply.setResponder(responder);
        
        // Then
        Assert.assertEquals(firstName, reply.getResponder().getFirstName());
        Assert.assertEquals(lastName, reply.getResponder().getLastName());
        Assert.assertEquals(gender, reply.getResponder().getGender());
        Assert.assertEquals(age, reply.getResponder().getAge());
        Assert.assertEquals(income, reply.getResponder().getIncome());
        Assert.assertEquals(userName, reply.getResponder().getLogin().getUserName());
        Assert.assertEquals(passWord, reply.getResponder().getLogin().getPassWord());
        
    }

    /**
     * Test of getReply method, of class ReplyMessage.
     */
    @Test
    public void testGetReply() throws CloneNotSupportedException, InputMismatchException, UnknownOpException {
        // Given
        String firstName = "Jose";
        String lastName = "Bone";
        int age = 31;
        int income = 1000;
        String gender = "m";
        String userName = "Bool";
        String passWord = "Bool2";
        String replyText = "Your face is lovely";
        
        // When
        Login login = new Login(userName, passWord);
        Responder responder = new Responder(firstName, lastName, gender, age, income, login);
        ReplyMessage reply = new ReplyMessage(responder, replyText);
        
        
        // Then
        
        Assert.assertEquals(replyText, reply.getReply());
        
    }

    /**
     * Test of setReply method, of class ReplyMessage.
     */
    @Test
    public void testSetReply() {
        // Given
        String replyText = "Your face is lovely";
        
        // When
        ReplyMessage reply = new ReplyMessage();
        reply.setReply(replyText);
        
        // Then
        Assert.assertEquals(replyText, reply.getReply());
    }

    /**
     * Test of clear method, of class ReplyMessage.
     */
    @Test
    public void testClear() throws CloneNotSupportedException, InputMismatchException, UnknownOpException {
        // Given
        String firstName = "Jose";
        String lastName = "Bone";
        int age = 31;
        int income = 1000;
        String gender = "m";
        String userName = "Bool";
        String passWord = "Bool2";
        String replyText = "Your face is lovely";
        
        // When
        Login login = new Login(userName, passWord);
        Responder responder = new Responder(firstName, lastName, gender, age, income, login);
        ReplyMessage reply = new ReplyMessage(responder, replyText);
        reply.clear();
        
        // Then
        
        Assert.assertEquals("", reply.getResponder().getFirstName());
        Assert.assertEquals("", reply.getResponder().getLastName());
        Assert.assertEquals("", reply.getResponder().getGender());
        Assert.assertEquals(0, reply.getResponder().getAge());
        Assert.assertEquals(0, reply.getResponder().getIncome());
        Assert.assertEquals("", reply.getResponder().getLogin().getUserName());
        Assert.assertEquals("", reply.getResponder().getLogin().getPassWord());
        Assert.assertEquals("", reply.getReply());
    }

    /**
     * Test of clone method, of class ReplyMessage.
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
        String replyText = "Your face is lovely";

        // When
        try {
            Login login = new Login(userName, passWord);
            Responder testCust = new Responder(firstName, lastName, gender, age, income, login);
            ReplyMessage reply = new ReplyMessage(testCust, replyText);
            ReplyMessage test2 = reply.clone();
            
            // Then
            Assert.assertEquals(reply, test2);
            fail("Objects shouldn't point to the same memory reference");
            
        } catch (UnknownOpException e){
            fail("Shouldn't throw this Error");
        } catch (CloneNotSupportedException e2){
            fail("Clone method doesnt work");
        } catch (AssertionError e3){
            
        }
    }
    
}
