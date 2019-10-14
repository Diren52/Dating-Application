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
import java.util.Scanner;

/**
 * The client main program.
 *
 * @version 1.02 12 Apr 2018
 * @author Joseph Sigar
 */
public class DatingAppClientProg {

    static Scanner kb = new Scanner(System.in);
// Client side programming 

    /**
     * The main program that runs the system.
     * @param args
     * @throws UnknownOpException
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws UnknownOpException, CloneNotSupportedException {
        ServiceIO service = new ServiceIO();

        int choice;
        displayStudentDetails();
        System.out.println();
        do {
            displayMainMenu();
            System.out.print("\n> ");
            choice = kb.nextInt();
            System.out.println();
            doChoice(choice, service);
            System.out.println();
        } while (choice != 4);

    }

    /**
     * Displays the main menu to the user.
     */
    public static void displayMainMenu() {
        System.out.println("====================================");
        System.out.println("Welcome to @urdoch Dating App.");
        System.out.println("====================================");
        System.out.println("Would you like to: ");
        System.out.println("1:  Create account");
        System.out.println("2.  Login");
        System.out.println("3.  Management Stuff");
        System.out.println("4.  Exit");
        System.out.println("====================================");
    }

    /**
     * does the choice a user choose from the main menu.
     * @param choice
     * @param service
     * @throws UnknownOpException
     * @throws CloneNotSupportedException
     */
    public static void doChoice(int choice, ServiceIO service) throws UnknownOpException, CloneNotSupportedException {

        String username, password;
        int choice2;

        switch (choice) {
            case 1: {
                Customer cust = new Customer();

                System.out.println("\n=============================================");
                System.out.format("%30s", "Create Account");
                System.out.println("\n=============================================");
                createAccount(cust);
                System.out.println("---------------------------------------------");
                System.out.println("Please choose between being an Advertiser (A) or a Responder (R)");
                cust.setDenomination(kb.next());
                System.out.println("---------------------------------------------");
                System.out.println("\nThank you for entering the details.");
                System.out.println("\n---------------------------------------------");
                System.out.println("Press Y to access your login details\nPress anything else to delete your details");
                String log = kb.next();

                if (log.equalsIgnoreCase("Y")) {
                    Login login = new Login();
                    System.out.println("---------------------------------------------");
                    System.out.println("\nEnter your desired login name: ");
                    String usr = kb.next();
                    login.setUserName(usr);

                    System.out.println("Here is your default password: " + service.defaultPassWord(cust));
                    
                    login.setPassWord(service.defaultPassWord(cust));
                    cust.setLogin(login);

                    service.addCustomer(cust.getLogin(), cust);
                } else {
                    cust.clear();
                }
                System.out.println("=============================================");
            }
            break;
            case 2: {
                System.out.println("=============================");
                System.out.print("Username: ");
                username = kb.next();
                System.out.print("Password: ");
                password = kb.next();
                System.out.println("=============================");

                Login login = new Login(username, password);

                if (!service.loginAuth(login)) {
                    System.out.println("You have entered an invalid login details.\nTry again.");

                } else {
                    System.out.println("\nYou have Successfully logged in.\n");

                    if (service.getCustomer(login).getDenomination().equalsIgnoreCase("a")) {
                        do {
                            System.out.println("=====================================================");
                            System.out.format( "%40s", "Welcome " + service.getCustomer(login).getFirstName() + " " + service.getCustomer(login).getLastName());
                            System.out.println("\n=====================================================");
                            if (service.getAdvertiser(login).getPartnerSought().isNotSet()) {
                                advertiserPartnerPreference(service, login);
                                System.out.println("-----------------------------------------------------\n");
                            }

                            advertiserMenu();
                            System.out.print("> ");
                            choice2 = kb.nextInt();

                            advertiserMenuChoice(service, login, choice2);
                            
                        } while (choice2 != 6 && choice2 != 7);

                    } else if (service.getCustomer(login).getDenomination().equalsIgnoreCase("r")) {
                        do {
                            System.out.println("=====================================================");
                            System.out.format( "%40s", "Welcome " + service.getCustomer(login).getFirstName() + " " + service.getCustomer(login).getLastName());
                            System.out.println("\n=====================================================");
                            responderMenu();
                            System.out.print("\n> ");
                            choice2 = kb.nextInt();
                            
                            responderMenuChoice(service, login, choice2);
                            kb.nextLine();
                            
                        } while (choice2 != 3 && choice2 != 4);
                    }
                    
                }
            }
            break;
            case 3: {
                do {
                    managementMenu();
                    System.out.print("\n> ");
                    choice2 = kb.nextInt();
                    System.out.println();
                    switch (choice2) {
                        case 1:
                            createTestAccounts(service);
                            break;
                        case 2:
                            System.out.println("=============================================================================================================");
                            System.out.format("%70s", "Advertiser's in the Dating Service\n");
                            System.out.println("=============================================================================================================");
                            System.out.format("%1s%15s%15s%15s%15s%15s%15s%15s%3s", "|", "First Name", "Last Name", "Age", "Gender", "Income", "Username", "Password", "|");
                            System.out.println("\n=============================================================================================================");
                            
                            for (Advertiser print : service.getAllAdvertisers()) {
                                System.out.format("%1s%15s%15s%15s%15s%15s%15s%15s%3s", "|", print.getFirstName(), print.getLastName(), print.getAge(), print.getGender(), print.getIncome(), print.getLogin().getUserName(), print.getLogin().getPassWord(), "|");
                                System.out.println();
                            }
                            System.out.println("=============================================================================================================");
                            System.out.println();
                            break;
                        case 3:
                            System.out.println("=============================================================================================================");
                            System.out.format("%70s", "Responder's in the Dating Service\n");
                            System.out.println("=============================================================================================================");
                            System.out.format("%1s%15s%15s%15s%15s%15s%15s%15s%3s", "|", "First Name", "Last Name", "Age", "Gender", "Income", "Username", "Password", "|");
                            System.out.println("\n=============================================================================================================");
                            
                            for (Responder print : service.getAllResponders()) {
                                System.out.format("%1s%15s%15s%15s%15s%15s%15s%15s%3s", "|", print.getFirstName(), print.getLastName(), print.getAge(), print.getGender(), print.getIncome(), print.getLogin().getUserName(), print.getLogin().getPassWord(), "|");
                                System.out.println();
                            }
                            System.out.println("=============================================================================================================");
                            System.out.println();
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("You have chosen the wrong number");
                            break;
                    }
                } while (choice2 != 4);
            }
            break;
            case 4: {
                System.out.println("You are Exiting the App.");
            }
            break;
            default:
                System.out.println("You have entered an Invalid option. See Menu again");
                break;

        }
    }

    /**
     * converting from string to int array.
     * @param str
     * @return
     */
    public static int[] fromStringTo(String str) {
        int[] obj = new int[2];

        obj[0] = Integer.parseInt(str.substring(0, str.indexOf("-")));
        obj[1] = Integer.parseInt(str.substring(str.indexOf("-") + 1, str.length()));

        return obj;
    }

    /**
     * A menu to be used by the management side of the program.
     */
    public static void managementMenu() {
        System.out.println("======================================================");
        System.out.println("Management Menu:");
        System.out.println("======================================================");
        System.out.println("1. Create Multiple fake accounts for testing purposes.");
        System.out.println("2. View all Advertiser Customers in the System");
        System.out.println("3. View all Responder Customers in the System");
        System.out.println("4. Go Back");
        System.out.println("======================================================");
    }

    /**
     * A method to allow the user to enter their details.
     * @param customer
     */
    public static void createAccount(Customer customer) {
        
        try {
        System.out.println("Enter your details here: ");
        System.out.print("First name: ");
        customer.setFirstName(kb.next());
        System.out.print("Lastname: ");
        customer.setLastName(kb.next());
        System.out.print("Age: ");
        customer.setAge(kb.nextInt());
        System.out.print("Gender: ");
        customer.setGender(kb.next());
        System.out.print("Income: ");
        customer.setIncome(kb.nextInt());
        } catch (UnknownOpException e) {
            System.out.println(e.getMessage());
            System.out.println("\nPlease Enter your details Correctly: \n");
            createAccount(customer);
        } catch (InputMismatchException e2) {
            System.out.println("\nPlease Enter your details Correctly: \n");
            createAccount(customer);
        }
    }

    /**
     * A menu for responder's.
     */
    public static void responderMenu() {
        System.out.println("1. View Advertisements. ");
        System.out.println("2. Update Account.");
        System.out.println("3. Delete Account.");
        System.out.println("4. Logout");
        System.out.println("======================================================");
    }

    /**
     * A menu for advertiser's.
     */
    public static void advertiserMenu() {
        System.out.println("1. View Replies");
        System.out.println("2. View Partner match preferences");
        System.out.println("3. Update Partner match preferences");
        System.out.println("4. Delete Partner preferences");
        System.out.println("5. Update Account.");
        System.out.println("6. Delete Account.");
        System.out.println("7. Logout");
        System.out.println("======================================================");
    }

    /**
     * Allows the user to set their partner preference.
     * @param service
     * @param login
     * @throws CloneNotSupportedException
     */
    public static void advertiserPartnerPreference(ServiceIO service, Login login) throws CloneNotSupportedException {
        PartnerSought partnerSought = new PartnerSought();
        
        try {
        System.out.println("\n-----------------------------------------------------");
        System.out.println("Please enter the following details: ");
        System.out.println("-----------------------------------------------------");
        System.out.println("Advertising text: (DO NOT press enter until you are done.) ");
        kb.nextLine();
        service.getAdvertiser(login).setTextAdvert(kb.nextLine());
        System.out.println("\n-----------------------------------------------------");
        System.out.println("What kind of Partner are you looking for: ");
        System.out.println("Gender: ");
        partnerSought.setGender(kb.next());
        System.out.println("Age Range (nn - nnn): ");
        kb.nextLine();
        String ageRange = kb.nextLine().trim().replaceAll("\\s", "");
        partnerSought.setAgeRange(fromStringTo(ageRange));

        System.out.println("Income Range (nn - nnn): ");
        String incomeRange = kb.nextLine().trim().replaceAll("\\s", "");

        partnerSought.setIncomeRange(fromStringTo(incomeRange));
        service.getAdvertiser(login).setPartnerSought(partnerSought);

        service.addAdvertiser(login, service.getAdvertiser(login));

        System.out.println("Thank you for the input.");
        } catch (UnknownOpException e) {
            System.out.println(e.getMessage());
            System.out.println("\nPlease Enter the details Correctly: \n");
            advertiserPartnerPreference(service, login);
        } catch(InputMismatchException e2) {
            System.out.println("\nPlease Enter the details Correctly: \n");
            advertiserPartnerPreference(service, login);
            
        }

    }

    /**
     * A menu to be used by the advertiser customer and the choice they make.
     * @param service
     * @param login
     * @param choice
     * @throws CloneNotSupportedException
     * @throws UnknownOpException
     */
    public static void advertiserMenuChoice(ServiceIO service, Login login, int choice) throws CloneNotSupportedException, UnknownOpException {
        int replyChoice;
        int deleteReply;
        String gender;

        switch (choice) {
            case 1: {
                System.out.println("You have " + service.getAdvertiser(login).getReplyMessageList().size() + " replies");
                if (!service.viewReplies(login).isEmpty()) {

                    do {
                        for (int i = 0; i < service.viewReplies(login).size(); i++) {
                            System.out.println(i + 1 + "\nFrom: " + service.viewReplies(login).get(i).getResponder().getFirstName()
                                    + " " + service.viewReplies(login).get(i).getResponder().getLastName()
                                    + " Age: " + service.viewReplies(login).get(i).getResponder().getAge()
                                    + " Gender: " + service.viewReplies(login).get(i).getResponder().getGender()
                                    + " Income: " + service.viewReplies(login).get(i).getResponder().getIncome());
                            System.out.println("Reply > " + service.viewReplies(login).get(i).getReply());
                            System.out.println();
                        }

                        System.out.println("\n1. Delete Reply");
                        System.out.println("0. Go back");

                        System.out.print("> ");
                        replyChoice = kb.nextInt();

                        if (replyChoice == 1) {
                            System.out.print("\nPlease specify the reply you'd like to delete 1 to " + service.getAdvertiser(login).getReplyMessageList().size() + ": \n> ");
                            deleteReply = kb.nextInt();

                            service.getAdvertiser(login).removeReplyMessage(service.viewReplies(login).get(deleteReply - 1));

                        }
                        System.out.println("\nYou have " + service.getAdvertiser(login).getReplyMessageList().size() + " replies\n");
                    } while (replyChoice != 0 && !service.viewReplies(login).isEmpty());
                }
            }
            break;
            case 2: {
                PartnerSought partnerView = new PartnerSought();

                partnerView = service.getAdvertiser(login).getPartnerSought().clone();

                System.out.println("\nYou Partner Preference is Someone who is: ");
                if (partnerView.getGender().equals("m")) {
                    gender = "male";
                } else {
                    gender = "female";
                }
                System.out.println(gender);
                System.out.println("\nAround the age of: \n" + partnerView.getAgeRange()[0] + " to " + partnerView.getAgeRange()[1]);
                System.out.println("\nWho's income is around: \n" + partnerView.getIncomeRange()[0] + " to " + partnerView.getIncomeRange()[1] + " \n");
            }
            break;
            case 3: {
                advertiserPartnerPreference(service, login);
            }
            break;
            case 4: {
                service.getAdvertiser(login).setTextAdvert("");
                service.getAdvertiser(login).getPartnerSought().clear();
                System.out.println("You Partner Preference has been deleted. \nNow Please set a new Partner Preference\n");
            }
            break;
            case 5: {
                Advertiser advert = new Advertiser();

                advert.setLogin(service.getAdvertiser(login).getLogin());
                advert.setTextAdvert(service.getAdvertiser(login).getTextAdvert());
                advert.setPartnerSought(service.getAdvertiser(login).getPartnerSought());
                advert.setReplyMessageList(service.getAdvertiser(login).getReplyMessageList());
                createAccount(advert);
                advert.setDenomination("a");

                service.addAdvertiser(login, advert);
            }
            break;
            case 6: {
                System.out.println("\nThank you for being us. Until next time. \n");
                service.removeCustomer(login);
            }
            break;
            case 7: {
                System.out.println("\nYou are logging out. Thank you\n");
            }
            break;
            default:
                System.out.println("You have entered an Invalid option. See Menu again");
                break;

        }
    }

    /**
     * A menu to be used by the responder customer and the choice they make.
     * @param service
     * @param login
     * @param choice
     * @throws CloneNotSupportedException
     * @throws UnknownOpException
     */
    public static void responderMenuChoice(ServiceIO service, Login login, int choice) throws CloneNotSupportedException, UnknownOpException {
        int replyChoice;
        String reply;
        ArrayList<Advertiser> matches = new ArrayList<>();
        switch (choice) {
            case 1: {
                service.getMatches(service.getResponder(login), matches);

                System.out.println("\n=====================================================");
                System.out.format("%40s", "View Advertisements");
                System.out.println("\n=====================================================");
                System.out.format("%40s","You have " + matches.size() + " Adverts");
                System.out.println("\n-----------------------------------------------------");

                if (!matches.isEmpty()) {

                    do {
                        
                            System.out.println("================================================================================================================================");
                            System.out.format("%1s%15s%15s%15s%15s%15s%30s", "Advert. no.", "First Name", "Last Name", "Age", "Gender", "Income", "Advertisement Text");
                            System.out.println("\n================================================================================================================================");
                        for (int i = 0; i < matches.size(); i++) {

                            System.out.format( "%1s%25s%15s%15s%15s%15s%40s",i + 1, matches.get(i).getFirstName(), matches.get(i).getLastName(), matches.get(i).getAge(), matches.get(i).getGender(), matches.get(i).getIncome(), matches.get(i).getTextAdvert());
                            System.out.println();
                        }
                        System.out.println("================================================================================================================================");
                        System.out.println();

                        System.out.println("-----------------------------------------------------");
                        System.out.println("1. Send Reply to (1 to " + matches.size() + ")");
                        System.out.println("0. Go back");
                        System.out.print("> ");
                        replyChoice = kb.nextInt();

                        if (replyChoice != 0) {
                            System.out.println("\n-----------------------------------------------------");
                            System.out.println("Reply for " + matches.get(replyChoice - 1).getFirstName() + " here");
                            System.out.println("-----------------------------------------------------");
                            System.out.print("> ");
                            kb.nextLine();
                            reply = kb.nextLine();
                            service.sendReply(service.getResponder(login), reply, matches.get(replyChoice - 1));
                        }

                        System.out.println("-----------------------------------------------------\n");
                    } while (replyChoice != 0);

                }
            }
            break;
            case 2: {
                Responder respond = new Responder();

                respond.setLogin(service.getResponder(login).getLogin());
                System.out.println("\n=============================================");
                System.out.format("%30s", "Update Account");
                System.out.println("\n=============================================");
                createAccount(respond);
                respond.setDenomination("a");
                System.out.println("=============================================\n");

                service.addResponder(login, respond);
            }
            break;
            case 3: {
                System.out.println("\n=============================================");
                System.out.println("Thank you for being us. Until next time.");
                System.out.println("=============================================");
                service.removeCustomer(login);
            }
            break;
            case 4: {
                System.out.println("\nYou are logging out. Thank you");
            }
            break;
            default:
                System.out.println("You have entered an Invalid option. See Menu again");
                break;
        }
    }

    /**
     * Creates multiple accounts for testing purposes.
     * @param service
     * @throws CloneNotSupportedException
     * @throws UnknownOpException
     */
    public static void createTestAccounts(ServiceIO service) throws CloneNotSupportedException, UnknownOpException {
        Login log1 = new Login("A", "B");
        Customer cust = new Customer("John", "Mary", "M", 24, 0, "R", log1);

        Login log2 = new Login("C", "D");
        Customer cust2 = new Customer("Jonathan", "Mooon", "F", 100, 1000, "r", log2);

        Login log3 = new Login("E", "F");
        Responder cust3 = new Responder("Kyle", "Jenn", "f", 40, 24000, log3);

        Login log4 = new Login("G", "H");
        Responder cust4 = new Responder("Kany", "Best", "m", 16, 1000000, log4);

        Login log5 = new Login("I", "J");
        Responder cust5 = new Responder("Fer", "Dous", "m", 35, 4500, log5);

        Login log6 = new Login("K", "L");
        Responder cust6 = new Responder("Soh", "El", "f", 55, 999, log6);

        Login log7 = new Login("a", "b");
        Customer cust7 = new Customer("Tru", "Mp", "M", 70, 999999, "A", log7);

        Login log8 = new Login("c", "d");
        Customer cust8 = new Customer("Vice", "Chan", "F", 20, 1000, "a", log8);

        Login log9 = new Login("e", "f");
        int[] ageR = {16, 100};
        int[] incR = {0, 1000000};
        PartnerSought part1 = new PartnerSought("f", ageR, incR);
        Advertiser cust9 = new Advertiser("Bryan", "Davis", "m", 78, 97866, log9, "Yeah Baby person", part1, new ArrayList<>());

        Login log10 = new Login("g", "h");
        int[] ageR1 = {20, 30};
        int[] incR1 = {0, 100};
        PartnerSought part2 = new PartnerSought("m", ageR1, incR1);
        Advertiser cust10 = new Advertiser("Ishani", "Sharma", "f", 45, 5665, log10, "You get what you dont want", part2, new ArrayList<>());

        Login log11 = new Login("i", "j");
        int[] ageR2 = {30, 50};
        int[] incR2 = {100, 5000};
        PartnerSought part3 = new PartnerSought("f", ageR2, incR2);
        Advertiser cust11 = new Advertiser("Wick", "Mooon", "m", 23, 100, log11, "Im the best at what i do", part3, new ArrayList<>());

        Login log12 = new Login("k", "l");
        int[] ageR3 = {16, 90};
        int[] incR3 = {0, 1000};
        PartnerSought part4 = new PartnerSought("m", ageR3, incR3);
        Advertiser cust12 = new Advertiser("Moon", "Mooon", "f", 100, 1000, log12, "******** I do alot of ******* ", part4, new ArrayList<>());

        service.addCustomer(log1, cust);
        service.addCustomer(log2, cust2);
        service.addResponder(log3, cust3);
        service.addResponder(log4, cust4);
        service.addResponder(log5, cust5);
        service.addResponder(log5, cust5);
        service.addResponder(log6, cust6);
        service.addCustomer(log7, cust7);
        service.addCustomer(log8, cust8);
        service.addAdvertiser(log9, cust9);
        service.addAdvertiser(log10, cust10);
        service.addAdvertiser(log11, cust11);
        service.addAdvertiser(log12, cust12);
    }

    /**
     * Displays the Author details.
     */
    public static void displayStudentDetails() {
        System.out.println("Name: Joseph Sigar");
        System.out.println("Student Number: 32492428");
        System.out.println("Mode of Enrolment: Internal");
        System.out.println("Tutor name: Ferdous Sohel");
        System.out.println("Tutorial Day: Tuesday \nTutrial Time: 1330-1430");
    }
}
