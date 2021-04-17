package financialportal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Class that will hold all of the data for the account table in our database.
 *
 * @author Christian Kasel
 */
public class Account extends Information{

    private double amount;
    private String institution;
    private String type;

    /**
     * Constructor to create an account with the amount, institution, and type
     *
     * @param amount the amount of money (in US currency) the account has
     * @param institution the institution in which the money is being held
     * @param type the type of account in case there are multiple within an
     * institution
     */
    public Account(double amount, String institution, String type) {
        super(amount);
        this.amount = amount;
        this.institution = institution;
        this.type = type;
    }

    public static Comparator<Account> AccountFrameComparator = new Comparator<Account>() {
        @Override
        public int compare(Account a1, Account a2) {
            //ascending order
            return a1.getInstitution().compareTo(a2.getInstitution());
        }
    };

    /**
     * Function to return the institution in which the money is being held
     *
     * @return the name of the institution
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * Function to return the account type in case there are multiple within an
     * institution
     *
     * @return the type of the account within the institution
     */
    public String getType() {
        return type;
    }

    /**
     * Function to print the accounts information
     */
    @Override
    public void print() {
        System.out.println("\nAcounts:\n-------------------------");
        System.out.println("Amount: " + amount + " Institution: " + institution + " Type: " + type);
    }
}
