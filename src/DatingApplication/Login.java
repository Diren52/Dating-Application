/*
 * Title: Mr
 * Author: Joseph Sigar
 * Date: 12/04/2018
 * File name: Question 2
 *
 * Purpose: To be able to store Customer login details in an object that will
 * then be used by the client program to access the customer and their details
 *
 * Assumption:
 * 1. A class is required to store/handle the login details of a customer
 * 2. The input string username and password can be of any length and can contain any character.
 * 3. Password and Username can be the same value.
 *
 * Condition of input:
 * username has to be only one string (can be a character) and can not be empty
 * password has to be only one string (can be a character) and can not be empty
 *
 * Expected Output:
 * Username     -   String
 * Password     -   String
 */
package DatingApplication;

/**
 * A Class that handles and stores the login details of a customer
 *
 * @version 1.02 12 Apr 2018
 * @author Joseph Sigar
 */
public class Login {

    /**
     * A parameter to store Customer Username
     */
    private String userName;

    /**
     * A parameter to store Customer Password
     */
    private String passWord;

    /**
     * The Login constructor. The constructor is called upon when the Login
     * class is created. This constructor initializes the parameter to the
     * program default values
     */
    public Login() {
        // initializing the login parameters to the default values
        userName = "";
        passWord = "";
    }

    /**
     * A Login Constructor. The Constructor is called upon when the Login class
     * is created and the user specifies their username and password
     *
     * @param userName user-defined username
     * @param passWord user-defined password
     */
    public Login(String userName, String passWord) {
        // Constructor that initializes using user-defined parameters
        this.userName = userName;
        this.passWord = passWord;
    }

    /**
     * A method that returns the parameters to the program default values.
     */
    public void clear() {
        // setting the parameters to default values
        userName = "";
        passWord = "";
    }

    /**
     * A method used to retrieve the Customer Login username
     *
     * @return the Customer username ID
     */
    public String getUserName() {
        // a getter method for username
        return userName;
    }

    /**
     * A method used to retrieve the Customer Login password
     *
     * @return the Customer Login password
     */
    public String getPassWord() {
        // a getter method for the password
        return passWord;
    }

    /**
     * A method used to set the Customer Login username to a user-defined
     * username
     *
     * @param userName user-defined username provided by the Customer
     */
    public void setUserName(String userName) {
        // a setter method for the customer username
        this.userName = userName;
    }

    /**
     * A method used to set the Customer Login password to a user-defined
     * password
     *
     * @param passWord a user-defined password provided by the Customer
     */
    public void setPassWord(String passWord) {
        // a setter method for the customer password
        this.passWord = passWord;
    }

    /**
     * A method that Overrides the hachcode method of the Class. This is to
     * allow better handling, storing and manipulation of the specific data.
     *
     * @return the hashcode to be used by other classes/programs
     */
    @Override
    public int hashCode() {
        // overriding this allows better handling of the login details.
        // Also allows as to efficiently compare different Login objects.
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        // Simplified and maybe more efficient way of writing an if-statement
        result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
        return result;
    }

    /**
     * A method that Overrides the equals methods of the class. This allows a
     * more specific class-oriented comparing
     *
     * @param obj object to be provided by the user
     * @return whether two Login Objects are equal or not.
     */
    @Override
    public boolean equals(Object obj) {
        // The closest java gets to operator overloading. 
        // This allows two Login objects to be compared 
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Login other = (Login) obj;

        if (userName == null) {
            if (other.userName != null) {
                return false;
            }
        } else if (!userName.equals(other.userName)) {
            return false;
        }

        if (passWord == null) {
            if (other.passWord != null) {
                return false;
            }
        } else if (!passWord.equals(other.passWord)) {
            return false;
        }

        return true;
    }
    
     /**
     * A method used to copy one Login object to another.
     * @return a login object that contains the content of another
     * @throws java.lang.CloneNotSupportedException 
     */
    @Override
    public Login clone() throws CloneNotSupportedException {
        // a method used for copying one login object to another
        Login login = new Login();
        login.userName = this.userName;
        login.passWord = this.passWord;
        
        return login;
    }
}
