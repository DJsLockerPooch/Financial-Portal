package financialportal;

/**
 * Super class that will allow subclasses to inherit amount
 * @author Christian Kasel
 */
public class Information {
    private double amount;

    public Information(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
    
    public void print(){
        System.out.println("Amount: " + amount);
    }
}
