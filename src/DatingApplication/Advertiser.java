/*
 * Title: Mr
 * Author: Joseph Sigar
 * Date: 12/04/2018
 * File name: Question 2
 * 
 * Purpose: A class to hold the information of a customer whose main purpose
 * would be to be Advertising to other Customer. It inherits its properties from
 * the Customer class.
 * 
 * Assumptions:
 * 1. Only 2 genders are required for this prototype.
 * 2. The age input is an integer
 * 3. The Income input is an integer
 * 4. The acceptable minimum age range is 16 and a maximum of 100
 * 5. The income ranges from 0 to 1000000
 * 6. A class is required to store/handle the login details of a customer
 * 7. The input string username and password can be of any length and can contain any character.
 * 8. Password and Username can be the same value.
 * 9. The first name and last name can take any string values, including 
 *    non-string values.
 * 10. Class requires a method to denote whether a customer is an denomination or not
 * 11. Can have many replies from the same person
 * 
 *
 * Condition of Input:
 * first name   -       String
 * last name    -       String
 * gender       -       String  = M, m or F, f (where m/M is for male and f/F is for female)
 * age          -       integer. Cant be less than 16 or greater than 100.
 * income       -       integer. Cant be less than 0 or greater than 1000000.
 * denomination -       String  = r, R or A, a (where r/R is for responder and a/A is for Advertiser)
 * login        -       Login object 
 * textAdvert   -       String
 * partnerSought-       A partner sought object that holds the denomination preference
 * replyMessage -       An ArrayList that holds the list of replies from various responders
 * 
 * Expected Output:
 * first name   -       String
 * last name    -       String
 * gender       -       lowercase String, e.g. m, f.
 * age          -       integer.
 * income       -       integer.
 * denomination -       lowercase String e.g. r, a
 * login        -       login object
 * text Advert  -       String
 * partnerSought-       PartnerSought object
 * replyMessage -       an ArrayList of the reply message object
 */
package DatingApplication;
import java.util.InputMismatchException;
import java.util.*;
/**
 * A class that handles the information of an Advertiser customer. This class
 * inherits from the Customer base class
 *
 * @version 1.02 12 Apr 2018
 * @author Joseph Sigar
 */

/**
 * A class that handles the information of an Advertiser customer.This class
 inherits from the Customer base class
 * @version 1.02 12 Apr 2018
 * @author Joseph Sigar
 */
public class Advertiser extends Customer {
    /**
     * A parameter that holds a string that indicates the Advertiser
 advert
     */
    private String textAdvert;
    
    /**
     * A parameter that holds the description of partner sought by the 
 Advertiser
     */
    private PartnerSought partnerSought;
    
    /**
     * An ArrayList data structure that holds the reply messages intended for the 
 Advertiser
     */
    private ArrayList<ReplyMessage> replyMessageList;
    
    /**
     * The default constructor that is called upon when a new denomination
 Object is created. The constructor initializes the parameters to the
     * program default values.
     */
    public Advertiser () {
        // A Constructor that initializers the login parameters to the default values
        super();
        super.denomination = "a";
        textAdvert = "";
        
        partnerSought = new PartnerSought() ;
        
        replyMessageList = new ArrayList<>();
    }
    
    /**
     * A Constructor that initializes the Advertiser Object using a user-defined
     * Customer object.
     * @param customer user-defined Customer Object that is passed into the 
     *                 Advertiser class
     * @throws java.lang.CloneNotSupportedException
     * @throws DatingApplication.UnknownOpException
     * @throws InputMismatchException
     */
    public Advertiser (Customer customer) throws CloneNotSupportedException, UnknownOpException, InputMismatchException {
        // copy Constructor that initializes using user-defined customer object 
        super(customer.firstName, customer.lastName, customer.gender, customer.age, customer.income, "a", customer.login);
        partnerSought = new PartnerSought();
        replyMessageList = new ArrayList<>();
    }
    
    /**
     * A Constructor that initializes the class parameters to a user-defined
     * parameters.  
     * 
     * @param firstName a string parameter set by the user, indicates the first name of the denomination
     * @param lastName a string parameter set by the user, indicates the last name of the denomination
     * @param gender a string parameter set by the user, indicates the gender of the denomination
     * @param age an integer parameter set by the user, indicates the age of the denomination
     * @param income an integer parameter set by the user, indicates the income of the denomination
     * @param login a Login object that holds the login details of the denomination
     * @param textAdvert a string parameter set by the user, indicates the text an denomination advertisers with.
     * @param partnerSought a PartnerSought object that holds that denomination preference details
     * @param replyMessageList an ArrayList data structure that holds the replies an denomination would receive 
     * @throws java.lang.CloneNotSupportedException
     * @throws DatingApplication.UnknownOpException
     * @throws InputMismatchException
     */
    public Advertiser (String firstName, 
                       String lastName,
                       String gender,
                       int age,
                       int income, 
                       Login login,
                       String textAdvert, 
                       PartnerSought partnerSought, 
                       ArrayList<ReplyMessage> replyMessageList) throws CloneNotSupportedException, InputMismatchException, UnknownOpException {
        // A Constructor that initializes the parameters
        super(firstName, lastName, gender, age, income, "a", login);
        
        this.textAdvert = textAdvert;
        this.partnerSought = new PartnerSought();
        this.replyMessageList = new ArrayList<>();
        this.partnerSought = partnerSought.clone();
        
        for (ReplyMessage replyMessage: replyMessageList) {
            this.replyMessageList.add(replyMessage.clone());
        }
    }
    
    /**
     * A method to return the text advert an Advertiser may have set
     * @return a string indicating the text advert set by the denomination
     */
    public String getTextAdvert() {
        // a getter method for the text advert parameter
        return textAdvert;
    }
    
    /**
     * A method used to set the text advert to a user-defined value
     * @param textAdvert a string that is defined by the user.
     */
    public void setTextAdvert(String textAdvert) {
        // a setter method of the text advert
        this.textAdvert = textAdvert;
    }

    /**
     * A method to return the description of PartnerSought object
     * @return a PartnerSought Object
     */
    public PartnerSought getPartnerSought() {
        // a getter method for the partnerSought object
        return partnerSought;
    }
    
    /**
     * A method to set the Description of PartnerSought to a user
     * defined value
     * @param partnerSought a user-defined PartnerSought object
     * @throws java.lang.CloneNotSupportedException
     */
    public void setPartnerSought(PartnerSought partnerSought) throws CloneNotSupportedException {
        // a setter method of the partner sought object
        this.partnerSought = partnerSought.clone();
    }
    
    /**
     * A method to return the ArrayList containing the ReplyMessage Object
     * @return an ArrayList of ReplyMessage objects.
     */
    public ArrayList<ReplyMessage> getReplyMessageList() {
        // a getter method for the ArrayList of ReplyMessage objects
        return replyMessageList;
    }
    
    /**
     * A method to set the ArrayList of ReplyMessage to a user-defined
     * ArrayList of reply message list
     * @param replyMessageList
     */
    public void setReplyMessageList(ArrayList<ReplyMessage> replyMessageList) {
        // A setter method for the ArrayList of Reply Messages to a user defined 
        // ArrayList of reply message
        
        this.replyMessageList = (ArrayList<ReplyMessage>)replyMessageList.clone();
    }
    
    /**
     * A method to add a ReplyMessage Object to the ArrayList of 
 ReplyMessage for the Advertiser
     * @param replyMessage user-defined object to be added to the list
     */
    public void addReplyMessage(ReplyMessage replyMessage) {
        // method adds user-defined object to the ArrayList
        this.replyMessageList.add(replyMessage);
    }
    
    /**
     * A method to remove a replyMessage from the ArrayList. 
     * The ReplyMessage Object is specified by the user
     * @param replyMessage a user specified object to be removed from the list.
     */
    public void removeReplyMessage(ReplyMessage replyMessage) {
        this.replyMessageList.remove(replyMessage);
    }
    
    /**
     * A method that clears the values and sets them to program
     * Overrides the Parent class clear method.
     */
    @Override
    public void clear() {
        // A clear method to set the paramaters to default
        super.clear();
        textAdvert = "";
        partnerSought.clear();
        replyMessageList.clear();
    }
    
     /**
     * A method used to copy one Advertiser object to another.
     * @return a copied Advertiser object
     * @throws java.lang.CloneNotSupportedException 
     */
    @Override
    public Advertiser clone() throws CloneNotSupportedException {
        // Copies one Advertiser object to another
        Advertiser advertiser = new Advertiser();
        advertiser.firstName = this.firstName;
        advertiser.lastName = this.lastName;
        advertiser.age = this.age;
        advertiser.income = this.income;
        advertiser.login = this.login.clone();
        advertiser.gender = this.gender;
        advertiser.denomination = this.denomination;
        advertiser.textAdvert = this.textAdvert;
        advertiser.partnerSought = this.partnerSought.clone();
        
        for (ReplyMessage replyMessage: this.replyMessageList) {
            advertiser.replyMessageList.add(replyMessage.clone());
        }
        
        return advertiser;
    }
}