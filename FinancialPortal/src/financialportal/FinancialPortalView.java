package financialportal;

import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryToPieDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.TableOrder;

/**
 * View of the Financial Portal project. This class simply displays the page(s)
 * for the user to interact with
 *
 * @author Christian Kasel
 */
public class FinancialPortalView extends javax.swing.JFrame {

    private static ArrayList<JButton> buttons;

    /**
     * Creates new form PortalFrame
     */
    public FinancialPortalView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize all of
     * the variables.
     *
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        accountsPageButton = new javax.swing.JMenuItem();
        accountsPagePanel = new javax.swing.JPanel();
        accountsPagePanelTitle = new javax.swing.JLabel();
        accountsPageTable = new javax.swing.JTable();
        accountsPageTitleButton = new javax.swing.JButton();
        accountsPageTitlePanel = new javax.swing.JPanel();

        budgetsPageButton = new javax.swing.JMenuItem();
        budgetsPagePanel = new javax.swing.JPanel();
        budgetsPageGraphPanel = new javax.swing.JPanel();
        budgetsPageTitle = new javax.swing.JLabel();
        budgetsPageTitleButton = new javax.swing.JButton();
        budgetsPageTitlePanel = new javax.swing.JPanel();

        fileButton = new javax.swing.JMenu();

        homePageButton = new javax.swing.JMenuItem();
        homePagePanel = new javax.swing.JPanel();
        homePageTextArea = new javax.swing.JTextArea();
        homePageTitle = new javax.swing.JLabel();

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane7 = new javax.swing.JScrollPane();

        loansPageButton = new javax.swing.JMenuItem();
        loansPageGraphPanel = new javax.swing.JPanel();
        loansPagePanel = new javax.swing.JPanel();
        loansPageTitle = new javax.swing.JLabel();
        loansPageTitleButton = new javax.swing.JButton();
        loansPageTitlePanel = new javax.swing.JPanel();

        menuBar = new javax.swing.JMenuBar();
        pagesButton = new javax.swing.JMenu();
        quitButton = new javax.swing.JMenuItem();

        spendingsPageButton = new javax.swing.JMenuItem();
        spendingsPageGraphPanel = new javax.swing.JPanel();
        spendingsPagePanel = new javax.swing.JPanel();
        spendingsPageTitle = new javax.swing.JLabel();
        spendingsPageTitleButton = new javax.swing.JButton();
        spendingsPageTitlePanel = new javax.swing.JPanel();

        tabbedPane = new javax.swing.JTabbedPane();
        transactionsPageButton = new javax.swing.JMenuItem();
        transactionsPagePanel = new javax.swing.JPanel();
        transactionsPageTitle = new javax.swing.JLabel();
        transactionsPageTitleButton = new javax.swing.JButton();
        transactionsPageTitlePanel = new javax.swing.JPanel();
        transactionsTable = new javax.swing.JTable();

        trendsPageButton = new javax.swing.JMenuItem();
        trendsPageGraphPanel = new javax.swing.JPanel();
        trendsPagePanel = new javax.swing.JPanel();
        trendsPageTitle = new javax.swing.JLabel();
        trendsPageTitleButton = new javax.swing.JButton();
        trendsPageTitlePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 600));
        getContentPane().setLayout(new java.awt.CardLayout());

        /**
         * Making Home Page
         */
        tabbedPane.setPreferredSize(new java.awt.Dimension(1200, 645));

        homePagePanel.setLayout(new java.awt.BorderLayout());

        homePageTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homePageTitle.setText("Home Page");
        homePagePanel.add(homePageTitle, java.awt.BorderLayout.PAGE_START);

        homePageTextArea.setEditable(false);
        homePageTextArea.setColumns(20);
        homePageTextArea.setLineWrap(true);
        homePageTextArea.setRows(5);
        homePageTextArea.setText("Hello and welcome to your personal financial portal! At the top of the page you can see a list of tabs, which all have your financial data displayed in a convenient way for you. This portal is meant to be a tool for you to use to make the most informed decisions financially that you can.");
        homePageTextArea.setWrapStyleWord(true);
        jScrollPane3.setViewportView(homePageTextArea);

        homePagePanel.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        /**
         * Adding Home Page
         */
        tabbedPane.addTab("Home Page", homePagePanel);

        /**
         * Making Accounts Page
         */
        accountsPagePanel.setLayout(new java.awt.BorderLayout());

        accountsPagePanelTitle.setText("Accounts Page");
        accountsPageTitlePanel.add(accountsPagePanelTitle);

        accountsPageTitleButton.setText("Select Info");
        accountsPageTitlePanel.add(accountsPageTitleButton);

        accountsPagePanel.add(accountsPageTitlePanel, java.awt.BorderLayout.PAGE_START);

        accountsPageTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
                },
                new String[]{
                    "Amount", "Institution", "Type"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        accountsPageTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(accountsPageTable);
        if (accountsPageTable.getColumnModel().getColumnCount() > 0) {
            accountsPageTable.getColumnModel().getColumn(0).setResizable(false);
            accountsPageTable.getColumnModel().getColumn(1).setResizable(false);
            accountsPageTable.getColumnModel().getColumn(2).setResizable(false);
        }

        accountsPagePanel.add(jScrollPane7, java.awt.BorderLayout.CENTER);

        /**
         * Adding Accounts Page
         */
        tabbedPane.addTab("Accounts", accountsPagePanel);

        /**
         * Making Budgets Page
         */
        budgetsPagePanel.setLayout(new java.awt.BorderLayout());

        budgetsPageTitle.setText("Budgets Page");
        budgetsPageTitlePanel.add(budgetsPageTitle);

        budgetsPageTitleButton.setText("Select Info");
        budgetsPageTitlePanel.add(budgetsPageTitleButton);

        budgetsPagePanel.add(budgetsPageTitlePanel, java.awt.BorderLayout.PAGE_START);
        budgetsPagePanel.add(budgetsPageGraphPanel, java.awt.BorderLayout.CENTER);

        /**
         * Adding Budgets Page
         */
        tabbedPane.addTab("Budgets", budgetsPagePanel);

        /**
         * Making Loans Page
         */
        loansPagePanel.setLayout(new java.awt.BorderLayout());

        loansPageTitle.setText("Loans Page");
        loansPageTitlePanel.add(loansPageTitle);

        loansPageTitleButton.setText("Select Info");

        loansPageTitlePanel.add(loansPageTitleButton);

        loansPagePanel.add(loansPageTitlePanel, java.awt.BorderLayout.PAGE_START);
        loansPagePanel.add(loansPageGraphPanel, java.awt.BorderLayout.CENTER);

        /**
         * Adding Loans Page
         */
        tabbedPane.addTab("Loans", loansPagePanel);

        /**
         * Making Spendings Page
         */
        spendingsPagePanel.setLayout(new java.awt.BorderLayout());

        spendingsPageTitle.setText("Spendings Page");
        spendingsPageTitlePanel.add(spendingsPageTitle);

        spendingsPageTitleButton.setText("Select Info");
        spendingsPageTitlePanel.add(spendingsPageTitleButton);

        spendingsPagePanel.add(spendingsPageTitlePanel, java.awt.BorderLayout.PAGE_START);
        spendingsPagePanel.add(spendingsPageGraphPanel, java.awt.BorderLayout.CENTER);

        /**
         * Adding Spendings Page
         */
        tabbedPane.addTab("Spendings", spendingsPagePanel);

        /**
         * Making Transactions Page
         */
        transactionsPagePanel.setLayout(new java.awt.BorderLayout());

        transactionsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Amount", "Date", "Institution"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        transactionsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(transactionsTable);
        if (transactionsTable.getColumnModel().getColumnCount() > 0) {
            transactionsTable.getColumnModel().getColumn(0).setResizable(false);
            transactionsTable.getColumnModel().getColumn(1).setResizable(false);
            transactionsTable.getColumnModel().getColumn(2).setResizable(false);
        }

        transactionsPagePanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        transactionsPageTitle.setText("Transactions Page");
        transactionsPageTitlePanel.add(transactionsPageTitle);

        transactionsPageTitleButton.setText("Select Info");
        transactionsPageTitlePanel.add(transactionsPageTitleButton);

        transactionsPagePanel.add(transactionsPageTitlePanel, java.awt.BorderLayout.PAGE_START);

        /**
         * Adding Transactions Page
         */
        tabbedPane.addTab("Transactions", transactionsPagePanel);

        /**
         * Making Trends Page
         */
        trendsPagePanel.setLayout(new java.awt.BorderLayout());

        trendsPageTitle.setText("Trends Page");
        trendsPageTitlePanel.add(trendsPageTitle);

        trendsPageTitleButton.setText("Select Info");
        trendsPageTitlePanel.add(trendsPageTitleButton);

        trendsPagePanel.add(trendsPageTitlePanel, java.awt.BorderLayout.PAGE_START);
        trendsPagePanel.add(trendsPageGraphPanel, java.awt.BorderLayout.CENTER);

        /**
         * Adding Trends Page
         */
        tabbedPane.addTab("Trends", trendsPagePanel);

        /**
         * Adding Tabbed Pane
         */
        getContentPane().add(tabbedPane, "card2");

        /**
         * Making file menu
         */
        fileButton.setText("File");

        quitButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, 0));
        quitButton.setText("Quit");
        quitButton.addActionListener(this::quitButtonActionPerformed);
        fileButton.add(quitButton);

        menuBar.add(fileButton);

        pagesButton.setText("Pages");

        homePageButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, 0));
        homePageButton.setText("Home");
        homePageButton.addActionListener(e -> homePageButtonActionPerformed(e));
        pagesButton.add(homePageButton);

        accountsPageButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, 0));
        accountsPageButton.setText("Accounts");
        accountsPageButton.addActionListener(e -> accountsPageButtonActionPerformed(e));
        pagesButton.add(accountsPageButton);

        budgetsPageButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, 0));
        budgetsPageButton.setText("Budgets");
        budgetsPageButton.addActionListener(e -> budgetsPageButtonActionPerformed(e));
        pagesButton.add(budgetsPageButton);

        loansPageButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, 0));
        loansPageButton.setText("Loans");
        loansPageButton.addActionListener(e -> loansPageButtonActionPerformed(e));
        pagesButton.add(loansPageButton);

        spendingsPageButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, 0));
        spendingsPageButton.setText("Spending");
        spendingsPageButton.addActionListener(e -> spendingsPageButtonActionPerformed(e));
        pagesButton.add(spendingsPageButton);

        transactionsPageButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, 0));
        transactionsPageButton.setText("Transactions");
        transactionsPageButton.addActionListener(e -> transactionsPageButtonActionPerformed(e));
        pagesButton.add(transactionsPageButton);

        trendsPageButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7, 0));
        trendsPageButton.setText("Trends");
        trendsPageButton.addActionListener(e -> trendsPageButtonActionPerformed(e));
        pagesButton.add(trendsPageButton);

        /**
         * Adding file menu
         */
        menuBar.add(pagesButton);

        setJMenuBar(menuBar);

        pack();
        
        buttons = new ArrayList<>();
        buttons.add(accountsPageTitleButton);
        buttons.add(budgetsPageTitleButton);
        buttons.add(loansPageTitleButton);
        buttons.add(spendingsPageTitleButton);
        buttons.add(transactionsPageTitleButton);
        buttons.add(trendsPageTitleButton);
    }

    /**
     * Function to set the tab that the user selected to the accounts page tab
     *
     * @param evt the user's click
     */
    private void accountsPageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        enablePage(1);
    }

    /**
     * Function to create a bar graph based on the ArrayList of budgets passed
     * into the parameter
     *
     * @param spendings the array list of budgets the graph will be built around
     */
    public void addBarGraph(ArrayList<Spending> spendings) {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        spendings.forEach((s) -> {
            data.addValue(s.getAmount(), s.getType(), s.getSDF());
        });
        JFreeChart chart = ChartFactory.createBarChart("Spendings Graph for " + spendings.get(0).getSDF(), "Type", "Amount", data);
        ChartPanel panel = new ChartPanel(chart);
        spendingsPageGraphPanel.add(panel);
    }

    /**
     * Function to create a bar graph based on the ArrayList of trends passed
     * into the parameter
     *
     * @param trends the array list of trends the graph will be built around
     */
    public void addLineGraph(ArrayList<Trend> trends) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        trends.forEach((t) -> {
            dataset.addValue(t.getAmount(), t.getType(), t.getSDF());
        });
        JFreeChart chart = ChartFactory.createLineChart("Trends Graph for " + trends.get(0).getFrame().substring(trends.get(0).getFrame().length() - 4), "Frame", "Type", dataset);
        ChartPanel panel = new ChartPanel(chart);
        trendsPageGraphPanel.add(panel);
    }

    /**
     * Function to create a bar graph based on the ArrayList of trends passed
     * into the parameter
     *
     * @param budgets the array list of trends the graph will be built around
     */
    public void addRingGraph(ArrayList<Budget> budgets) {
        DefaultPieDataset pieData = new DefaultPieDataset();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        budgets.forEach((b) -> {
            pieData.setValue(b.getType(), b.getAmount());
            pieData.setValue(b.getType() + " Remaining", b.getAmount() - b.getPaid());
        });
        JFreeChart chart = ChartFactory.createRingChart("Budgets Graph for " + budgets.get(0).getFrame(), pieData, false, true, false);
        ChartPanel panel = new ChartPanel(chart);
        budgetsPageGraphPanel.add(panel);
    }

    /**
     * Function to set the tab that the user selected to the budgets page tab
     *
     * @param evt the user's click
     */
    private void budgetsPageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        enablePage(2);
    }

    /**
     * Function to select the page the user selected
     *
     * @param pageIndex the index of the page the user selected
     */
    public void enablePage(int pageIndex) {
        tabbedPane.setSelectedIndex(pageIndex);
    }

    /**
     * Function to return the array list of buttons for each of our pages that
     * will get information
     *
     * @return the array list of buttons on each of our pages
     */
    public ArrayList<JButton> getButtons() {
        return buttons;
    }

    /**
     * Function to prompt the user to get the information they are seeking
     *
     * @param obj the type of object they want (frame of reference, type,
     * institution, etc.)
     * @param desInfo the type of that object they want (account, budget, loan,
     * etc.)
     * @return the string the user entered into the prompt
     */
    public String getInfo(String obj, String desInfo) {
        return JOptionPane.showInputDialog("Please enter the " + obj + " you seek for your " + desInfo + ":");
    }

    /**
     * Function to return the private panel based on the parameter panel
     *
     * @param panel a string representing the kind of panel desired
     * @return the private panel based on the parameter panel
     */
    public JPanel getPanel(String panel) {
        switch (panel.toLowerCase()) {
            case "budget":
                return budgetsPageGraphPanel;
            case "loan":
                return loansPageGraphPanel;
            case "trend":
                return trendsPageGraphPanel;
            default:
                return accountsPagePanel;
        }
    }

    /**
     * Function to return the index of the current tab the user is on
     *
     * @return int representing the index of which tab we are on
     */
    public int getTabSelected() {
        return tabbedPane.getSelectedIndex();
    }

    /**
     * Function to set the tab that the user selected to the home page tab
     *
     * @param evt the user's click
     */
    private void homePageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        enablePage(0);
    }

    /**
     * Function that takes an array list of accounts and puts each account into
     * the accounts table
     *
     * @param accounts array list of accounts to be put into the accounts table
     */
    public void inputDataIntoAccountsTable(ArrayList<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            Account a = accounts.get(i);
            DefaultTableModel model = (DefaultTableModel) accountsPageTable.getModel();
            Object[] list = {a.getAmount(), a.getInstitution(), a.getType()};
            model.addRow(list);
        }
    }

    /**
     * Function that takes an array list of transactions and puts each
     * transaction into the transaction table
     *
     * @param transactions array list of transactions to be put into the
     * transactions table
     */
    public void inputDataIntoTransactionsTable(ArrayList<Transaction> transactions) {
        for (int i = 0; i < transactions.size(); i++) {
            Transaction t = transactions.get(i);
            DefaultTableModel model = (DefaultTableModel) transactionsTable.getModel();
            Object[] list = {t.getAmount(), t.getFrame(), t.getInstitution()};
            model.addRow(list);
        }
    }

    /**
     * Function to set the tab that the user selected to the loans page tab
     *
     * @param evt the user's click
     */
    private void loansPageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        enablePage(3);
    }

    /**
     * Function to quit the program
     *
     * @param evt the user's click
     */
    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    /**
     * Function to remove all graphs from the panel passed in
     *
     * @param panelToRemoveFrom the panel in which the graph will be removed
     * from
     */
    public void removeGraph(JPanel panelToRemoveFrom) {
        panelToRemoveFrom.removeAll();
    }

    /**
     * Function to set the tab that the user selected to the spendings page tab
     *
     * @param evt the user's click
     */
    private void spendingsPageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        enablePage(4);
    }

    /**
     * Function to set the tab that the user selected to the transactions page
     * tab
     *
     * @param evt the user's click
     */
    private void transactionsPageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        enablePage(5);
    }

    /**
     * Function to set the tab that the user selected to the trends page tab
     *
     * @param evt the user's click
     */
    private void trendsPageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        enablePage(6);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinancialPortalFrameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FinancialPortalFrameView().setVisible(true);
        });
    }

    // Variables declaration                     
    private javax.swing.JMenuItem accountsPageButton;
    private javax.swing.JPanel accountsPagePanel;
    private javax.swing.JLabel accountsPagePanelTitle;
    private javax.swing.JTable accountsPageTable;
    private javax.swing.JButton accountsPageTitleButton;
    private javax.swing.JPanel accountsPageTitlePanel;
    private javax.swing.JMenuItem budgetsPageButton;
    private javax.swing.JPanel budgetsPagePanel;
    private javax.swing.JPanel budgetsPageGraphPanel;
    private javax.swing.JLabel budgetsPageTitle;
    private javax.swing.JButton budgetsPageTitleButton;
    private javax.swing.JPanel budgetsPageTitlePanel;
    private javax.swing.JMenu fileButton;
    private javax.swing.JMenuItem homePageButton;
    private javax.swing.JPanel homePagePanel;
    private javax.swing.JTextArea homePageTextArea;
    private javax.swing.JLabel homePageTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JMenuItem loansPageButton;
    private javax.swing.JPanel loansPageGraphPanel;
    private javax.swing.JPanel loansPagePanel;
    private javax.swing.JLabel loansPageTitle;
    private javax.swing.JButton loansPageTitleButton;
    private javax.swing.JPanel loansPageTitlePanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu pagesButton;
    private javax.swing.JMenuItem quitButton;
    private javax.swing.JMenuItem spendingsPageButton;
    private javax.swing.JPanel spendingsPageGraphPanel;
    private javax.swing.JPanel spendingsPagePanel;
    private javax.swing.JLabel spendingsPageTitle;
    private javax.swing.JButton spendingsPageTitleButton;
    private javax.swing.JPanel spendingsPageTitlePanel;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JMenuItem transactionsPageButton;
    private javax.swing.JPanel transactionsPagePanel;
    private javax.swing.JLabel transactionsPageTitle;
    private javax.swing.JButton transactionsPageTitleButton;
    private javax.swing.JPanel transactionsPageTitlePanel;
    private javax.swing.JTable transactionsTable;
    private javax.swing.JMenuItem trendsPageButton;
    private javax.swing.JPanel trendsPageGraphPanel;
    private javax.swing.JPanel trendsPagePanel;
    private javax.swing.JLabel trendsPageTitle;
    private javax.swing.JButton trendsPageTitleButton;
    private javax.swing.JPanel trendsPageTitlePanel;
}
