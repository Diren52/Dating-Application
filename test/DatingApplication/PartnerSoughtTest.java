
package DatingApplication;

import java.util.InputMismatchException;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * PersonSought unit testing
 *
 * @version 1.02 12 Apr 2018
 * @author Joseph Sigar
 */
public class PartnerSoughtTest {

    public PartnerSoughtTest() {
    }

    /**
     * Test of clear method, of class PartnerSought. Should Return the variables
     * to the default
     */
    @Test
    public void testClear() {
        //Given
        String gender = "f";
        int[] ageRange = new int[2];
        int[] incomeRange = new int[2];
        ageRange[0] = 17;
        ageRange[1] = 99;
        incomeRange[0] = 0;
        incomeRange[1] = 1000;

        //When
        try {
            PartnerSought partner = new PartnerSought(gender, ageRange, incomeRange);
            partner.clear();

            // Then
            Assert.assertEquals("", partner.getGender());
            Assert.assertEquals(0, partner.getAgeRange()[0]);
            Assert.assertEquals(0, partner.getAgeRange()[1]);
            Assert.assertEquals(0, partner.getIncomeRange()[0]);
            Assert.assertEquals(0, partner.getIncomeRange()[1]);

        } catch (Exception e3) {
            System.out.println(e3.getMessage());
        }

    }

    /**
     * Test of getGender method, of class PartnerSought. Should return the
     * gender
     */
    @Test
    public void testGetGender() {
        //Given
        String gender = "f";
        int[] ageRange = new int[2];
        int[] incomeRange = new int[2];
        ageRange[0] = 17;
        ageRange[1] = 99;
        incomeRange[0] = 0;
        incomeRange[1] = 1000;

        //When
        try {
            PartnerSought partner = new PartnerSought(gender, ageRange, incomeRange);

            // Then
            Assert.assertEquals("f", partner.getGender());

        } catch (Exception e3) {
            System.out.println(e3.getMessage());
        }
    }

    /**
     * Test of setGender method, of class PartnerSought. Should be able to
     * correctly set the gender
     */
    @Test
    public void testSetGender() {
        //Given
        String gender = "m";

        //When
        try {
            PartnerSought partner = new PartnerSought();
            partner.setGender(gender);

            // Then
            Assert.assertEquals(gender, partner.getGender());

        } catch (Exception e3) {
            System.out.println(e3.getMessage());
        }
    }

    /**
     * Test of getAgeRange method, of class PartnerSought. Should return the age
     * range
     */
    @Test
    public void testGetAgeRange() {
        //Given
        String gender = "f";
        int[] ageRange = new int[2];
        int[] incomeRange = new int[2];
        ageRange[0] = 17;
        ageRange[1] = 99;
        incomeRange[0] = 0;
        incomeRange[1] = 1000;

        //When
        try {
            PartnerSought partner = new PartnerSought(gender, ageRange, incomeRange);

            // Then
            Assert.assertEquals(17, partner.getAgeRange()[0]);
            Assert.assertEquals(99, partner.getAgeRange()[1]);

        } catch (Exception e3) {
            System.out.println(e3.getMessage());
        }
    }

    /**
     * Test of setAgeRange method, of class PartnerSought. Should be able to set
     * the age range
     */
    @Test
    public void testSetAgeRange() {
        //Given
        int[] ageRange = new int[2];
        ageRange[0] = 17;
        ageRange[1] = 99;
        int[] ageRange2 = {99, 17};
        
        PartnerSought partner = new PartnerSought();
        //When
        try {
            
            partner.setAgeRange(ageRange);

            // Then
            Assert.assertEquals(17, partner.getAgeRange()[0]);
            Assert.assertEquals(99, partner.getAgeRange()[1]);

        } catch (Exception e3) {
            System.out.println(e3.getMessage());
        }
        try{
            partner.setAgeRange(ageRange2);
            fail("Should have thrown an error");
        } catch (UnknownOpException e1) {
            
        }
    }

    /**
     * Test of getIncomeRange method, of class PartnerSought. 
     * Should return the income range
     */
    @Test
    public void testGetIncomeRange() {
        //Given
        String gender = "f";
        int[] ageRange = new int[2];
        int[] incomeRange = new int[2];
        ageRange[0] = 17;
        ageRange[1] = 99;
        incomeRange[0] = 0;
        incomeRange[1] = 1000;

        //When
        try {
            PartnerSought partner = new PartnerSought(gender, ageRange, incomeRange);

            // Then
            Assert.assertEquals(0, partner.getIncomeRange()[0]);
            Assert.assertEquals(1000, partner.getIncomeRange()[1]);

        } catch (Exception e3) {
            System.out.println(e3.getMessage());
        }
    }

    /**
     * Test of setIncomeRange method, of class PartnerSought.
     * Should be able to 
     */
    @Test
    public void testSetIncomeRange() {
        //Given
        int[] incomeRange = new int[2];
        incomeRange[0] = 0;
        incomeRange[1] = 1000000;
        int[] incomeRange2 = {1000, 15};

        //When
        PartnerSought partner = new PartnerSought();
        try {
            
            partner.setIncomeRange(incomeRange);

            // Then
            Assert.assertEquals(0, partner.getIncomeRange()[0]);
            Assert.assertEquals(1000000, partner.getIncomeRange()[1]);

        } catch (Exception e3) {
            System.out.println(e3.getMessage());
        }
        
        try{
            partner.setIncomeRange(incomeRange2);
            fail("Should have thrown an error");
        } catch (UnknownOpException e1) {
            
        }
    }

    /**
     * Test of isNotSet method, of class PartnerSought.
     * Should return true if the parameters for PartnerSought are not set
     */
    @Test
    public void testIsNotSet() {
        //Given
        String gender = "f";
        int[] ageRange = new int[2];
        int[] incomeRange = new int[2];
        ageRange[0] = 17;
        ageRange[1] = 99;
        incomeRange[0] = 0;
        incomeRange[1] = 1000;

        //When
        try {
            PartnerSought partner = new PartnerSought(gender, ageRange, incomeRange);
            PartnerSought partner1 = new PartnerSought();
            // Then
            Assert.assertEquals(true, partner1.isNotSet());
            Assert.assertEquals(false, partner.isNotSet());
            

        } catch (Exception e3) {
            System.out.println(e3.getMessage());
        }
        
    }

    /**
     * Test of clone method, of class PartnerSought.
     */
    @Test
    public void testClone() throws Exception {
        //Given
        String gender = "f";
        int[] ageRange = new int[2];
        int[] incomeRange = new int[2];
        ageRange[0] = 17;
        ageRange[1] = 99;
        incomeRange[0] = 0;
        incomeRange[1] = 1000;

        //When
        try {
            PartnerSought partner = new PartnerSought(gender, ageRange, incomeRange);
            PartnerSought partner1 = partner.clone();
            
            // Then
             // Then
            org.testng.Assert.assertEquals(partner, partner1);
            fail("Objects shouldn't point to the same memory reference");
            
        } catch (UnknownOpException e){
            fail("Shouldn't throw this Error");
        } catch (CloneNotSupportedException e2){
            fail("Clone method doesnt work");
        } catch (AssertionError e3){
            
        }
            
    }

}
