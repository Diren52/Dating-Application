/**
 * Title: Mr
 * Author: Joseph Sigar
 * Date: 12/04/2018
 * File name: Question 2
 * 
 * Purpose: A class that handles the Input and output to the dating application
 * classes.
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
 * 10. Class requires a method to denote whether a customer is an advertiser or not
 * 11. The reply text can be as long as the responder likes. I.e. no limit is set
 *    on the reply text.
 * 12. The reply text does not have to contain strings for this prototype
 * 13. Customer cannot change their login once submitted
 * 14. responder can send many replies from the same advertiser
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
 * partnerSought-       A partner sought object that holds the advertiser preference
 * replyMessage -       An ArrayList that holds the list of replies from various responders
 * responder        -   Responder Object, Requires Customer Object
 * reply text       -   String of any length.
 * username has to be only one string (can be a character) and can not be empty
 * password has to be only one string (can be a character) and can not be empty
 * 
 * Expected Output:
 * first name       -       String
 * last name        -       String
 * gender           -       lowercase String, e.g. m, f.
 * age              -       integer.
 * income           -       integer.
 * isAdvertiser     -       lowercase String e.g. r, a
 * login            -       login object
 * text Advert      -       String
 * partnerSought    -       PartnerSought object
 * replyMessage     -       an ArrayList of the reply message object
 * responder        -       Responder Object
 * reply text       -       String
 * Username         -       String
 * Password         -       String
 */

package DatingApplication;

import java.util.*;

/**
 * A Class that handles the Input/Output to the Dating application.
 *
 * @version 1.02 12 Apr 2018
 * @author Joseph Sigar
 */
public class ServiceIO {
    
    /**
     * A Linked Hash Map that holds all Customers that would use the Application, 
     * Uses the Login as the Key and the Customer as the Values.
     */
    private LinkedHashMap<Login, Customer> customerList;
    
    /**
     * A Linked Hash Map that holds all Advertisers that would use the Application, 
     * Uses the Login as the Key and the Advertisers as the Values.
     */
    private LinkedHashMap<Login, Advertiser> advertiserList;
    
    /**
     * A Linked Hash Map that holds all Responders that would use the Application, 
     * Uses the Login as the Key and the Responder as the Values.
     */
    private LinkedHashMap<Login, Responder> responderList;

    /**
     * A default constructor that creates the various lists required by the 
     * Application.
     */
    public ServiceIO() {
        // A Constructor
        customerList = new LinkedHashMap<>();
        advertiserList = new LinkedHashMap<>();
        responderList = new LinkedHashMap<>();
    }
    
    /**
     * A Constructor that initializes the Customer List and does a Deep copy
     * of the user-defined values to the Customer list.
     * 
     * @param customerList User-defined list that contains the login and customer
     * details of various people
     * @throws java.lang.CloneNotSupportedException 
     * @throws DatingApplication.UnknownOpException 
     */
    public ServiceIO(LinkedHashMap<Login, Customer> customerList) throws CloneNotSupportedException, InputMismatchException, UnknownOpException{
        // an initializer constructor
        this.customerList = new LinkedHashMap<>();
        this.advertiserList = new LinkedHashMap<>();
        this.responderList = new LinkedHashMap<>();
        
        for (Map.Entry<Login, Customer> copy: customerList.entrySet()) { // Provides a deep copy of the key and elements
            this.addCustomer(copy.getKey(), copy.getValue().clone());
        }
    }
    
    /**
     * A method to add a Customer together with their login details to the added
     * to the Dating service list. This method allows allocates the Customer to
     * the correct list with regards to their denomination. This method is to be called 
     * first before any other method.
     * @param login a login object provided by the user, containing the Login details
     * @param customer a customer object provided by the user, containing the customer details
     * @throws CloneNotSupportedException
     * @throws InputMismatchException
     * @throws UnknownOpException 
     */
    public final void addCustomer(Login login, Customer customer) throws CloneNotSupportedException, InputMismatchException, UnknownOpException {
        // to add a customer to the customerlist
        customerList.put(login, customer);
        
        // correctly allocates the customer to the correct list
        fromCustomerList(login); 
    }
    
    /**
     * A method to add an Advertiser together with their login details to the added
 to the Dating service list. This method replaces the Advertiser with the same
 Login details to the defined by the parameters. Updates the CustomerList 
 as well
     * @param login - Login object provided by the user
     * @param advertiser  - Advertiser Object provided by the user
     */
    public void addAdvertiser(Login login, Advertiser advertiser) {
        // replaces existing entries to the one defined, with the same login details
        advertiserList.put(login, advertiser); 
        
        // Updates the customer List as well.
        customerList.put(login, (Customer)advertiser);
    }
    
    /**
     * A method to add a Responder together with their login details to the added
     * to the Dating service list. This method replaces the Responder with the same
     * Login details to the defined by the parameters. Updates the CustomerList 
     * as well
     * @param login - Login object provided by the user
     * @param responder  - Advertiser Object provided by the user
     */
    public void addResponder(Login login, Responder responder) {
        // replaces existing entries to the one defined, with the same login details
        responderList.put(login, responder);
        
        // Updates the customer List as well.
        customerList.put(login, (Customer)responder);
    }
    
    /**
     * A method to remove the customer from the System. By using the login details
     * the method is also able to remove the customer from any other list they
     * may have been put in.
     * @param login - A login object to indicate the customer that needs to be deleted
     */
    public void removeCustomer(Login login) { 
        // Removes the customer from the customer List as well as any other list they may be in.
        if (this.getCustomer(login).getDenomination().equals("a")){
            getAdvertiser(login).clear();
            advertiserList.remove(login);
        }
        else
            if (this.getCustomer(login).getDenomination().equals("r")){
            getResponder(login).clear();
            responderList.remove(login);
        }
            
        customerList.remove(login);
    }
    
    /**
     * A method to return an individual Customer object from the Customer List.
     * @param login - A login object to indicate the customer that needs to be returned
     * @return A Customer Object that's associated to the login provided
     */
    public Customer getCustomer(Login login) {  
        // a method to return the customer from the list        
        return customerList.get(login);
    }
    
    /**
     * A method to return an individual Advertiser object from the Advertiser List.
     * @param login - A login object to indicate the Advertiser that needs to be returned
     * @return An Advertiser Object that's associated to the login provided
     */
    public Advertiser getAdvertiser(Login login) {
        // a method to return the Advertiser from the advertiser list
        return advertiserList.get(login);
    }
    
    /**
     * A method to return an individual Responder object from the Responder List.
     * @param login - A login object to indicate the responder that needs to be returned
     * @return A Responder Object that's associated to the login provided
     */
    public Responder getResponder(Login login) {   
        // a method to return the Responder from the Responder list
        return responderList.get(login);
    }
       
    /**
     * A method to authenticate the Customer/Advertiser/Responder and allow access
 to the Dating service.
     * @param login - A login object that is to be authenticated
     * @return false if the Login details don't match, otherwise true
     */
    public boolean loginAuth(Login login) {
        // a method to authenticate the Login details entered by a user        
        return !(!advertiserList.containsKey(login) && !responderList.containsKey(login) && !customerList.containsKey(login));
    }
    
    /**
     * A method to return a default password to the Customer. 
     * @param customer -  A customer object that will require the default password
     * @return A string literal indicating the default password for a customer
     */
    public String defaultPassWord(Customer customer) {
        // Returns a defualt password to the customer
        char[] lName = customer.getLastName().toCharArray();
        String fName = customer.getFirstName();
        
        return lName[0] + fName;
    }
    
    /**
     * A method to copy a Customer to the correct list depending on their
     * denomination. Retains the customer on the customer list instead of deleting it. 
     * @param login - Login object defined by the user
     * @throws CloneNotSupportedException
     * @throws InputMismatchException
     * @throws UnknownOpException 
     */
    private void fromCustomerList(Login login) throws CloneNotSupportedException, InputMismatchException, UnknownOpException {
        // copies a customer to the correct list 
        Advertiser advertiser;
        Responder responder;
        if (customerList.get(login).getDenomination().equalsIgnoreCase("a")){
            advertiser = new Advertiser(customerList.get(login).clone());
            
            advertiserList.put(login, advertiser);
        } else
            if (customerList.get(login).getDenomination().equalsIgnoreCase("r")){
                responder = new Responder(customerList.get(login).clone());
                responderList.put(login, responder);
            }
    }
    
    /**
     * A method to return a list of advertiser matches that match a given responder.
     * @param responder - A responder object to be used to get the advertiser matches
     * @param matches
     * @throws java.lang.CloneNotSupportedException
     */
    public void getMatches(Responder responder, ArrayList<Advertiser> matches) throws CloneNotSupportedException {
        // returns a list of all responder matches. by comparing the repsonder details to the 
        // partner sought descriptions set by advertisers.
        PartnerSought toMatch;
        Advertiser advertiser, advertiser2;
        for (Map.Entry<Login, Advertiser> values : advertiserList.entrySet()) {
            advertiser = values.getValue().clone();
            advertiser2 = advertiser.clone();
            toMatch = advertiser2.getPartnerSought();
            
            if (responder.getGender().equals(toMatch.getGender()) 
                    && (responder.getAge() >= toMatch.getAgeRange()[0] && responder.getAge() <= toMatch.getAgeRange()[1])
                    && (responder.getIncome() >= toMatch.getIncomeRange()[0] && responder.getIncome() <= toMatch.getIncomeRange()[1])) {
                
                matches.add(advertiser2);
            }
            advertiser.clear();
        }
    }
    
    /**
     * A method to enable a responder to send a reply to an Advertiser. 
     * @param responder - A responder object that is sending the reply message
     * @param replyFromResponder - A string literal indicating the reply from the responder
     * @param advertiser - An advertiser object at which the reply message from the responder is intended to 
     * @throws CloneNotSupportedException 
     */
    public void sendReply(Responder responder, String replyFromResponder, Advertiser advertiser) throws CloneNotSupportedException {
        // allows a responder to send a reply to an advertiser
        ReplyMessage replyMessage = new ReplyMessage(responder, replyFromResponder);
        
        advertiser.addReplyMessage(replyMessage);
        this.addAdvertiser(advertiser.getLogin(), advertiser);
    }
    
    /**
     * A method to return a list containing all the replies an Advertiser may 
 have gotten.
     * @param login - A login object that can be used to get the replies 
     * @return a list containing ReplyMessage Objects.
     */
    public ArrayList<ReplyMessage> viewReplies(Login login) {
        // returns all replies to an Advertiser
        return this.getAdvertiser(login).getReplyMessageList();
    }
    
    /**
     * A method to return a list of all Advertiser in the Dating service.
     *
     * @return An ArrayList of all the Advertiser's in the system
     */
    public ArrayList<Advertiser> getAllAdvertisers() {
        ArrayList<Advertiser> allAdvertiserList = new ArrayList<>();
        
        for (Map.Entry<Login, Advertiser> copy : this.advertiserList.entrySet()) {
            allAdvertiserList.add(copy.getValue());
        }
        
        return allAdvertiserList;
    }
    
    /**
     * A method to return a list of all Responder in the Dating service.
     *
     * @return An ArrayList of all the Responder's in the system
     */
    public ArrayList<Responder> getAllResponders() {
        ArrayList<Responder> allResponderList = new ArrayList<>();
        
        for (Map.Entry<Login, Responder> copy : this.responderList.entrySet()) {
            allResponderList.add(copy.getValue());
        }
        
        return allResponderList;
    }
}
