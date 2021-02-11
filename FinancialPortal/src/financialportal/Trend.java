package financialportal;

/**
 * Class that will hold all of the data for the trends table in our database.
 *
 * @author Christian Kasel
 */
public class Trend {

    private double amount;
    private String frame;
    private String group;

    /**
     * Constructor to create a trend with amount, frame, and group
     *
     * @param amount the total amount of the particular trend
     * @param frame the frame of the particular trend
     * @param group the group or type of the particular trend
     */
    public Trend(double amount, String frame, String group) {
        this.amount = amount;
        this.frame = frame;
        this.group = group;
    }

    /**
     * Function to return the total amount of the trend
     *
     * @return the total amount of the trend
     */
    public double getAmount() {
        return amount;
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
     * Function to return the group or type of the particular trend
     *
     * @return the group or type of the particular trend
     */
    public String getGroup() {
        return group;
    }
}
