package financialportal;

/**
 * Class that will hold all of the data for the spending table in our database.
 *
 * @author Christian Kasel
 */
public class Spending extends Information{

    private double amount;
    private String frame;
    private String type;

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

    @Override
    public void print() {
        System.out.println("\nSpendings:\n-------------------------");
        System.out.println("Amount: " + amount + " Frame: " + frame + " Type: " + type);
    }
}
