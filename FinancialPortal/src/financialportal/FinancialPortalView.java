package financialportal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that will deal with what the user will see exclusively
 *
 * @author Christian Kasel
 */
public class FinancialPortalView {

    private Scanner kb;

    /**
     * Constructor to initialize our scanner variable
     */
    public FinancialPortalView() {
        kb = new Scanner(System.in);
    }
    
    public void displayAccounts(ArrayList<Account> list){
        list.forEach((_item) -> {
            _item.print();
        });
    }
    
    public void displayBudgets(ArrayList<Budget> list){
        list.forEach((_item) -> {
            _item.print();
        });
    }
    
    public void displayLoans(ArrayList<Loan> list){
        list.forEach((_item) -> {
            _item.print();
        });
    }
    
    public void displaySpendings(ArrayList<Spending> list){
        list.forEach((_item) -> {
            _item.print();
        });
    }
    
    public void displayTransactions(ArrayList<Transaction> list){
        list.forEach((_item) -> {
            _item.print();
        });
    }
    
    public void displayTrends(ArrayList<Trend> list){
        list.forEach((_item) -> {
            _item.print();
        });
    }

    /**
     * Function to prompt and get the institution the user would like to see
     *
     * @param desObj the object they would like to see (either account or loan)
     * @return the institution the user is looking for
     */
    public String getInstitution(String desObj) {
        System.out.println("Please enter the institution you wish to see that has your " + desObj + ":");
        return kb.nextLine();
    }

    /**
     * Function to get the frame of time the user would like to see
     *
     * @param desObj the object they would like to see (budget, spending,
     * transaction, or trend)
     * @return the frame of reference the user would like to see
     */
    public String getFrame(String desObj) {
        System.out.println("Please enter the frame of reference you seek for your " + desObj + " (ex. May 2020):");
        return kb.nextLine();
    }

    /**
     * Function to get the loanID the user would like to see
     *
     * @return the loanID the user would like to see
     */
    public int getLoanID() {
        System.out.println("Please enter your loan ID:");
        String integer = kb.nextLine();
        return Integer.parseInt(integer);
    }

    /**
     * Function to get the type of object the user would like to see
     *
     * @param desObj the object the user would like to see (account, budget, trend)
     * @return the type of object the user would like to see
     */
    public String getType(String desObj) {
        System.out.println("Please enter the type of " + desObj + " you would like:");
        return kb.nextLine();
    }
}
