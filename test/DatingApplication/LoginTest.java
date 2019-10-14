
package DatingApplication;

import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Login unit testing
 *
 * @version 1.02 12 Apr 2018
 * @author Joseph Sigar
 */
public class LoginTest {

    public LoginTest() {
    }

    /**
     * Test of clear method, of class Login. Should be able to return values to
     * default values
     */
    @Test
    public void testClear() {
        // Given
        String username = "Jose";
        String password = "Bone";

        // When
        Login login = new Login(username, password);
        login.clear();

        // Then
        Assert.assertEquals("", login.getPassWord());
        Assert.assertEquals("", login.getUserName());
    }

    /**
     * Test of getUserName method, of class Login. Should be able to return the
     * customer username
     */
    @Test
    public void testGetUserName() {
        // Given 
        String username = "Jose", password = "Bone";

        // When
        Login login = new Login(username, password);

        // Then
        Assert.assertEquals(username, login.getUserName());
    }

    /**
     * Test of getPassWord method, of class Login. Should be able to return the
     * Login password
     */
    @Test
    public void testGetPassWord() {
        // Given 
        String username = "Jose", password = "Bone";

        // When
        Login login = new Login(username, password);

        // Then
        Assert.assertEquals(password, login.getPassWord());
    }

    /**
     * Test of setUserName method, of class Login. Should be able to set the
     * Login username
     */
    @Test
    public void testSetUserName() {
        // Given 
        String username = "Jose";

        // When
        Login login = new Login();
        login.setUserName(username);

        // Then
        Assert.assertEquals(username, login.getUserName());
    }

    /**
     * Test of setPassWord method, of class Login. Should be able to set the
     * login password
     */
    @Test
    public void testSetPassWord() {
        // Given 
        String password = "Jose";

        // When
        Login login = new Login();
        login.setPassWord(password);

        // Then
        Assert.assertEquals(password, login.getPassWord());
    }

    /**
     * Test of equals method, of class Login.
     */
    @Test
    public void testEquals() {
        // Given
        String user1 = "Jose", pass1 = "Diablo";
        String user2 = "AnotherJose", pass2 = "NotanotherDiablo";
        String user3 = "Jose", pass3 = "Diablo";

        // When
        Login log1 = new Login(user1, pass1);
        Login log2 = new Login(user2, pass2);
        Login log3 = new Login(user3, pass3);

        // Then
        Assert.assertTrue(log1.equals(log3));
        Assert.assertTrue(!log1.equals(log2));
        Assert.assertTrue(!log2.equals(log3));

    }

    /**
     * Test of clone method, of class Login.
     */
    @Test
    public void testClone() throws Exception {
        String user1 = "Jose", pass1 = "Diablo";

        // When
        try {
            Login log1 = new Login(user1, pass1);
            Login log2 = log1.clone();
            fail("Objects shouldn't point to the same memory reference");
        } catch (CloneNotSupportedException e1) {
            fail("Clone method doesnt work");
        } catch (AssertionError e2) {

        }

    }

}
