package financialportal;

import java.util.ArrayList;

/**
 *
 * @author Christian Kasel
 */
public class FinancialPortalController {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FinancialPortalModel model = new FinancialPortalModel();
        ArrayList<Account> accounts = model.queryAccounts();
        accounts.forEach((a) -> {
            System.out.println("Amount: " + a.getAmount() + " Institution: " + a.getInstitution() + " Type: " + a.getType());
        });
        ArrayList<Budget> budgets = model.queryBudgets();
        budgets.forEach((a) -> {
            System.out.println("Frame: " + a.getFrame()+ " Paid: " + a.getPaid()+ " Total: " + a.getTotal() + " Type: " + a.getType());
        });
        ArrayList<Loan> loans = model.queryLoans();
        loans.forEach((a) -> {
            System.out.println("Interest: " + a.getInterest()+ "% Paid: " + a.getPaid()+ " Remaining: " + a.getRemaining()+ " Total: " + a.getTotal());
        });
        ArrayList<Spending> spendings = model.querySpendings();
        spendings.forEach((a) -> {
            System.out.println("Frame: " + a.getFrame()+ " Total: " + a.getTotal()+ " Type: " + a.getType());
        });
        ArrayList<Transaction> transactions = model.queryTransactions();
        transactions.forEach((a) -> {
            System.out.println("Amount: " + a.getAmount()+ " Date: " + a.getDate()+ " Institution: " + a.getInstitution());
        });
        ArrayList<Trend> trends = model.queryTrends();
        trends.forEach((a) -> {
            System.out.println("Amount: " + a.getAmount()+ " Frame: " + a.getFrame() + " Group: " + a.getGroup());
        });
    }

}
