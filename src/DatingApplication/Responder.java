/*
 * Title: Mr
 * Author: Joseph Sigar
 * Date: 12/04/2018
 * File name: Question 2
 * 
 * Purpose: A class to hold the information of a customer whose main purpose
 * would be to be replying to other Advertisers. It inherits its properties from
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
 * 10. Class requires a method to denote whether a customer is a responder or not
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
 * 
 * Expected Output:
 * first name   -       String
 * last name    -       String
 * gender       -       lowercase String, e.g. m, f.
 * age          -       integer.
 * income       -       integer.
 * denomination -       lowercase String e.g. r, a
 * login        -       login object
 */
package DatingApplication;

import java.util.InputMismatchException;

/**
 * A Class that handles the information that correspond to a responder of the Application. 
 * It inherits from the Customer base class
 * 
 * @version 1.02 12 Apr 2018
 * @author Joseph Sigar
 */
public class Responder extends Customer {
    
    /**
     * A default constructor that is called upon when a Responder Object
     * is created. The constructor initializes the parameters to the default
     * program values. Set by the parent class
     */
    public Responder() {
        // initializing the Responder parameters to the default values
        super();
        super.denomination = "r";
    }
    
    /**
     * A Constructor that initializes the class parameters to a user-defined
     * parameters.  
     * 
     * @param firstName a string parameter set by the user, indicates the first name of the responder
     * @param lastName a string parameter set by the user, indicates the last name of the responder
     * @param gender a string parameter set by the user, indicates the gender of the responder
     * @param age an integer parameter set by the user, indicates the age of the responder
     * @param income an integer parameter set by the user, indicates the income of the responder
     * @param login a Login object that holds the login details of the responder
     * @throws java.lang.CloneNotSupportedException
     * @throws DatingApplication.UnknownOpException
     */
    public Responder(String firstName, 
                       String lastName,
                       String gender,
                       int age,
                       int income,
                       Login login) throws CloneNotSupportedException, InputMismatchException, UnknownOpException {
        // A Constructor that initializes the parameters, by passing the user-defined
        // parameters to the customer object.
        super(firstName, lastName, gender, age, income, "r", login);
    }
    
    /**
     * A Constructor that initializes the Responder Object using a user-defined
     * Customer object.
     * @param customer user-defined Customer Object that is passed into the 
     *                 Responder class
     * @throws java.lang.CloneNotSupportedException
     * @throws DatingApplication.UnknownOpException
     */
    public Responder (Customer customer) throws CloneNotSupportedException, InputMismatchException, UnknownOpException {
        // Constructor that initializes using user-defined customer Object
        super(customer.firstName, customer.lastName, customer.gender, customer.age, customer.income, "r", customer.login);
    }
    
    /**
     * A method that clears the values and sets them to program
     * Overrides the Parent class clear method
     */
    @Override
    public void clear() {
        // A clear method to set the paramaters to default
        super.clear();
    }
    
     /**
     * A method used to copy one Responder object to another.
     * @return 
     * @throws java.lang.CloneNotSupportedException 
     */
    @Override
    public Responder clone() throws CloneNotSupportedException {
       Responder respond = new Responder();
       respond.firstName = this.firstName;
        respond.lastName = this.lastName;
        respond.age = this.age;
        respond.income = this.income;
        respond.login = this.login.clone();
        respond.gender = this.gender;
        respond.denomination = this.denomination;
       
       return respond;
    }
    
}
