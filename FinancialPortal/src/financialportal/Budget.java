package financialportal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that will hold all of the data for the budget table in our database.
 *
 * @author Christian Kasel
 */
public class Budget extends Information {

    private double amount;
    private String frame;
    private double paid;
    private String type;
    private String sdf;

    /**
     * Constructor to create a budget with the frame, paid, amount, and type
     *
     * @param amount the amount starting amount for the budget
     * @param frame the time in which this budget is applied
     * @param paid the amount the user has already paid
     * @param type the type of budget
     */
    public Budget(double amount, String frame, double paid, String type) {
        super(amount);
        this.amount = amount;
        this.frame = frame;
        this.paid = paid;
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

    public static Comparator<Budget> BudgetFrameComparator = new Comparator<Budget>() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy");
        Date d1 = null;
        Date d2 = null;

        @Override
        public int compare(Budget b1, Budget b2) {
            try {
                d1 = sdf.parse(b1.getSDF());
                d2 = sdf.parse(b2.getSDF());
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
     * Function to return the frame of the budget
     *
     * @return the frame of the budget (in YYYY/MM/DD)
     */
    public String getFrame() {
        return frame;
    }

    /**
     * Function to return the amount the user has paid of the budget
     *
     * @return the amount the user has paid (in US currency)
     */
    public double getPaid() {
        return paid;
    }

    /**
     * Function to return the type of the budget
     *
     * @return the type of the budget
     */
    public String getType() {
        return type;
    }

    /**
     * Function to print out the budgets own information
     */
    @Override
    public void print() {
        System.out.println("\nBudgets:\n-------------------------");
        System.out.println("Amount: " + amount + " Frame: " + sdf + " Paid: " + paid + " Type: " + type);
    }

}
