package financialportal;

/**
 * Class that will hold all of the data for the loans table in our database.
 *
 * @author Christian Kasel
 */
public class Loan extends Information {

    private double amount;
    private String due;
    private double interest;
    private double paid;
    private double remaining;

    /**
     * Constructor to create a loan with the interest, paid, amount, and
     * remaining variables
     *
     * @param amount the starting amount amount the loan was for
     * @param due the date in which the loan is due
     * @param interest the interest percent of the loan
     * @param paid the amount the user has paid of the loan
     * @param remaining the remaining amount of time left to pay off the loan
     */
    public Loan(double amount, String due, double interest, double paid, double remaining) {
        super(amount);
        this.amount = amount;
        this.due = due;
        this.interest = interest;
        this.paid = paid;
        this.remaining = remaining;
    }

    public String getDue() {
        return due;
    }

    /**
     * Function to return the interest of the loan
     *
     * @return the interest of the loan
     */
    public double getInterest() {
        return interest;
    }

    /**
     * Function to return the amount paid towards the loan
     *
     * @return the amount paid towards the loan
     */
    public double getPaid() {
        return paid;
    }

    /**
     * Function to return the time remaining to pay off the loan
     *
     * @return the time remaining to pay off the loan
     */
    public double getRemaining() {
        return remaining;
    }

    @Override
    public void print() {
        System.out.println("\nLoans:\n-------------------------");
        System.out.println("Amount: " + amount + " Interest: " + interest + " Paid: " + paid + " Remaining: " + remaining);
    }
}
