/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatingApplication;

import org.junit.Test;
import static org.junit.Assert.*;
import org.testng.Assert;

/**
 * PersonSought unit testing
 *
 * @version 1.02 12 Apr 2018
 * @author Joseph Sigar
 */

public class CustomerTest {

    public CustomerTest() {
    }

    /**
     * Test of clear method, of class Customer.
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
            Customer testCust = new Customer(firstName, lastName, gender, age, income, "a", login);
            testCust.clear();

            // Then
            Assert.assertEquals("", testCust.getFirstName());
            Assert.assertEquals("", testCust.getLastName());
            Assert.assertEquals("", testCust.getGender());
            Assert.assertEquals(0, testCust.getAge());
            Assert.assertEquals(0, testCust.getIncome());
            Assert.assertEquals("", testCust.getLogin().getUserName());
            Assert.assertEquals("", testCust.getLogin().getPassWord());
        } catch (Exception e) {

        }
    }

    /**
     * Test of getFirstName method, of class Customer.
     */
    @Test
    public void testGetFirstName() {
        // Given
        String firstName = "Joseph";

        // When
        try {
            Customer testCust = new Customer();
            testCust.setFirstName(firstName);

            // Then
            Assert.assertEquals(firstName, testCust.getFirstName());

        } catch (Exception e) {

        }
    }

    /**
     * Test of getLastName method, of class Customer.
     */
    @Test
    public void testGetLastName() {
        // Given
        String lastName = "Joseph";

        // When
        try {
            Customer testCust = new Customer();
            testCust.setLastName(lastName);

            // Then
            Assert.assertEquals(lastName, testCust.getLastName());

        } catch (Exception e) {

        }
    }

    /**
     * Test of getGender method, of class Customer.
     */
    @Test
    public void testGetGender() {
        // Given
        String gender3 = "m";
        String gender4 = "f";

        // When
        try {
            Customer testCust3 = new Customer();
            testCust3.setGender(gender3);
            Customer testCust4 = new Customer();
            testCust4.setGender(gender4);
            // Then
            Assert.assertEquals(gender3, testCust3.getGender());
            Assert.assertEquals(gender4, testCust4.getGender());
        } catch (Exception e) {

        }
    }

    /**
     * Test of getAge method, of class Customer.
     */
    @Test
    public void testGetAge() {
        // Given
        int age = 34;
        
        try {
        // When
        Customer testCust = new Customer();
        testCust.setAge(age);
        
        // Then
        Assert.assertEquals(age, testCust.getAge());
        } catch (Exception e) {
            
        }
    }

    /**
     * Test of getIncome method, of class Customer.
     */
    @Test
    public void testGetIncome() {
        // Given
        int income = 340000;
        
        try {
        // When
        Customer testCust = new Customer();
        testCust.setIncome(income);
        
        // Then
        Assert.assertEquals(income, testCust.getIncome());
        } catch (Exception e) {
            
        }
    }

    /**
     * Test of setFirstName method, of class Customer.
     */
    @Test
    public void testSetFirstName() {
        // Given
        String  firstName = "Joseph";
        
        try {
        // When
        Customer testCust = new Customer();
        testCust.setFirstName(firstName);
        
        // Then
        Assert.assertEquals(firstName, testCust.getFirstName());
        } catch (Exception e) {
            
        }
    }

    /**
     * Test of setLastName method, of class Customer.
     */
    @Test
    public void testSetLastName() {
        // Given
        String  lastName = "Joseph";
        
        try {
        // When
        Customer testCust = new Customer();
        testCust.setLastName(lastName);
        
        // Then
        Assert.assertEquals(lastName, testCust.getLastName());
        } catch (Exception e) {
            
        }
    }

    /**
     * Test of setGender method, of class Customer.
     */
    @Test
    public void testSetGender() {
        // Given
        String gender1 = "M";
        String gender2 = "F";
        String gender3 = "m";
        String gender4 = "f";
        String gender5 = "a";
        String gender6 = "1";
        String gender7 = "M.";
        String gender8 = "1.00";
        String gender9 = "";

        // When
        try {
            Customer testCust = new Customer();
            testCust.setGender(gender1);
            Customer testCust2 = new Customer();
            testCust2.setGender(gender2);
            Customer testCust3 = new Customer();
            testCust3.setGender(gender3);
            Customer testCust4 = new Customer();
            testCust4.setGender(gender4);
        } catch (UnknownOpException expectedE) {
            fail("Shouldn't throw anything");
        }

        try {
            Customer testCust5 = new Customer();
            testCust5.setGender(gender5);

            fail("Should have thrown an exception");
        } catch (UnknownOpException expectedE) {

        }

        try {

            Customer testCust6 = new Customer();
            testCust6.setGender(gender6);
            fail("Should have thrown an exception");
        } catch (UnknownOpException expectedE) {

        }

        try {
            Customer testCust7 = new Customer();
            testCust7.setGender(gender7);
            fail("Should have thrown an exception");
        } catch (UnknownOpException expectedE) {

        }

        try {
            Customer testCust8 = new Customer();
            testCust8.setGender(gender8);
            fail("Should have thrown an exception");
        } catch (UnknownOpException expectedE) {

        }

        try {
            Customer testCust9 = new Customer();
            testCust9.setGender(gender9);
            fail("Should have thrown an exception");
        } catch (UnknownOpException expectedE) {

        }

    }

    /**
     * Test of setAge method, of class Customer.
     */
    @Test
    public void testSetAge() throws Exception {
        // Given
        int age1 = -1;
        int age2 = 15;
        int age3 = 16;
        int age4 = 100;
        int age5 = 101;
        
        Customer testCust = new Customer();
        //When
        try{
            testCust.setAge(age1);
            fail("Should have thrown an error");
        }catch (UnknownOpException e) {
            
        }
        
        try{
            testCust.setAge(age2);
            fail("Should have thrown an error");
        }catch (UnknownOpException e) {
            
        }
        
        try{
            testCust.setAge(age5);
            fail("Should have thrown an error");
        }catch (UnknownOpException e) {
            
        }
        
        try{
            testCust.setAge(age3);
            
        }catch (UnknownOpException e) {
            fail("Should not have thrown an error");
        }
        
        try{
            testCust.setAge(age4);
            
        }catch (UnknownOpException e) {
            fail("Should not have thrown an error");
        }
    }

    /**
     * Test of setIncome method, of class Customer.
     */
    @Test
    public void testSetIncome() throws Exception {
        int income1 = -1;
        int income2 = 0;
        int income3 = 1000000;
        int income4 = 1000001;
        
        Customer testCust = new Customer();
        //When
        try{
            testCust.setIncome(income1);
            fail("Should have thrown an error");
        }catch (UnknownOpException e) {
            
        }
        
        try{
            testCust.setIncome(income4);
            fail("Should have thrown an error");
        }catch (UnknownOpException e) {
            
        }
        
        try{
            testCust.setIncome(income2);
            
        }catch (UnknownOpException e) {
            fail("Should not have thrown an error");
        }
        
        try{
            testCust.setIncome(income3);
            
        }catch (UnknownOpException e) {
            fail("Should not have thrown an error");
        }
    }

    /**
     * Test of setDenomination method, of class Customer.
     */
    @Test
    public void testSetDenomination() throws Exception {
        // Given
        String denomination = "A";
        String denomination2 = "a";
        String denomination3 = "R";
        String denomination4 = "r";
        String denomination5 = "a.";
        String denomination6 =  "1";
        String denomination7 = "r.";
        String denomination8 = "1.00";
        String denomination9 = "";

        // When
        
        try {
            Customer testCust = new Customer();
            testCust.setDenomination(denomination);
            Customer testCust2 = new Customer();
            testCust2.setDenomination(denomination2);
            Customer testCust3 = new Customer();
            testCust3.setDenomination(denomination3);
            Customer testCust4 = new Customer();
            testCust4.setDenomination(denomination4);
        } catch (UnknownOpException expectedE) {
            fail("Shouldn't throw anything");
        }

        try {
            Customer testCust5 = new Customer();
            testCust5.setDenomination(denomination5);

            fail("Should have thrown an exception");
        } catch (UnknownOpException expectedE) {

        }

        try {

            Customer testCust6 = new Customer();
            testCust6.setGender(denomination6 );
            fail("Should have thrown an exception");
        } catch (UnknownOpException expectedE) {

        }

        try {
            Customer testCust7 = new Customer();
            testCust7.setDenomination(denomination7);
            fail("Should have thrown an exception");
        } catch (UnknownOpException expectedE) {

        }

        try {
            Customer testCust8 = new Customer();
            testCust8.setDenomination(denomination8);
            fail("Should have thrown an exception");
        } catch (UnknownOpException expectedE) {

        }

        try {
            Customer testCust9 = new Customer();
            testCust9.setDenomination(denomination9);
            fail("Should have thrown an exception");
        } catch (UnknownOpException expectedE) {

        }
    }

    /**
     * Test of getDenomination method, of class Customer.
     */
    @Test
    public void testGetDenomination() {
        // Given
        String denom3 = "r";
        String denom4 = "a";

        // When
        try {
            Customer testCust3 = new Customer();
            testCust3.setDenomination(denom3);
            Customer testCust4 = new Customer();
            testCust4.setDenomination(denom4);
            // Then
            Assert.assertEquals(denom3, testCust3.getDenomination());
            Assert.assertEquals(denom4, testCust4.getDenomination());
        } catch (Exception e) {

        }
    }

    /**
     * Test of clone method, of class Customer.
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
            Customer testCust = new Customer(firstName, lastName, gender, age, income, "a", login);
            Customer test2 = testCust.clone();
            
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
