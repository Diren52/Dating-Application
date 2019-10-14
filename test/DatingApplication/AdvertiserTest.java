/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatingApplication;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.testng.Assert;

/**
 *
 * @author jozi
 */
public class AdvertiserTest {

    public AdvertiserTest() {
    }

    /**
     * Test of getTextAdvert method, of class Advertiser.
     */
    @Test
    public void testGetTextAdvert() {
        // given
        String advert = "I am here";

        // when
        Advertiser testAd = new Advertiser();
        testAd.setTextAdvert(advert);

        // Then
        Assert.assertEquals(advert, testAd.getTextAdvert());
    }

    /**
     * Test of setTextAdvert method, of class Advertiser.
     */
    @Test
    public void testSetTextAdvert() {
        // given
        String advert = "I am here";

        // when
        Advertiser testAd = new Advertiser();
        testAd.setTextAdvert(advert);

        // Then
        Assert.assertEquals(advert, testAd.getTextAdvert());
    }

    /**
     * Test of getPartnerSought method, of class Advertiser.
     */
    @Test
    public void testGetPartnerSought() {
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
            Advertiser testAd = new Advertiser();
            testAd.setPartnerSought(partner);
            PartnerSought partner2 = testAd.getPartnerSought();

            // Then
            Assert.assertEquals(gender, partner2.getGender());
            Assert.assertEquals(ageRange[0], partner2.getAgeRange()[0]);
            Assert.assertEquals(ageRange[1], partner2.getAgeRange()[1]);
            Assert.assertEquals(incomeRange[0], partner2.getIncomeRange()[0]);
            Assert.assertEquals(incomeRange[1], partner2.getIncomeRange()[1]);

        } catch (Exception e3) {
            System.out.println(e3.getMessage());
        }
    }

    /**
     * Test of setPartnerSought method, of class Advertiser.
     */
    @Test
    public void testSetPartnerSought() throws Exception {
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
            Advertiser testAd = new Advertiser();
            testAd.setPartnerSought(partner);
            PartnerSought partner2 = testAd.getPartnerSought();

            // Then
            Assert.assertEquals(gender, partner2.getGender());
            Assert.assertEquals(ageRange[0], partner2.getAgeRange()[0]);
            Assert.assertEquals(ageRange[1], partner2.getAgeRange()[1]);
            Assert.assertEquals(incomeRange[0], partner2.getIncomeRange()[0]);
            Assert.assertEquals(incomeRange[1], partner2.getIncomeRange()[1]);

        } catch (Exception e3) {
            System.out.println(e3.getMessage());
        }
    }

    /**
     * Test of getReplyMessageList method, of class Advertiser.
     */
    @Test
    public void testGetReplyMessageList() throws CloneNotSupportedException, UnknownOpException {
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
        ArrayList<ReplyMessage> replyMList = new ArrayList<>();
        replyMList.add(reply);
        Advertiser testAd = new Advertiser();
        testAd.setReplyMessageList(replyMList);

        ArrayList<ReplyMessage> replyMList2 = testAd.getReplyMessageList();
        Assert.assertEquals(replyMList, replyMList2);
    }

    /**
     * Test of setReplyMessageList method, of class Advertiser.
     */
    @Test
    public void testSetReplyMessageList() throws CloneNotSupportedException, UnknownOpException {
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
        ArrayList<ReplyMessage> replyMList = new ArrayList<>();
        replyMList.add(reply);
        Advertiser testAd = new Advertiser();
        testAd.setReplyMessageList(replyMList);

        ArrayList<ReplyMessage> replyMList2 = testAd.getReplyMessageList();
        Assert.assertEquals(replyMList, replyMList2);

    }

    /**
     * Test of removeReplyMessage method, of class Advertiser.
     */
    @Test
    public void testRemoveReplyMessage() throws CloneNotSupportedException, UnknownOpException {
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
        ArrayList<ReplyMessage> replyMList = new ArrayList<>();
        replyMList.add(reply);
        Advertiser testAd = new Advertiser();
        testAd.setReplyMessageList(replyMList);
        testAd.removeReplyMessage(reply);
        ArrayList<ReplyMessage> replyMList2 = testAd.getReplyMessageList();
        // Then
        Assert.assertEquals(0, replyMList2.size());
    }

    /**
     * Test of clear method, of class Advertiser.
     */
    @Test
    public void testClear() throws CloneNotSupportedException, UnknownOpException {
        String firstName = "Jose";
        String lastName = "Bone";
        int age = 31;
        int income = 1000;
        String gender = "m";
        String userName = "Bool";
        String passWord = "Bool2";
        String replyText = "Your face is lovely";
        String advert = "I am here";

        // When
        Login login = new Login(userName, passWord);
        Responder responder = new Responder(firstName, lastName, gender, age, income, login);
        ReplyMessage reply = new ReplyMessage(responder, replyText);
        ArrayList<ReplyMessage> replyMList = new ArrayList<>();
        replyMList.add(reply);

        Advertiser testAd = new Advertiser();
        testAd.setTextAdvert(advert);
        testAd.setReplyMessageList(replyMList);
        testAd.clear();

        // Then
        Assert.assertEquals(0, testAd.getReplyMessageList().size());
        Assert.assertEquals("", testAd.getTextAdvert());

    }

    /**
     * Test of clone method, of class Advertiser.
     */
    @Test
    public void testClone() throws Exception {
        // Given

        Login log12 = new Login("k", "l");
        int[] ageR3 = {16, 90};
        int[] incR3 = {0, 1000};

        // when
        PartnerSought part4 = new PartnerSought("m", ageR3, incR3);
        
        try {
            
            Advertiser cust12 = new Advertiser("Moon", "Mooon", "f", 100, 1000, log12, "I do alot of ", part4, new ArrayList<>());

            Advertiser testAd = cust12.clone();
            fail("Objects shouldn't point to the same memory reference");
            
        }catch (UnknownOpException e){
            fail("Shouldn't throw this Error");
        } catch (CloneNotSupportedException e2){
            fail("Clone method doesnt work");
        } catch (AssertionError e3){
            
        }
    }

}
