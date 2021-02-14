package financialportal;

import java.util.ArrayList;

/**
 * Class that will determine how the model (database) will interact with the
 * user (view)
 *
 * @author Christian Kasel
 */
public class FinancialPortalController {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FinancialPortalModel model = new FinancialPortalModel();
        FinancialPortalView view = new FinancialPortalView();

        getAllData(view, model);
    }

    /**
     * Function to return all of the information in each of the tables
     *
     * @param view the view that will display all the information
     * @param model the model that gets all the information
     */
    public static void getAllData(FinancialPortalView view, FinancialPortalModel model) {
        view.displayAccounts(model.queryAccounts(view.getInstitution("Bank Account"), view.getType("Bank Account")));
        view.displayBudgets(model.queryBudgets(view.getType("Budget")));
        view.displayLoans(model.queryLoans(view.getInstitution("Loan"), view.getLoanID()));
        view.displaySpendings(model.querySpendings(view.getType("Spending")));
        view.displayTransactions(model.queryTransactions(view.getFrame("Transactions")));
        view.displayTrends(model.queryTrends(view.getFrame("Trends"), view.getType("Trends")));
    }
}
