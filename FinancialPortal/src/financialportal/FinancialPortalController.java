package financialportal;

import java.util.ArrayList;
import javax.swing.JButton;

/**
 * Class that will determine how the database (model) will interact with the
 * user (view)
 *
 * @author Christian Kasel
 */
public class FinancialPortalController {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FinancialPortalModel model = new FinancialPortalModel(); // Creating an instance of our model class
        FinancialPortalView view = new FinancialPortalView(); // Creating an instance of our view class
        view.show(); // Displaying our view instance
        ArrayList<JButton> buttons = view.getButtons(); // Getting the view's list of buttons
        for (int i = 0; i < buttons.size(); i++) { // For each button
            switch (i) { // Switch based on what button we're on
                case 0: // If accounts button
                    buttons.get(i).addActionListener(e -> saveAccounts(model, view)); // Add an event listener to the accounts button
                    break;
                case 1: // If budgets button
                    buttons.get(i).addActionListener(e -> saveBudgets(model, view)); // Add an event listener to the budgets button
                    break;
                case 2: // If loans button
                    buttons.get(i).addActionListener(e -> saveLoans(model, view)); // Add an event listener to the loans button
                    break;
                case 3: // If spendings button
                    buttons.get(i).addActionListener(e -> saveSpendings(model, view)); // Add an event listener to the spendings button
                    break;
                case 4: // If transactions button
                    buttons.get(i).addActionListener(e -> saveTransactions(model, view)); // Add an event listener to the transacions button
                    break;
                case 5: // If trends button
                    buttons.get(i).addActionListener(e -> saveTrends(model, view)); // Add an event listener to the trends button
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Function to get the information the user wants, to query this
     * information, and to put the queried information in the accounts table
     *
     * @param model the instance of the model that has the connection to the
     * database
     * @param view the instance of the view that has the connection to the
     * user's input
     */
    public static void saveAccounts(FinancialPortalModel model, FinancialPortalView view) {
        String inst = view.getInfo("institution", "account");
        String type = view.getInfo("type", "account");
        view.inputDataIntoAccountsTable(model.queryAccounts(inst, type));
    }

    /**
     * Function to get the information the user wants, to query this
     * information, and to put the queried information in the budgets table
     *
     * @param model the instance of the model that has the connection to the
     * database
     * @param view the instance of the view that has the connection to the
     * user's input
     */
    public static void saveBudgets(FinancialPortalModel model, FinancialPortalView view) {
        view.removeGraph(view.getPanel("budget"));
        String type = view.getInfo("type", "budget");
        view.addBarGraph(model.queryBudgets(type));
    }

    /**
     * Function to get the information the user wants, to query this
     * information, and to put the queried information in the loans table
     *
     * @param model the instance of the model that has the connection to the
     * database
     * @param view the instance of the view that has the connection to the
     * user's input
     */
    public static void saveLoans(FinancialPortalModel model, FinancialPortalView view) {
        String inst = view.getInfo("institution", "loans");
        int loanID = (Integer.parseInt(view.getInfo("loan ID", "loans")));
        view.inputDataIntoLoansTable(model.queryLoans(inst, loanID));
    }

    /**
     * Function to get the information the user wants, to query this
     * information, and to put the queried information in the spendings table
     *
     * @param model the instance of the model that has the connection to the
     * database
     * @param view the instance of the view that has the connection to the
     * user's input
     */
    public static void saveSpendings(FinancialPortalModel model, FinancialPortalView view) {
        String type = view.getInfo("type", "spending");
        view.inputDataIntoSpendingsTable(model.querySpendings(type));
    }

    /**
     * Function to get the information the user wants, to query this
     * information, and to put the queried information in the transactions table
     *
     * @param model the instance of the model that has the connection to the
     * database
     * @param view the instance of the view that has the connection to the
     * user's input
     */
    public static void saveTransactions(FinancialPortalModel model, FinancialPortalView view) {
        String frame = view.getInfo("frame of reference", "transaction");
        view.inputDataIntoTransactionsTable(model.queryTransactions(frame));
    }

    /**
     * Function to get the information the user wants, to query this
     * information, and to put the queried information in the trends table
     *
     * @param model the instance of the model that has the connection to the
     * database
     * @param view the instance of the view that has the connection to the
     * user's input
     */
    public static void saveTrends(FinancialPortalModel model, FinancialPortalView view) {
        String frame = view.getInfo("frame of reference", "trend");
        String type = view.getInfo("type", "trend");
        view.addLineGraph(model.queryTrends(frame, type));
    }
}
