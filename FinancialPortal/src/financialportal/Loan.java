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
    private int loanID;
    private double paid;

    /**
     * Constructor to create a loan with the interest, paid, amount, and
     * remaining variables
     *
     * @param amount the starting amount amount the loan was for
     * @param due the date in which the loan is due
     * @param interest the interest percent of the loan
     * @param loanID
     * @param paid the amount the user has paid of the loan
     */
    public Loan(double amount, String due, double interest, int loanID, double paid) {
        super(amount);
        this.amount = amount;
        this.due = due;
        this.interest = interest;
        this.loanID = loanID;
        this.paid = paid;
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

    public int getLoanID() {
        return loanID;
    }

    /**
     * Function to return the amount paid towards the loan
     *
     * @return the amount paid towards the loan
     */
    public double getPaid() {
        return paid;
    }

    @Override
    public void print() {
        System.out.println("\nLoans:\n-------------------------");
        System.out.println("Amount: " + amount + " Interest: " + interest + " LoanID: " + loanID + " Paid: " + paid);
    }
}
