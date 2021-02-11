package financialportal;

/**
 * Class that will hold all of the data for the account table in our database.
 *
 * @author Christian Kasel
 */
public class Account {

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
        this.amount = amount;
        this.institution = institution;
        this.type = type;
    }

    /**
     * Function to return the amount of money (in US currency) the account has
     *
     * @return the amount of money (in US currency) the account has
     */
    public double getAmount() {
        return amount;
    }

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
}
