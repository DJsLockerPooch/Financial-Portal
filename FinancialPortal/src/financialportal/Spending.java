package financialportal;

import java.sql.Date;

/**
 * Class that will hold all of the data for the spending table in our database.
 *
 * @author Christian Kasel
 */
public class Spending {

    private String frame;
    private double total;
    private String type;

    /**
     * Constructor to create a spending with the frame, total and type
     *
     * @param frame the time in which the data has occurred
     * @param total the total amount of spending during the frame
     * @param type the type of spending
     */
    public Spending(String frame, double total, String type) {
        this.frame = frame;
        this.total = total;
        this.type = type;
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
     * Function to return the total amount of spending
     *
     * @return the total amount of spending
     */
    public double getTotal() {
        return total;
    }

    /**
     * Function to return the type of the spending
     *
     * @return the type of the spending
     */
    public String getType() {
        return type;
    }
}
