package financialportal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Class that will hold all of the data for the transaction table in our
 * database.
 *
 * @author Christian Kasel
 */
public class Transaction extends Information {

    private double amount;
    private String frame;
    private String institution;
    private String sdf;

    /**
     * Constructor to create a transaction with amount, frame, and institution
     *
     * @param amount the amount of money (in US currency) the was involved in
     * the transaction
     * @param frame the frame of which the transaction occurred
     * @param institution the institution in which the transaction happened
     */
    public Transaction(double amount, String frame, String institution) {
        super(amount);
        this.amount = amount;
        this.frame = frame;
        this.institution = institution;
        SimpleDateFormat sdf1 = new SimpleDateFormat("MMM dd yyyy");
        Date d1 = null;
        try {
            d1 = sdf1.parse(frame);
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
        }
        this.sdf = sdf1.format(d1);
    }

    /**
     * Comparator to see which transaction is "less" or "greater" than another
     * transaction by date
     */
    public static Comparator<Transaction> TransactionFrameComparator = new Comparator<Transaction>() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy");
        Date d1 = null;
        Date d2 = null;

        @Override
        public int compare(Transaction t1, Transaction t2) {
            try {
                d1 = sdf.parse(t1.getFrame());
                d2 = sdf.parse(t2.getFrame());
            } catch (ParseException ex) {
                System.err.println(ex.getMessage());
            }
            //descending order
            return d2.compareTo(d1);
        }
    };

    /**
     * Function to return the simple date format MMM DD YYYY
     *
     * @return the simple date format MMM DD YYYY
     */
    public String getSDF() {
        return sdf;
    }

    /**
     * Function to get the frame of the transaction
     *
     * @return the frame of the transaction
     */
    public String getFrame() {
        return frame;
    }

    /**
     * Function to return the institution in which the transaction happened
     *
     * @return the institution in which the transaction happened
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * Function to print out the transactions own information
     */
    @Override
    public void print() {
        System.out.println("\nTransactions:\n-------------------------");
        System.out.println("Amount: " + amount + " Date: " + sdf + " Institution: " + institution);
    }

}
