package financialportal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that will hold all of the data for the trends table in our database.
 *
 * @author Christian Kasel
 */
public class Trend extends Information {

    private double amount;
    private String frame;
    private String type;
    private String sdf;

    /**
     * Constructor to create a trend with amount, frame, and type
     *
     * @param amount the total amount of the particular trend
     * @param frame the frame of the particular trend
     * @param type the type or type of the particular trend
     */
    public Trend(double amount, String frame, String type) {
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
        sdf = sdf1.format(d1);
    }

    /**
     * Function to return the simple date format MMM DD YYYY
     * @return the simple date format MMM DD YYYY
     */
    public String getSDF() {
        return sdf;
    }

    /**
     * Function to return the frame of the particular trend
     *
     * @return the frame of the particular trend
     */
    public String getFrame() {
        return frame;
    }

    /**
     * Function to return the type or type of the particular trend
     *
     * @return the type or type of the particular trend
     */
    public String getType() {
        return type;
    }

    /**
     * Function to print the trends based on its information
     */
    @Override
    public void print() {
        System.out.println("\nTrends:\n-------------------------");
        System.out.println("Amount: " + amount + " Frame: " + sdf + " Type: " + type);
    }
}
