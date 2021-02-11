package financialportal;

import java.sql.Date;

/**
 * Class that will hold all of the data for the loans table in our database.
 *
 * @author Christian Kasel
 */
public class Loan {

    private double interest;
    private double paid;
    private double remaining;
    private double total;

    /**
     * Constructor to create a loan with the interest, paid, total, and
     * remaining variables
     *
     * @param interest the interest percent of the loan
     * @param paid the amount the user has paid of the loan
     * @param remaining the remaining amount of time left to pay off the loan
     * @param total the starting total amount the loan was for
     */
    public Loan(double interest, double paid, double remaining, double total) {
        this.interest = interest;
        this.paid = paid;
        this.remaining = remaining;
        this.total = total;
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

    /**
     * Function to return the starting total amount of the loan
     *
     * @return the starting total amount of the loan
     */
    public double getTotal() {
        return total;
    }

}
