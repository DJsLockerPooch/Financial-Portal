package financialportal;

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

    @Override
    public void print() {
        System.out.println("\nBudgets:\n-------------------------");
        System.out.println("Amount: " + amount + " Frame: " + frame + " Paid: " + paid + " Type: " + type);
    }

}
