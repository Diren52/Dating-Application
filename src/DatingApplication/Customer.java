/*
 * Title: Mr
 * Author: Joseph Sigar
 * Date: 12/04/2018
 * File name: Question 2
 * 
 * Purpose: A class to hold the information of a Customer.
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
 * A Class that handles the information of Customer.
 *
 * @version 1.02 12 Apr 2018
 * @author Joseph Sigar
 */

public class Customer {
    
    /**
     * A parameter that holds the first name of the customer.
     */
    protected String firstName;
    
    /**
     * A parameter that holds the last name of the customer.
     */
    protected String lastName;
    
    /**
     * A parameter that holds the gender of the customer.
     */
    protected String gender;
    
    /**
     * A parameter that holds the age of the customer.
     */
    protected int age;
    
    /**
     * A parameter that holds the income of the customer.
     */
    protected int income;
    
    /**
     * A parameter that holds the login details of the customer.
     */
    protected Login login;
    
    /**
     * A parameter that holds denomination of the customer. i.e. whether they are
     * a responder or an Advertiser.
     */
    protected String denomination;
    
    /** 
     * A Default constructor that is called upon when a Customer object is 
     * created. The constructor initializes the parameters to the default
     * program values.
     */
    public Customer() {
        // A defualt constructor
        firstName = "";
        lastName = "";
        gender = "";
        age = 0;
        income = 0;
        denomination = "";
        login = new Login();
    }
    
    /**
     * An initializer Constructor that initializes the Customer Object to 
     * user-defined Values. Throws some exception that must be caught.
     * 
     * @param firstName a string parameter set by the user, indicates the first name of the denomination
     * @param lastName a string parameter set by the user, indicates the last name of the denomination
     * @param gender a string parameter set by the user, indicates the gender of the denomination
     * @param age an integer parameter set by the user, indicates the age of the denomination
     * @param income an integer parameter set by the user, indicates the income of the denomination
     * @param denomination
     * @param login a Login object that holds the login details of the denomination
     * @throws CloneNotSupportedException
     * @throws UnknownOpException
     * @throws InputMismatchException
     */
    public Customer (String firstName, 
                     String lastName, 
                     String gender, 
                     int age, 
                     int income, 
                     String denomination, 
                     Login login) throws CloneNotSupportedException, UnknownOpException, InputMismatchException {
        // an initializer constructor throws some exception
        if (!gender.toLowerCase().equals("m") && !gender.toLowerCase().equals("f")) {
            throw new UnknownOpException("Invalid Gender entered");
        }

        if (age < 16 || age > 100) {
            throw new UnknownOpException("Invalid Age range entered.");
        }

        if (income < 0 || income > 1000000) {
            throw new UnknownOpException("Invalid income range entered.");
        }
        
        if (!denomination.toLowerCase().equals("r") && !denomination.toLowerCase().equals("a")) {
            throw new UnknownOpException("Invalid Customer denomination entered");
        }
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender.toLowerCase();
        this.age = age;
        this.income = income;
       this.denomination = denomination.toLowerCase();

        this.login = login.clone();
    }
    
    /**
     * A method that clears the values and sets them to program.
     * 
     */
    public void clear() {
        // clears the parameters and sets them to default.
        firstName = "";
        lastName = "";
        gender = "";
        age = 0;
        income = 0;
        denomination = "";
        login.clear();
    }
    
    /**
     * A method to return the Customer's First name.
     * 
     * @return a string parameter containing the customer's first name.
     */
    public String getFirstName() { 
        // A getter method for the first name of the customer
        return firstName; 
    }
    
    /**
     * A method to return the Customer's last name.
     * 
     * @return a string parameter containing the customer's last name
     */
    public String getLastName() { 
        // a getter method for the last name of the customer
        return lastName; 
    }
    
    /**
     * A method to return the Customer's gender.
     * 
     * @return a string parameter containing the customer's gender
     */
    public String getGender() {
        // a getter method for the customer's gender
        return gender;
    }
    
    /**
     * A method to the customer's age.
     * 
     * @return an integer parameter containing the customer's age
     */
    public int getAge() {
        // a getter method for the customer's age
        return age;
    }
    
    /**
     * A method to the customer's income.
     * 
     * @return an integer parameter containing the customer's income
     */
    public int getIncome() {
        // a getter method for the customer's income
        return income; 
    }
    
    /**
     * A method to set the customer's first name to a user defined value.
     * @param firstName a user-defined string value for the customer's name
     */
    public void setFirstName(String firstName) {
        // a setter method of the customer
        this.firstName = firstName;
    }
    
    /**
     * A method to set the customer's last name to a user defined value.
     * @param lastName a user-defined string value for the customer's name
     */
    public void setLastName (String lastName) {
        // a setter method for the customer's last name
        this.lastName = lastName;
    }
    
    /**
     * A method to set the customer's gender to a user defined value.
     * @param gender a user-defined string value for the customer's gender
     * @throws DatingApplication.UnknownOpException
     */
    public void setGender (String gender) throws UnknownOpException {
        // a setter method for the customer's gender
         if (!gender.toLowerCase().equals("m") && !gender.toLowerCase().equals("f")) {
            throw new UnknownOpException("Invalid Gender entered");
        }
        this.gender = gender.toLowerCase();
    }
    
    /**
     * A method to set the customer's age to a user-defined value.
     * @param age a user-defined value for the age of the customer
     * @throws DatingApplication.UnknownOpException
     */
    public void setAge (int age) throws UnknownOpException {
        // a setter method for the customer's age
        if (age < 16 || age > 100) {
            throw new UnknownOpException("Invalid Age range entered.");
        }
        
        this.age = age;
    }
    
    /**
     * A method to set the customer's age to a user-defined value.
     * @param income a user-defined value for the age of the customer
     * @throws DatingApplication.UnknownOpException
     */
    public void setIncome (int income) throws UnknownOpException {
        // a setter method for the customer's income
        if (income < 0 || income > 1000000) {
            throw new UnknownOpException("Invalid income range entered.");
        }
        
        this.income = income;
    }
    
    /**
     * A method to return the customer's login details.
     * @return a login object containing the customer's login details
     */
    public Login getLogin() {
        // a getter method for the login detials
        return this.login;
    }
    
    /**
     * A method to set the customer's login details to a user-defined login 
     * object.
     * @param login a user-defined login object
     * @throws java.lang.CloneNotSupportedException
     */
    public void setLogin(Login login) throws CloneNotSupportedException {
        // a setter method for the customr's login details
        this.login = login.clone();
    }
    
    /**
     * A method to set the Customer denomination to either Advertiser or Responder.
     * @param denomination a user defined denomination value
     * @throws DatingApplication.UnknownOpException
     */
    public void setDenomination(String denomination) throws UnknownOpException {        
        if (!denomination.toLowerCase().equals("r") && !denomination.toLowerCase().equals("a")) {
            throw new UnknownOpException("Invalid Customer denomination entered");
        }
        this.denomination = denomination.toLowerCase();
    }
    
    /**
     * A method to return the customer's denomination 
     * @return a string indicating the customer's denomination
     */
    public String getDenomination() {
        return denomination;
    }
    
     /**
     * A method used to copy one Customer object to another.
     * @return 
     * @throws java.lang.CloneNotSupportedException 
     */
    @Override
    public Customer clone() throws CloneNotSupportedException {
        // copies one customer object onto another object using deep copy
        Customer customer = new Customer();
        customer.firstName = this.firstName;
        customer.lastName = this.lastName;
        customer.age = this.age;
        customer.gender = this.gender;
        customer.income = this.income;
        customer.login = this.login.clone();
        
        return customer;
    }
}
