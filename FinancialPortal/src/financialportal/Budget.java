package financialportal;

/**
 * Class that will hold all of the data for the budget table in our database.
 *
 * @author Christian Kasel
 */
public class Budget {

    private String frame;
    private double paid;
    private double total;
    private String type;

    /**
     * Constructor to create a budget with the frame, paid, total, and type
     *
     * @param frame the time in which this budget is applied
     * @param paid the amount the user has already paid
     * @param total the total starting amount for the budget
     * @param type the type of budget
     */
    public Budget(String frame, double paid, double total, String type) {
        this.frame = frame;
        this.paid = paid;
        this.total = total;
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
     * Function to return the total starting amount for the budget
     *
     * @return the total starting amount for the budget
     */
    public double getTotal() {
        return total;
    }

    /**
     * Function to return the type of the budget
     *
     * @return the type of the budget
     */
    public String getType() {
        return type;
    }

}
