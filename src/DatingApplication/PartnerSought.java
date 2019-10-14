/*
 * Title: Mr
 * Author: Joseph Sigar
 * Date: 12/04/2018
 * File name: Question 2
 * 
 * Purpose: To be able to store an Advertiser description of the the kind of 
 * partner they are looking for. A class that stores information that could 
 * be used to filter to the potential lists to a customer defined specification
 * 
 * Assumption:
 * 1. An advertiser has to specify a gender they may prefer.
 * 2. Only 2 genders are required for this prototype.
 * 3. The age input is an integer
 * 4. The Income input is an integer
 * 5. The acceptable minimum age range is 16 and a maximum of 100
 * 6. The income ranges from 0 to 1000000
 * 
 * Condition of input:
 * gender       -       String  = M, m or F, f
 * age range    -       integer array of size 2. first element cant be less than
 *                      16 or greater than second element. The second element
 *                      cant be less than or equal to first element and cant be 
 *                      more than 100.
 * income range    -    integer array of size 2. first element cant be less than
 *                      0 or greater than second element. The second element
 *                      cant be less than or equal to first element and cant be 
 *                      more than 1000000.
 * 
 * Expected Output:
 * gender       -       lowercase String, e.g. m, f.
 * age Range    -       integer array that denotes the range.
 * income Range -       integer array that denotes the range.
 */
package DatingApplication;

import java.util.InputMismatchException;

/**
 * A Class that handles the information criteria an Advertiser customer would be
 * interested in.
 *
 * @version 1.02 12 Apr 2018
 * @author Joseph Sigar
 */

public class PartnerSought {

    /**
     * A parameter to store the gender the Advertiser is looking for.
     */
    private String gender;

    /**
     * A parameter that stores the age range that an Advertiser would be
     * interested in
     */
    private int[] ageRange;

    /**
     * A parameter that stores the income range that an Advertiser would be
     * interested in
     */
    private int[] incomeRange;

    /**
     * The default constructor that is called upon when a new PartnerSought
     * Object is created. The constructor initializes the parameters to the
     * program default values.
     */
    public PartnerSought() {
        // Using the constructor to initialize the PartnerSought parameters.
        gender = "";
        ageRange = new int[2];
        incomeRange = new int[2];
    }

    /**
     * A Constructor that initializes the class parameters to those set by the
     * user. Is called upon when referenced by the user.
     *
     * @param gender of the interest, set by the Advertiser
     * @param ageRange of interest set by the Advertiser
     * @param incomeRange of interest set by the Advertiser
     *
     * @throws UnknownOpException Throws an UnknownOpException for the input
     * parameters from the user
     * @throws InputMismatchException Throws an InputMismatchException for the
     * age and income parameters
     */
    public PartnerSought(String gender, int ageRange[], int incomeRange[]) throws InputMismatchException, UnknownOpException {
        // A constructor that initializes the parameters. also throws exceptions around for
        // wrong input.

        if (!gender.toLowerCase().equals("m") && !gender.toLowerCase().equals("f")) {
            throw new UnknownOpException("Invalid Gender entered");
        }

        if (ageRange[0] < 16 || ageRange[0] >= ageRange[1] || ageRange[1] > 100) {
            throw new UnknownOpException("Invalid Age range entered.");
        }

        if (incomeRange[0] < 0 || incomeRange[0] >= incomeRange[1] || incomeRange[1] > 1000000) {
            throw new UnknownOpException("Invalid income range entered.");
        }

        this.gender = gender.toLowerCase();
        this.ageRange = new int[2];
        this.ageRange[0] = ageRange[0];
        this.ageRange[1] = ageRange[1];
        this.incomeRange = new int[2];
        this.incomeRange[0] = incomeRange[0];
        this.incomeRange[1] = incomeRange[1];

    }

    /**
     * A method that returns the parameters to the program default values.
     */
    public void clear() {
        // setting the parameters to default values
        gender = "";

        ageRange = new int[2];
        incomeRange = new int[2];
    }

    /**
     * A method that returns the gender an Advertiser is interested in
     *
     * @return the Gender preference of the Advertiser
     */
    public String getGender() {
        // getter method of the gender
        return gender;
    }

    /**
     * A method used to set the Preferred Gender of the Advertiser to a
     * User-defined value
     *
     * @param gender user-defined value that indicates the preferred gender
     * @throws UnknownOpException throws an UnknowOpException for the input.
     */
    public void setGender(String gender) throws UnknownOpException {
        // A setter method with an exception thrown for input checking
        if (!gender.toLowerCase().equals("m") && !gender.toLowerCase().equals("f")) {
            throw new UnknownOpException("Invalid Gender entered");
        }

        this.gender = gender.toLowerCase();
    }

    /**
     * A method that retrieves the preferred age range set by the Advertiser
     *
     * @return an integer array containing the age range
     */
    public int[] getAgeRange() {
        // a getter method for the age range
        return ageRange;
    }

    /**
     * A method used to set the preferred age range of the Advertiser. Sets the
     * age range to a user-defined integer values.
     *
     * @param ageRange an integer array defined by the user
     * @throws UnknownOpException throws an UnknowOpException for the input.
     * @throws InputMismatchException throws an InputMismatchException for the
     * age values.
     */
    public void setAgeRange(int[] ageRange) throws UnknownOpException, InputMismatchException {
        // A setter method for the age range. throws exceptions
        if (ageRange[0] < 16 || ageRange[1] > 100) {
            throw new UnknownOpException("Invalid Age range entered.");
        } else if ( ageRange[0] >= ageRange[1] )
            throw new UnknownOpException("Input 1 cannot be greater than input 2");

        this.ageRange = ageRange;
    }

    /**
     * A method used to retrieve the preferred income ranges set by the
     * Advertiser
     *
     * @return an integer array containing the income range
     */
    public int[] getIncomeRange() {
        // a getter method for the income range 
        return incomeRange;
    }

    /**
     * A method used to set the preferred income range of the Advertiser. Sets
     * the age range to a user-defined integer values.
     *
     * @param incomeRange an integer array defined by the user
     * @throws UnknownOpException throws an UnknowOpException for the input.
     * @throws InputMismatchException throws an InputMismatchException for the
     * income values.
     */
    public void setIncomeRange(int[] incomeRange) throws UnknownOpException, InputMismatchException {
        // a setter method for the income range. throws out some exception

        if (incomeRange[0] < 0 || incomeRange[1] > 1000000) {
            throw new UnknownOpException("Invalid income range entered.");
        } else if ( incomeRange[0] >= incomeRange[1])
            throw new UnknownOpException("Input 1 cannot be greater than input 2");

        this.incomeRange = incomeRange;
    }

    /**
     * A method used to check whether an Advertiser has already entered the
     * preferred value or not
     *
     * @return a boolean indicating true when the PartnerSought Object is
     * "empty" or false if an Advertiser already inputted their preference.
     */
    public boolean isNotSet() {
        return ageRange[0] == 0 && ageRange[1] == 0 && incomeRange[0] == 0 && incomeRange[1] == 0;
    }
    
     /**
     * A method used to copy one PartnerSought object to another.
     * @return a copied partnerSought object 
     * @throws java.lang.CloneNotSupportedException 
     */
    @Override
    public PartnerSought clone() throws CloneNotSupportedException {
        // Copies one PartnerSought object to another 
        PartnerSought partnerSought = new PartnerSought();
        
        partnerSought.gender = this.gender;
        partnerSought.ageRange[0] = this.ageRange[0];
        partnerSought.ageRange[1] = this.ageRange[1];
        partnerSought.incomeRange[0] = this.incomeRange[0];
        partnerSought.incomeRange[1] = this.incomeRange[1];
        
        return partnerSought;
    }

}
