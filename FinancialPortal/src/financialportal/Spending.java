package financialportal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that will hold all of the data for the spending table in our database.
 *
 * @author Christian Kasel
 */
public class Spending extends Information {

    private double amount;
    private String frame;
    private String type;
    private String sdf;

    /**
     * Constructor to create a spending with the frame, amount and type
     *
     * @param amount the amount amount of spending during the frame
     * @param frame the time in which the data has occurred
     * @param type the type of spending
     */
    public Spending(double amount, String frame, String type) {
        super(amount);
        this.amount = amount;
        this.frame = frame;
        this.type = type;
        SimpleDateFormat sdf1 = new SimpleDateFormat("MMM dd yyyy");
        Date d1 = null;
        try {
            d1 = sdf1.parse(frame);
        } catch (ParseException ex) {
            Logger.getLogger(Spending.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.sdf = sdf1.format(d1);
    }

    public static Comparator<Spending> SpendingFrameComparator = new Comparator<Spending>() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy");
        Date d1 = null;
        Date d2 = null;

        @Override
        public int compare(Spending s1, Spending s2) {
            try {
                d1 = sdf.parse(s1.getSDF());
                d2 = sdf.parse(s2.getSDF());
            } catch (ParseException ex) {
                System.err.println(ex.getMessage());
            }
            //ascending order
            return d1.compareTo(d2);
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
     * Function to return the frame of the spending
     *
     * @return the frame of the spending
     */
    public String getFrame() {
        return frame;
    }

    /**
     * Function to return the type of the spending
     *
     * @return the type of the spending
     */
    public String getType() {
        return type;
    }

    /**
     * Function to print the spendings with its own information
     */
    @Override
    public void print() {
        System.out.println("\nSpendings:\n-------------------------");
        System.out.println("Amount: " + amount + " Frame: " + sdf + " Type: " + type + " Date: " + sdf);
    }
}
