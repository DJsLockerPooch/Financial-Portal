package financialportal;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * Class that will determine how the database (model) will interact with the
 * user (view) (use java -jar "FinancialPortal.jar")
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
        ArrayList<JComboBox> boxes = view.getBoxes(); // Getting the view's list of boxes
        for (int i = 0; i < buttons.size(); i++) { // For each button
            switch (i) { // Switch based on what button we're on
                case 0: // If accounts button
                    buttons.get(i).addActionListener(e -> saveAccounts(model, view)); // Add an event listener to the accounts button
                    boxes.get(i).addActionListener(e -> accountsBox(model, view)); // Add an event listener to the accounts combo box
                    break;
                case 1: // If budgets button
                    buttons.get(i).addActionListener(e -> saveBudgets(model, view)); // Add an event listener to the budgets button
                    boxes.get(i).addActionListener(e -> budgetsBox(model, view)); // Add an event listener to the budgets combo box
                    break;
                case 2: // If loans button
                    buttons.get(i).addActionListener(e -> saveLoans(model, view)); // Add an event listener to the loans button
                    boxes.get(i).addActionListener(e -> loansBox(model, view)); // Add an event listener to the loans combo box
                    break;
                case 3: // If spendings button
                    buttons.get(i).addActionListener(e -> saveSpendings(model, view)); // Add an event listener to the spendings button
                    boxes.get(i).addActionListener(e -> spendingsBox(model, view)); // Add an event listener to the spendings combo box
                    break;
                case 4: // If transactions button
                    buttons.get(i).addActionListener(e -> saveTransactions(model, view)); // Add an event listener to the transacions button
                    boxes.get(i).addActionListener(e -> transactionsBox(model, view)); // Add an event listener to the transacions combo box
                    break;
                case 5: // If trends button
                    buttons.get(i).addActionListener(e -> saveTrends(model, view)); // Add an event listener to the trends button
                    boxes.get(i).addActionListener(e -> trendsBox(model, view)); // Add an event listener to the trends combo box
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Function to get the item selected from the accounts page combo box, and
     * update the accounts graphic based on the item you selected
     *
     * @param model a copy of the model object to get data from the database
     * @param view a copy of the view object to get the information from the UI
     */
    public static void accountsBox(FinancialPortalModel model, FinancialPortalView view) {
        String institution = view.getItemSelected("account");
        String[] split = institution.split(", ");
        ArrayList<Account> accounts = model.queryAccounts(split[0], split[1]);
        view.inputDataIntoAccountsTable(accounts);
    }

    /**
     * Function to get the item selected from the budgets page combo box, and
     * update the budgets graphic based on the item you selected
     *
     * @param model a copy of the model object to get data from the database
     * @param view a copy of the view object to get the information from the UI
     */
    public static void budgetsBox(FinancialPortalModel model, FinancialPortalView view) {
        String frame = view.getItemSelected("budget");
        ArrayList<Budget> budgets = model.queryBudgets(frame, "");
        view.addRingGraph(budgets);
    }

    /**
     * Function to get the item selected from the loans page combo box, and
     * update the loans graphic based on the item you selected
     *
     * @param model a copy of the model object to get data from the database
     * @param view a copy of the view object to get the information from the UI
     */
    public static void loansBox(FinancialPortalModel model, FinancialPortalView view) {
        view.resetLoansPage();
        String institution = view.getItemSelected("loan");
        String[] split = institution.split(", ");
        if (split.length > 1) {
            ArrayList<Loan> loans = model.queryLoans(split[0], Integer.parseInt(split[1]));
            view.insertLoan(loans);
        }
    }

    /**
     * Function to get the item selected from the spendings page combo box, and
     * update the spendings graphic based on the item you selected
     *
     * @param model a copy of the model object to get data from the database
     * @param view a copy of the view object to get the information from the UI
     */
    public static void spendingsBox(FinancialPortalModel model, FinancialPortalView view) {
        String frame = view.getItemSelected("spending");
        ArrayList<Spending> spendings = model.querySpendings(frame);
        view.addBarGraph(spendings);
    }

    /**
     * Function to get the item selected from the transactions page combo box,
     * and update the transactions graphic based on the item you selected
     *
     * @param model a copy of the model object to get data from the database
     * @param view a copy of the view object to get the information from the UI
     */
    public static void transactionsBox(FinancialPortalModel model, FinancialPortalView view) {
        String date = view.getItemSelected("transaction");
        ArrayList<Transaction> transactions = model.queryTransactions(date);
        view.inputDataIntoTransactionsTable(transactions);
    }

    /**
     * Function to get the item selected from the trends page combo box, and
     * update the trends graphic based on the item you selected
     *
     * @param model a copy of the model object to get data from the database
     * @param view a copy of the view object to get the information from the UI
     */
    public static void trendsBox(FinancialPortalModel model, FinancialPortalView view) {
        String frame = view.getItemSelected("trend");
        ArrayList<Trend> trends = model.queryTrends(frame);
        view.addLineGraph(trends);
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
        ArrayList<Account> accounts = model.queryAccountsByDate(); // Getting all unique accounts
        Collections.sort(accounts, Account.AccountFrameComparator); // Sorting all accounts by institution name (A-Z)
        view.insertIntoAccountsComboBox(accounts); // Inputting all data into accounts combo box
        view.disableButton("account"); // Disabling the button so the user doesn't load the data again
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
        ArrayList<Budget> budgets = model.queryBudgetsByDate(); // Getting all budgets
        Collections.sort(budgets, Budget.BudgetFrameComparator); // Sorting budgets by date
        view.insertIntoBudgetsComboBox(budgets); // Inputting all the data into the budgets combo box
        view.disableButton("budget"); // Disabling the button so the user doesn't load the data again
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
        ArrayList<Loan> loans = model.queryLoans("", -1);
        Collections.sort(loans, Loan.LoanFrameComparator);
        view.insertLoan(loans);
        view.insertIntoLoansComboBox(loans);
        view.disableButton("loan");
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
        ArrayList<Spending> spendings = model.querySpendingsByDate();
        Collections.sort(spendings, Spending.SpendingFrameComparator);
        view.insertIntoSpendingsComboBox(spendings);
        view.disableButton("spending");
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
        ArrayList<Transaction> transactions = model.queryTransactionsByDate();
        Collections.sort(transactions, Transaction.TransactionFrameComparator);
        view.insertIntoTransactionsComboBox(transactions);
        view.disableButton("transaction");
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
        ArrayList<Trend> trends = model.queryTrendsByDate();
        Collections.sort(trends, Trend.TrendFrameComparator2);
        view.insertIntoTrendsComboBox(trends);
        view.disableButton("trend");
    }
}
