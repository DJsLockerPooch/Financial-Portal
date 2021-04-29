package financialportal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
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
     * Comparator to compare which trend is "less" or "greater" than another
     * trend by comparing dates
     */
    public static Comparator<Trend> TrendFrameComparator1 = new Comparator<Trend>() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy");
        Date d1 = null;
        Date d2 = null;

        @Override
        public int compare(Trend t1, Trend t2) {
            try {
                d1 = sdf.parse(t1.getSDF());
                d2 = sdf.parse(t2.getSDF());
            } catch (ParseException ex) {
                System.err.println(ex.getMessage());
            }
            //descending order
            return d2.compareTo(d1);
        }
    };

    /**
     * Comparator to compare which trend is "less" or "greater" than another
     * trend by year
     */
    public static Comparator<Trend> TrendFrameComparator2 = new Comparator<Trend>() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy");
        Date d1 = null;
        Date d2 = null;

        @Override
        public int compare(Trend t1, Trend t2) {
            String sdf1;
            String sdf2;
            try {
                d1 = sdf.parse("January " + "01 " + t1.getType());
                d2 = sdf.parse("January " + "01 " + t2.getType());
            } catch (ParseException ex) {
                System.err.println(ex.getMessage());
            }
            sdf1 = sdf.format(d1);
            sdf2 = sdf.format(d2);
            //ascending order
            return sdf2.compareTo(sdf1);
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
