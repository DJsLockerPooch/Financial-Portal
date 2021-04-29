package financialportal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that will hold all of the data for the loans table in our database.
 *
 * @author Christian Kasel
 */
public class Loan extends Information {

    private double amount;
    private String due;
    private String institution;
    private double interest;
    private int loanID;
    private double paid;
    private String sdf;

    /**
     * Constructor to create a loan with the interest, paid, amount, and
     * remaining variables
     *
     * @param amount the starting amount amount the loan was for
     * @param due the date in which the loan is due
     * @param institution
     * @param interest the interest percent of the loan
     * @param loanID
     * @param paid the amount the user has paid of the loan
     */
    public Loan(double amount, String due, String institution, double interest, int loanID, double paid) {
        super(amount);
        this.amount = amount;
        this.due = due;
        this.institution = institution;
        this.interest = interest;
        this.loanID = loanID;
        this.paid = paid;
        SimpleDateFormat sdf1 = new SimpleDateFormat("MMM dd yyyy");
        Date d1 = null;
        try {
            d1 = sdf1.parse(due);
        } catch (ParseException ex) {
            Logger.getLogger(Spending.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.sdf = sdf1.format(d1);
    }

    /**
     * Comparator to compare which loan is "less" or "greater" than another loan
     * by institution and loan ID
     */
    public static Comparator<Loan> LoanFrameComparator = (Loan l1, Loan l2) -> {
        String f1 = l1.getInstitution() + l1.getLoanID();
        String f2 = l2.getInstitution() + l2.getLoanID();
        //ascending order
        return f1.compareTo(f2);
    };

    /**
     * Function to return the due date of the loan
     *
     * @return
     */
    public String getDue() {
        return due;
    }

    /**
     * Function to return the loan's institution
     *
     * @return the loan's institution
     */
    public String getInstitution() {
        return institution;
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
     * Function to return the laonID
     *
     * @return the loanID being returned
     */
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

    /**
     * Function to return the simple date format MMM DD YYYY
     *
     * @return the Simple Date Format MMM DD YYYY
     */
    public String getSDF() {
        return sdf;
    }

    /**
     * Function to print out the loan based on it's criteria
     */
    @Override
    public void print() {
        System.out.println("\nLoans:\n-------------------------");
        System.out.println("Amount: " + amount + " Due: " + sdf + " Institution: " + institution + " Interest: " + interest + " LoanID: " + loanID + " Paid: " + paid);
    }
}
