package financialportal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Model class of the financial portal package. This model will be interacting
 * with the SQL database to pull out the information the user is seeking.
 *
 * @author Christian Kasel
 */
public class FinancialPortalModel {

    private Connection conn;

    /**
     * Constructor to initialize the connection to the database. (Because it's
     * only one person, the username and password isn't passed in)
     */
    public FinancialPortalModel() {
        try {
            String url = "jdbc:sqlite:/Users/christiankasel/Desktop/Financial-Portal/portalDB.db";
            String username = "";
            String password = "";

            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Function to query (select) the accounts table
     *
     * @param institution the institution in which the users account is located
     * @param type the type of account the user is looking for
     * @return list of all the accounts
     */
    public ArrayList<Account> queryAccounts(String institution, String type) {
        ArrayList<Account> accounts = new ArrayList<>(); // Create ArrayList of accounts
        try {
            String query = "select amount, institution, type from Accounts where Accounts.Institution == ? and Accounts.Type == ?"; // Create SQL statement to select everything from account table
            PreparedStatement statement = conn.prepareStatement(query); // Sanatizing our SQL in case of SQL injection
            statement.setString(1, institution);
            statement.setString(2, type);
            ResultSet rs = statement.executeQuery(); // Execture SQL statement into ResultSet
            while (rs.next()) { // Add each ResultSet to accounts
                accounts.add(new Account(rs.getDouble("amount"), rs.getString("institution"), rs.getString("type")));
            }
        } catch (SQLException e) { // If an SQL exception is thrown we will catch it here
            System.err.println(e.getMessage());
        }
        // Return accounts
        return accounts;
    }

    /**
     * Function to query (select) the budget table
     *
     * @param type the type of budget the user is looking for
     * @return list of the budgets
     */
    public ArrayList<Budget> queryBudgets(String type) {
        ArrayList<Budget> budgets = new ArrayList<>(); // Create ArrayList of budgets
        try {
            String query = "select amount, frame, paid, type from Budgets where Budgets.Type == ?"; // Create SQL statement to select everything from budget table
            PreparedStatement statement = conn.prepareStatement(query); // Sanatizing our SQL in case of SQL injection
            statement.setString(1, type);
            ResultSet rs = statement.executeQuery(); // Execture SQL statement into ResultSet
            while (rs.next()) { // Add each ResultSet to budgets
                budgets.add(new Budget(rs.getDouble("amount"), rs.getString("frame"), rs.getDouble("paid"), rs.getString("type")));
            }
        } catch (SQLException e) { // If an SQL exception is thrown we will catch it here
            System.err.println(e.getMessage());
        }
        // Return budgets
        return budgets;
    }

    /**
     * Function to query (select) the loans table
     *
     * @param institution the institution in which has the loan
     * @param loanID the ID of the loan at the institution
     * @return list of the loans
     */
    public ArrayList<Loan> queryLoans(String institution, int loanID) {
        ArrayList<Loan> loans = new ArrayList<>(); // Create ArrayList of loans
        try {
            String query = "select amount, due, institution, interest, loanID, paid from Loans where Loans.Institution == ? and Loans.LoanID == ?"; // Create SQL statement to select everything from loans table
            PreparedStatement statement = conn.prepareStatement(query); // Sanatizing our SQL in case of SQL injection
            statement.setString(1, institution);
            statement.setInt(2, loanID);
            ResultSet rs = statement.executeQuery(); // Execture SQL statement into ResultSet
            while (rs.next()) { // Add each ResultSet to loans
                loans.add(new Loan(rs.getDouble("amount"), rs.getString("due") , rs.getDouble("interest"), rs.getDouble("paid"), rs.getDouble("remaining")));
            }
        } catch (SQLException e) { // If an SQL exception is thrown we will catch it here
            System.err.println(e.getMessage());
        }
        // Return loans
        return loans;
    }

    /**
     * Function to query (select) the spendings table
     *
     * @param type the type of spending the user would like to get
     * @return list of the spendings
     */
    public ArrayList<Spending> querySpendings(String type) {
        ArrayList<Spending> spendings = new ArrayList<>(); // Create ArrayList of spendings
        try {
            String query = "select amount, frame, type from Spendings where Spendings.Type == ?"; // Create SQL statement to select everything from spendings table
            PreparedStatement statement = conn.prepareStatement(query); // Sanatizing our SQL in case of SQL injection
            statement.setString(1, type);
            ResultSet rs = statement.executeQuery(); // Execture SQL statement into ResultSet
            while (rs.next()) { // Add each ResultSet to spendings
                spendings.add(new Spending(rs.getDouble("amount"), rs.getString("frame"), rs.getString("type")));
            }
        } catch (SQLException e) { // If an SQL exception is thrown we will catch it here
            System.err.println(e.getMessage());
        }
        // Return spendings
        return spendings;
    }

    /**
     * Function to query (select) the transaction table
     *
     * @param date the date in which the transactions the user is looking for happened
     * @return list of the transactions
     */
    public ArrayList<Transaction> queryTransactions(String date) {
        ArrayList<Transaction> transactions = new ArrayList<>(); // Create ArrayList of transactions
        try {
            String query = "select amount, date, institution from Transactions where Transactions.Date == ?"; // Create SQL statement to select everything from transactions table
            PreparedStatement statement = conn.prepareStatement(query); // Sanatizing our SQL in case of SQL injection
            statement.setString(1, date);
            ResultSet rs = statement.executeQuery(); // Execture SQL statement into ResultSet
            while (rs.next()) { // Add each ResultSet to transactions
                transactions.add(new Transaction(rs.getDouble("amount"), rs.getString("date"), rs.getString("institution")));
            }
        } catch (SQLException e) { // If an SQL exception is thrown we will catch it here
            System.err.println(e.getMessage());
        }
        // Return transactions
        return transactions;
    }

    /**
     * Function to query (select) the trend table
     *
     * @param frame the frame in which these users requested trends occurred
     * @param type the type of trend the user requested
     * @return list of the trends
     */
    public ArrayList<Trend> queryTrends(String frame, String type) {
        ArrayList<Trend> trends = new ArrayList<>(); // Create ArrayList of trends
        try {
            String query = "select amount, frame, type from Trends where Trends.Frame == ? and Trends.Type == ?"; // Create SQL statement to select everything from trend table
            PreparedStatement statement = conn.prepareStatement(query); // Sanatizing our SQL in case of SQL injection
            statement.setString(1, frame);
            statement.setString(2, type);
            ResultSet rs = statement.executeQuery(); // Execture SQL statement into ResultSet
            while (rs.next()) { // Add each ResultSet to trends
                trends.add(new Trend(rs.getDouble("amount"), rs.getString("frame"), rs.getString("type")));
            }
        } catch (SQLException e) { // If an SQL exception is thrown we will catch it here
            System.err.println(e.getMessage());
        }
        // Return trends
        return trends;
    }
}
