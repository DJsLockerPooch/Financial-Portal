package financialportal;

/**
 * Class that will hold all of the data for the trends table in our database.
 *
 * @author Christian Kasel
 */
public class Trend extends Information {

    private double amount;
    private String frame;
    private String type;

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

    @Override
    public void print() {
        System.out.println("\nTrends:\n-------------------------");
        System.out.println("Amount: " + amount + " Frame: " + frame + " Type: " + type);
    }
}
