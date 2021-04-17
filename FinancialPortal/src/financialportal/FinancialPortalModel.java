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
     * (can be null if you want all institutions)
     * @param type the type of account the user is looking for (can be null if
     * you want all types)
     * @return list of all the accounts
     */
    public ArrayList<Account> queryAccounts(String institution, String type) {
        ArrayList<Account> accounts = new ArrayList<>(); // Create ArrayList of accounts
        try {
            String query;
            PreparedStatement statement;
            switch (type) { // Switching whether type is null or not
                case "": // If type is null, we only want to check the institution
                    if (institution.equals("")) { // If the institution is null, we want to select everything
                        query = "select * from Accounts";
                        statement = conn.prepareStatement(query);
                    } else { // If institution is not null, we want to select a specific institution
                        query = "select amount, institution, type from Accounts where Accounts.Institution == ?"; // Create SQL statement to select everything from account table
                        statement = conn.prepareStatement(query); // Sanatizing our SQL in case of SQL injection
                        statement.setString(1, institution); // Setting the ? to institution
                    }
                    break;
                default: // If type is not null, we check both institution and type
                    query = "select amount, institution, type from Accounts where Accounts.Institution == ? and Accounts.Type == ?"; // Create SQL statement to select everything from account table
                    statement = conn.prepareStatement(query); // Sanatizing our SQL in case of SQL injection
                    statement.setString(1, institution); // Setting the first ? to institution
                    statement.setString(2, type); // Setting the second ? to type
                    break;
            }
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
     * @param frame the frame in which these users requested budgets occurred
     * (can be null if you want all frames)
     * @param type the type of budget the user is looking for (can be null if
     * you want all types)
     * @return list of the budgets
     */
    public ArrayList<Budget> queryBudgets(String frame, String type) {
        ArrayList<Budget> budgets = new ArrayList<>(); // Create ArrayList of budgets
        try {
            String query;
            PreparedStatement statement;
            switch (type) {
                case "":
                    if (frame.equals("")) {
                        query = "select * from Budgets";
                        statement = conn.prepareStatement(query);
                    } else {
                        query = "select amount, frame, paid, type from Budgets where Budgets.Frame == ?"; // Create SQL statement to select everything from budget table
                        statement = conn.prepareStatement(query); // Sanatizing our SQL in case of SQL injection
                        statement.setString(1, frame);
                    }
                    break;
                default:
                    query = "select amount, frame, paid, type from Budgets where Budgets.Frame == ? and Budgets.Type == ?"; // Create SQL statement to select everything from budget table
                    statement = conn.prepareStatement(query); // Sanatizing our SQL in case of SQL injection
                    statement.setString(1, frame);
                    statement.setString(2, type);
                    break;
            }
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
     * @param institution the institution in which has the loan (can be null if
     * you want all institutions)
     * @param loanID the ID of the loan at the institution (can be null if you
     * want all loans)
     * @return list of the loans
     */
    public ArrayList<Loan> queryLoans(String institution, int loanID) {
        ArrayList<Loan> loans = new ArrayList<>(); // Create ArrayList of loans
        try {
            String query;
            PreparedStatement statement;
            switch (loanID) { // Switching whether or not the ID is null
                case -1: // If null, select all ID's
                    if (institution.equals("")) { // If institution is null, select all institutions
                        query = "select * from Loans";
                        statement = conn.prepareStatement(query);
                    } else {
                        query = "select * from Loans where Loans.LoanID == ?"; // Create SQL statement to select everything from loans table
                        statement = conn.prepareStatement(query); // Sanatizing our SQL in case of SQL injection
                        statement.setInt(1, loanID);
                    }
                    break;
                default: // If not null, select specific ID
                    query = "select * from Loans where Loans.LoanID == ? and Loans.Institution == ?";
                    statement = conn.prepareStatement(query);
                    statement.setInt(1, loanID);
                    statement.setString(2, institution);
                    break;
            }
            ResultSet rs = statement.executeQuery(); // Execture SQL statement into ResultSet
            while (rs.next()) { // Add each ResultSet to loans
                loans.add(new Loan(rs.getDouble("amount"), rs.getString("due"), rs.getString("institution"), rs.getDouble("interest"), rs.getInt("loanID"), rs.getDouble("paid")));
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
     * @param frame the type of spending the user would like to get (can be null
     * to select everything)
     * @return list of the spendings
     */
    public ArrayList<Spending> querySpendings(String frame) {
        ArrayList<Spending> spendings = new ArrayList<>(); // Create ArrayList of spendings
        try {
            String query;
            PreparedStatement statement;
            switch (frame) { // Check if frame is empty or not
                case "": // If frame is empty, then select everything from spendings
                    query = "select * from Spendings"; // Create SQL statement to select everything from spendings table
                    statement = conn.prepareStatement(query); // Sanatizing our SQL in case of SQL injection
                    break;
                default: // If frame isn't empty, then select specific frame
                    query = "select * from Spendings where Spendings.Frame == ?";
                    statement = conn.prepareStatement(query);
                    statement.setString(1, frame);
                    break;
            }
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
     * @param date the date in which the transactions the user is looking for
     * happened (can be null to select all transactions)
     * @return list of the transactions
     */
    public ArrayList<Transaction> queryTransactions(String date) {
        ArrayList<Transaction> transactions = new ArrayList<>(); // Create ArrayList of transactions
        try {
            String query;
            PreparedStatement statement;
            switch (date) { // Check to see if date is null or not
                case "": // If date is null, select all transactions
                    query = "select * from Transactions"; // Create SQL statement to select everything from transactions table
                    statement = conn.prepareStatement(query); // Sanatizing our SQL in case of SQL injection
                    break;
                default: // If date is not null, select specific date's transactions
                    query = "select * from Transactions where Transactions.Date == ?";
                    statement = conn.prepareStatement(query);
                    statement.setString(1, date);
                    break;
            }
            ResultSet rs = statement.executeQuery(); // Execture SQL statement into ResultSet
            while (rs.next()) { // Add each ResultSet to transactions
                transactions.add(new Transaction(rs.getDouble("amount"), rs.getString("date"), rs.getString("institution")));
            }
        } catch (SQLException e) { // If an SQL exception is thrown we will catch it here
            System.err.println(e.getMessage());
        }
        return transactions;
    }

    /**
     * Function to query and return an arraylist of transactions by unique date
     *
     * @return the arraylist of transactions by unique date
     */
    public ArrayList<Transaction> queryTransactionsByDate() {
        ArrayList<Transaction> newTransactions = new ArrayList<>();
        String query = "select distinct date from transactions";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                newTransactions.add(new Transaction(0, rs.getString("date"), ""));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return newTransactions;
    }

    /**
     * Function to query (select) the trend table
     *
     * @param frame the frame in which these users requested trends occurred
     * (can be null to select all trends)
     * @return list of the trends
     */
    public ArrayList<Trend> queryTrends(String frame) {
        ArrayList<Trend> trends = new ArrayList<>(); // Create ArrayList of trends
        try {
            String query;
            PreparedStatement statement;
            switch (frame) { // Check to see if frame is null or not
                case "": // If frame is null, select all trends
                    query = "select * from trends";
                    statement = conn.prepareStatement(query);
                    break;
                default: // If frame is not null, select specific trends
                    query = "select * FROM Trends where Trends.TrendYear == ?"; // Create SQL statement to select everything from trend table
                    statement = conn.prepareStatement(query); // Sanatizing our SQL in case of SQL injection
                    statement.setString(1, frame);
                    break;
            }
            ResultSet rs = statement.executeQuery(); // Execture SQL statement into ResultSet
            while (rs.next()) { // Add each ResultSet to trends
                String mon = rs.getString("month");
                int day = rs.getInt("day");
                int year = rs.getInt("trendyear");
                trends.add(new Trend(rs.getDouble("amount"), mon + " " + day + " " + year, rs.getString("type")));
            }
        } catch (SQLException e) { // If an SQL exception is thrown we will catch it here
            System.err.println(e.getMessage());
        }
        // Return trends
        return trends;
    }

    /**
     * Function to query the trends by year instead of a specific day of the
     * year
     *
     * @return an arraylist of trends queried by year
     */
    public ArrayList<Trend> queryTrendsByDate() {
        ArrayList<Trend> newTrends = new ArrayList<>();
        String query = "select distinct TrendYear from trends";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                newTrends.add(new Trend(0, "May 01 2000", rs.getString("TrendYear")));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return newTrends;
    }
}
