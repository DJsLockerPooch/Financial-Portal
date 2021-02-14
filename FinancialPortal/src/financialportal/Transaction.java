package financialportal;

/**
 * Class that will hold all of the data for the transaction table in our
 * database.
 *
 * @author Christian Kasel
 */
public class Transaction extends Information {

    private double amount;
    private String date;
    private String institution;

    /**
     * Constructor to create a transaction with amount, date, and institution
     *
     * @param amount the amount of money (in US currency) the was involved in
     * the transaction
     * @param date the date of which the transaction occurred
     * @param institution the institution in which the transaction happened
     */
    public Transaction(double amount, String date, String institution) {
        super(amount);
        this.amount = amount;
        this.date = date;
        this.institution = institution;
    }

    /**
     * Function to get the date of the transaction
     *
     * @return the date of the transaction
     */
    public String getDate() {
        return date;
    }

    /**
     * Function to return the institution in which the transaction happened
     *
     * @return the institution in which the transaction happened
     */
    public String getInstitution() {
        return institution;
    }

    @Override
    public void print() {
        System.out.println("\nTransactions:\n-------------------------");
        System.out.println("Amount: " + amount + " Date: " + date + " Institution: " + institution);
    }

}
