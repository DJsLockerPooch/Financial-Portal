package financialportal;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 * View of the Financial Portal project. This class simply displays the page(s)
 * for the user to interact with
 *
 * @author Christian Kasel
 */
public class FinancialPortalView extends javax.swing.JFrame {

    private static ArrayList<JButton> buttons;
    private static ArrayList<JComboBox> boxes;

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
        // Initializing accounts page objects
        accountsPageBriefingPane = new javax.swing.JScrollPane();
        accountsPageBriefingTextArea = new javax.swing.JTextArea();
        accountsPageComboBox = new javax.swing.JComboBox<>();
        accountsPageHelpPane = new javax.swing.JScrollPane();
        accountsPageHelpTextArea = new javax.swing.JTextArea();
        accountsPageButton = new javax.swing.JMenuItem();
        accountsPagePanel = new javax.swing.JPanel();
        accountsPagePanelTitle = new javax.swing.JLabel();
        accountsPageTable = new javax.swing.JTable();
        accountsPageTablePanel = new javax.swing.JPanel();
        accountsPageTitleButton = new javax.swing.JButton();
        accountsPageTitlePanel = new javax.swing.JPanel();
        accountsPageTableScrollPane = new javax.swing.JScrollPane();

        // Initializing budgets page objects
        budgetsPageBriefingScrollPane = new javax.swing.JScrollPane();
        budgetsPageBriefingTextArea = new javax.swing.JTextArea();
        budgetsPageComboBox = new javax.swing.JComboBox<>();
        budgetsPageHelpScrollPane = new javax.swing.JScrollPane();
        budgetsPageHelpTextArea = new javax.swing.JTextArea();
        budgetsPageButton = new javax.swing.JMenuItem();
        budgetsPagePanel = new javax.swing.JPanel();
        budgetsPageGraphPanel = new javax.swing.JPanel();
        budgetsPageTitle = new javax.swing.JLabel();
        budgetsPageTitleButton = new javax.swing.JButton();
        budgetsPageTitlePanel = new javax.swing.JPanel();

        // Initializing file button
        fileButton = new javax.swing.JMenu();

        // Initializing home page objects
        homePageButton = new javax.swing.JMenuItem();
        homePagePanel = new javax.swing.JPanel();
        homePageTextArea = new javax.swing.JTextArea();
        homePageTextScrollPane = new javax.swing.JScrollPane();
        homePageTitle = new javax.swing.JLabel();

        // Initializing loans page objects
        loansPageButton = new javax.swing.JMenuItem();
        loansPageComboBox = new javax.swing.JComboBox<>();
        loanPageLoanAmountInfo = new javax.swing.JLabel();
        loanPageLoanDateInfo = new javax.swing.JLabel();
        loanPageLoanInstitutionInfo = new javax.swing.JLabel();
        loanPageLowPayment = new javax.swing.JLabel();
        loanPageHighPayment = new javax.swing.JLabel();
        loanPageLoanExtraInfo1 = new javax.swing.JLabel();
        loanPageLoanExtraInfo2 = new javax.swing.JLabel();
        loanPageLoanExtraInfo3 = new javax.swing.JLabel();
        loansPagePanel = new javax.swing.JPanel();
        loansPageTitle = new javax.swing.JLabel();
        loansPageTitleButton = new javax.swing.JButton();
        loansPageTitlePanel = new javax.swing.JPanel();
        loanPagePaymentSlider = new javax.swing.JSlider();
        loansPageTablePanel = new javax.swing.JPanel();
        loansPageHelpTextArea = new javax.swing.JTextArea();
        loansPageHelpScrollPane = new javax.swing.JScrollPane();

        // Initializing menu objects
        menuBar = new javax.swing.JMenuBar();
        pagesButton = new javax.swing.JMenu();
        quitButton = new javax.swing.JMenuItem();

        // Initializing spendings page objects
        spendingsPageButton = new javax.swing.JMenuItem();
        spendingsPageComboBox = new javax.swing.JComboBox<>();
        spendingsPageGraphPanel = new javax.swing.JPanel();
        spendingsPagePanel = new javax.swing.JPanel();
        spendingsPageTitle = new javax.swing.JLabel();
        spendingsPageTitleButton = new javax.swing.JButton();
        spendingsPageTitlePanel = new javax.swing.JPanel();
        spendingsPageBriefingArea = new javax.swing.JTextArea();
        spendingsPageHelpArea = new javax.swing.JTextArea();
        spendingsPageBriefingScrollArea = new javax.swing.JScrollPane();
        spendingsPageHelpScrollArea = new javax.swing.JScrollPane();

        // Initializing tabbed pane
        tabbedPane = new javax.swing.JTabbedPane();

        // Initializing transactions page objects
        transactionsPageBriefingArea = new javax.swing.JTextArea();
        transactionsPageButton = new javax.swing.JMenuItem();
        transactionsPageComboBox = new javax.swing.JComboBox<>();
        transactionsPageHelpArea = new javax.swing.JTextArea();
        transactionsPageHelpScrollArea = new javax.swing.JScrollPane();
        transactionsPagePanel = new javax.swing.JPanel();
        transactionsPageScrollArea = new javax.swing.JScrollPane();
        transactionsPageTitlePanel = new javax.swing.JPanel();
        transactionsPageTitle = new javax.swing.JLabel();
        transactionsPageTitleButton = new javax.swing.JButton();
        transactionsPageTablePanel = new javax.swing.JPanel();
        transactionsPageTableScrollArea = new javax.swing.JScrollPane();
        transactionsPageTable = new javax.swing.JTable();

        // Initializing trends page objects
        trendsPageBriefingArea = new javax.swing.JTextArea();
        trendsPageBriefingScrollArea = new javax.swing.JScrollPane();
        trendsPageButton = new javax.swing.JMenuItem();
        trendsPageComboBox = new javax.swing.JComboBox<>();
        trendsPageGraphPanel = new javax.swing.JPanel();
        trendsPageHelpArea = new javax.swing.JTextArea();
        trendsPageHelpScrollArea = new javax.swing.JScrollPane();
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
        homePageTextScrollPane.setViewportView(homePageTextArea);
        homePagePanel.add(homePageTextScrollPane, java.awt.BorderLayout.CENTER);
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
        accountsPageTitleButton.setText("Load Data");
        accountsPageTitlePanel.add(accountsPageTitleButton);
        accountsPageTitlePanel.add(accountsPageComboBox);
        accountsPagePanel.add(accountsPageTitlePanel, java.awt.BorderLayout.PAGE_START);
        accountsPageTablePanel.setPreferredSize(new java.awt.Dimension(400, 500));
        accountsPageTableScrollPane.setPreferredSize(new java.awt.Dimension(550, 555));
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
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        accountsPageTable.getTableHeader().setReorderingAllowed(false);
        accountsPageTable.setPreferredSize(new java.awt.Dimension(400, 625));
        accountsPageTableScrollPane.setViewportView(accountsPageTable);
        if (accountsPageTable.getColumnModel().getColumnCount() > 0) {
            accountsPageTable.getColumnModel().getColumn(0).setResizable(false);
            accountsPageTable.getColumnModel().getColumn(1).setResizable(false);
            accountsPageTable.getColumnModel().getColumn(2).setResizable(false);
        }
        accountsPageTablePanel.add(accountsPageTableScrollPane);
        accountsPagePanel.add(accountsPageTablePanel, java.awt.BorderLayout.CENTER);
        accountsPageBriefingPane.setPreferredSize(new java.awt.Dimension(300, 625));
        accountsPageBriefingTextArea.setColumns(20);
        accountsPageBriefingTextArea.setLineWrap(true);
        accountsPageBriefingTextArea.setRows(5);
        accountsPageBriefingTextArea.setText("   Hello and welcome to your accounts page! On this page you will see a list of all your account types and the institutions they belong to.\n\n   To load the data, please select the \"Load Data\" button. Then the drop down menu should fill up with all of the institutions you can choose from. Just select the institution you wish to see, and the table of that institution should be displayed.");
        accountsPageBriefingTextArea.setWrapStyleWord(true);
        accountsPageBriefingTextArea.setDragEnabled(false);
        accountsPageBriefingTextArea.setPreferredSize(new java.awt.Dimension(300, 500));
        accountsPageBriefingPane.setViewportView(accountsPageBriefingTextArea);
        accountsPagePanel.add(accountsPageBriefingPane, java.awt.BorderLayout.LINE_START);
        accountsPageHelpPane.setPreferredSize(new java.awt.Dimension(300, 500));
        accountsPageHelpTextArea.setColumns(20);
        accountsPageHelpTextArea.setLineWrap(true);
        accountsPageHelpTextArea.setRows(5);
        accountsPageHelpTextArea.setText("   The type of the account will be listed under the \"Type\" column, while the name of the institution in which that accounts is will be listed under the \"Institution\" column, and finally the amount in that account will be displayed in the \"Amount\" column of the table.");
        accountsPageHelpTextArea.setWrapStyleWord(true);
        accountsPageHelpTextArea.setPreferredSize(new java.awt.Dimension(300, 500));
        accountsPageHelpPane.setViewportView(accountsPageHelpTextArea);
        accountsPagePanel.add(accountsPageHelpPane, java.awt.BorderLayout.LINE_END);
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
        budgetsPageTitleButton.setText("Load Data");
        budgetsPageTitlePanel.add(budgetsPageTitleButton);
        budgetsPageTitlePanel.add(budgetsPageComboBox);
        budgetsPagePanel.add(budgetsPageTitlePanel, java.awt.BorderLayout.PAGE_START);
        budgetsPageGraphPanel.setPreferredSize(new java.awt.Dimension(280, 500));
        budgetsPagePanel.add(budgetsPageGraphPanel, java.awt.BorderLayout.CENTER);
        budgetsPageBriefingScrollPane.setPreferredSize(new java.awt.Dimension(275, 500));
        budgetsPageBriefingTextArea.setEditable(false);
        budgetsPageBriefingTextArea.setColumns(20);
        budgetsPageBriefingTextArea.setLineWrap(true);
        budgetsPageBriefingTextArea.setRows(5);
        budgetsPageBriefingTextArea.setText("   Hello and welcome to your budgeting page! On this page you will see a type of budget, the total amout for the month and the amount left to be paid.\n\n   To load the data, please select the \"Load Data\" button. Then a graph should appear with the first budget. The drop down menu should fill up with all of the budgets you can choose from. Just select the budget you wish to see, and the graph of that budget should appear in the middle section.");
        budgetsPageBriefingTextArea.setWrapStyleWord(true);
        budgetsPageBriefingTextArea.setPreferredSize(new java.awt.Dimension(275, 500));
        budgetsPageBriefingScrollPane.setViewportView(budgetsPageBriefingTextArea);
        budgetsPagePanel.add(budgetsPageBriefingScrollPane, java.awt.BorderLayout.LINE_START);
        budgetsPageHelpScrollPane.setPreferredSize(new java.awt.Dimension(275, 500));
        budgetsPageHelpTextArea.setEditable(false);
        budgetsPageHelpTextArea.setColumns(20);
        budgetsPageHelpTextArea.setLineWrap(true);
        budgetsPageHelpTextArea.setRows(5);
        budgetsPageHelpTextArea.setText("   The red color represents how much of the monthly budget you have paid so far. The blue color represents how much of the budget you have left to pay off.\n\n   If only one color is shown, then either all or none of the budget needs to be paid for.");
        budgetsPageHelpTextArea.setWrapStyleWord(true);
        budgetsPageHelpTextArea.setPreferredSize(new java.awt.Dimension(275, 500));
        budgetsPageHelpScrollPane.setViewportView(budgetsPageHelpTextArea);
        budgetsPagePanel.add(budgetsPageHelpScrollPane, java.awt.BorderLayout.LINE_END);
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
        loansPageTitleButton.setText("Load Data");
        loansPageTitlePanel.add(loansPageTitleButton);
        loansPageTitlePanel.add(loansPageComboBox);
        loansPagePanel.add(loansPageTitlePanel, java.awt.BorderLayout.PAGE_START);
        loansPageTablePanel.setLayout(new java.awt.GridLayout(3, 3));
        loanPageLoanInstitutionInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loanPageLoanInstitutionInfo.setText("Institution: N/A");
        loansPageTablePanel.add(loanPageLoanInstitutionInfo);
        loanPageLoanAmountInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loanPageLoanAmountInfo.setText("Amount: N/A");
        loansPageTablePanel.add(loanPageLoanAmountInfo);
        loanPageLoanDateInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loanPageLoanDateInfo.setText("Date: N/A");
        loansPageTablePanel.add(loanPageLoanDateInfo);
        loanPageLowPayment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loanPageLowPayment.setText("0");
        loansPageTablePanel.add(loanPageLowPayment);
        loanPagePaymentSlider.setEnabled(false);
        loanPagePaymentSlider.addChangeListener(this::loansPagePaymentSliderStateChanged);
        loansPageTablePanel.add(loanPagePaymentSlider);
        loanPageHighPayment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loanPageHighPayment.setText("-");
        loansPageTablePanel.add(loanPageHighPayment);
        loanPageLoanExtraInfo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loanPageLoanExtraInfo1.setText("Estimated payoff date: N/A");
        loansPageTablePanel.add(loanPageLoanExtraInfo1);
        loansPageTablePanel.add(loanPageLoanExtraInfo2);
        loanPageLoanExtraInfo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loanPageLoanExtraInfo3.setText("New payoff date: N/A");
        loansPageTablePanel.add(loanPageLoanExtraInfo3);
        loansPagePanel.add(loansPageTablePanel, java.awt.BorderLayout.CENTER);

        loansPageHelpTextArea.setEditable(false);
        loansPageHelpTextArea.setColumns(20);
        loansPageHelpTextArea.setLineWrap(true);
        loansPageHelpTextArea.setRows(5);
        loansPageHelpTextArea.setText("   Hello and welcome to your loans page. This page will display the loan that you requested when you select it from the drop down menu.\n\n   The institution, amount, and due date will be displayed. The slider represents how much of the payment for the month you would like to pay. Below the slider will be the adjusted loan payoff date assuming payments would remain the same.");
        loansPageHelpTextArea.setWrapStyleWord(true);
        loansPageHelpScrollPane.setViewportView(loansPageHelpTextArea);

        loansPagePanel.add(loansPageHelpScrollPane, java.awt.BorderLayout.LINE_START);
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
        spendingsPageTitleButton.setText("Load Data");
        spendingsPageTitlePanel.add(spendingsPageTitleButton);
        spendingsPageTitlePanel.add(spendingsPageComboBox);
        spendingsPagePanel.add(spendingsPageTitlePanel, java.awt.BorderLayout.PAGE_START);
        spendingsPagePanel.add(spendingsPageGraphPanel, java.awt.BorderLayout.CENTER);

        spendingsPageBriefingArea.setColumns(20);
        spendingsPageBriefingArea.setLineWrap(true);
        spendingsPageBriefingArea.setRows(5);
        spendingsPageBriefingArea.setText("   Hello and welcome to your spendings page! On this page you will see all the spendings, the time of the spending, and the amount that spending procurred.\n\n   To load the data, please select the \"Load Data\" button. Then a graph should appear with the years spendings. The drop down menu should fill up with all of the spendings you can choose from. Just select the spending you wish to see, and the graph of that spending should appear in the middle section.");
        spendingsPageBriefingArea.setWrapStyleWord(true);
        spendingsPageBriefingScrollArea.setViewportView(spendingsPageBriefingArea);

        spendingsPagePanel.add(spendingsPageBriefingScrollArea, java.awt.BorderLayout.LINE_START);

        spendingsPageHelpArea.setColumns(20);
        spendingsPageHelpArea.setLineWrap(true);
        spendingsPageHelpArea.setRows(5);
        spendingsPageHelpArea.setText("   When a graph appears, each bar represents a different spending for that month. There may be one in a month, or there may be more, and then a legend will appear along the bottom of the graph representing the color of the bars.");
        spendingsPageHelpArea.setWrapStyleWord(true);
        spendingsPageHelpScrollArea.setViewportView(spendingsPageHelpArea);

        spendingsPagePanel.add(spendingsPageHelpScrollArea, java.awt.BorderLayout.LINE_END);

        /**
         * Adding Spendings Page
         */
        tabbedPane.addTab("Spendings", spendingsPagePanel);

        transactionsPagePanel.setLayout(new java.awt.BorderLayout());

        transactionsPageTitle.setText("Transactions Page");
        transactionsPageTitlePanel.add(transactionsPageTitle);

        transactionsPageTitleButton.setText("Load Data");
        transactionsPageTitlePanel.add(transactionsPageTitleButton);
        transactionsPageTitlePanel.add(transactionsPageComboBox);

        transactionsPagePanel.add(transactionsPageTitlePanel, java.awt.BorderLayout.PAGE_START);

        transactionsPageTableScrollArea.setPreferredSize(new java.awt.Dimension(550, 535));

        transactionsPageTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
                },
                new String[]{
                    "Amount", "Date", "Institution"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        transactionsPageTable.setPreferredSize(new java.awt.Dimension(225, 535));
        transactionsPageTable.getTableHeader().setReorderingAllowed(false);
        transactionsPageTableScrollArea.setViewportView(transactionsPageTable);
        if (transactionsPageTable.getColumnModel().getColumnCount() > 0) {
            transactionsPageTable.getColumnModel().getColumn(0).setResizable(false);
            transactionsPageTable.getColumnModel().getColumn(1).setResizable(false);
            transactionsPageTable.getColumnModel().getColumn(2).setResizable(false);
        }

        transactionsPageTablePanel.add(transactionsPageTableScrollArea);

        transactionsPagePanel.add(transactionsPageTablePanel, java.awt.BorderLayout.CENTER);

        transactionsPageScrollArea.setPreferredSize(new java.awt.Dimension(300, 84));

        transactionsPageBriefingArea.setColumns(20);
        transactionsPageBriefingArea.setLineWrap(true);
        transactionsPageBriefingArea.setRows(5);
        transactionsPageBriefingArea.setText("   Hello and welcome to your transactions page! On this page you will see the amount, date, and institution of the transactions.\n\n   To load the data, please select the \"Load Data\" button. Then the month's transactions will appear. The drop down menu will also fill up with other months/years worth of data to be selected. Just select the month/year you would like and the table should reappear with that month/year's data.");
        transactionsPageBriefingArea.setWrapStyleWord(true);
        transactionsPageScrollArea.setViewportView(transactionsPageBriefingArea);

        transactionsPagePanel.add(transactionsPageScrollArea, java.awt.BorderLayout.LINE_START);

        transactionsPageHelpScrollArea.setPreferredSize(new java.awt.Dimension(300, 84));

        transactionsPageHelpArea.setColumns(20);
        transactionsPageHelpArea.setLineWrap(true);
        transactionsPageHelpArea.setRows(5);
        transactionsPageHelpArea.setText("   The amount of the transaction will be listed under the \"Amount\" column, while the date of the transaction will be listed under the \"Date\" column, and finally the institution that the transaction went to will be displayed in the \"Institution\" column of the table.");
        transactionsPageHelpArea.setWrapStyleWord(true);
        transactionsPageHelpScrollArea.setViewportView(transactionsPageHelpArea);

        transactionsPagePanel.add(transactionsPageHelpScrollArea, java.awt.BorderLayout.LINE_END);

        tabbedPane.addTab("Transactions", transactionsPagePanel);

        trendsPagePanel.setLayout(new java.awt.BorderLayout());

        trendsPageTitle.setText("Trends Page");
        trendsPageTitlePanel.add(trendsPageTitle);

        trendsPageTitleButton.setText("Load Data");
        trendsPageTitlePanel.add(trendsPageTitleButton);
        trendsPageTitlePanel.add(trendsPageComboBox);

        trendsPagePanel.add(trendsPageTitlePanel, java.awt.BorderLayout.PAGE_START);
        trendsPagePanel.add(trendsPageGraphPanel, java.awt.BorderLayout.CENTER);

        trendsPageBriefingArea.setColumns(20);
        trendsPageBriefingArea.setLineWrap(true);
        trendsPageBriefingArea.setRows(5);
        trendsPageBriefingArea.setText("   Hello and welcome to your trends page! On this page you will see a line graph of groups of transactions over a span of time.\n\n   To load the data, please select the \"Load Data\" button. Then a graph should appear with the years trend graph. The drop down menu should fill up with all of the years which you can choose from. Just select the year you wish to see, and the line graph of that yaer should appear in the middle section.");
        trendsPageBriefingArea.setWrapStyleWord(true);
        trendsPageBriefingScrollArea.setViewportView(trendsPageBriefingArea);

        trendsPagePanel.add(trendsPageBriefingScrollArea, java.awt.BorderLayout.LINE_START);

        trendsPageHelpArea.setColumns(20);
        trendsPageHelpArea.setLineWrap(true);
        trendsPageHelpArea.setRows(5);
        trendsPageHelpArea.setText("   When a graph appears, each line represents a different trend for that month/year. There may be one line, or there may be more, and then a legend will appear along the bottom of the graph representing the color of the lines.");
        trendsPageHelpArea.setWrapStyleWord(true);
        trendsPageHelpScrollArea.setViewportView(trendsPageHelpArea);

        trendsPagePanel.add(trendsPageHelpScrollArea, java.awt.BorderLayout.LINE_END);

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

        boxes = new ArrayList<>();
        boxes.add(accountsPageComboBox);
        boxes.add(budgetsPageComboBox);
        boxes.add(loansPageComboBox);
        boxes.add(spendingsPageComboBox);
        boxes.add(transactionsPageComboBox);
        boxes.add(trendsPageComboBox);
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
        removeGraph(spendingsPageGraphPanel);
        Collections.sort(spendings, Spending.SpendingFrameComparator);
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        spendings.forEach((s) -> {
            data.addValue(s.getAmount(), s.getType(), s.getSDF());
        });
        JFreeChart chart = ChartFactory.createBarChart("Spendings Graph for " + spendings.get(0).getSDF(), "Type", "Amount", data);
        ChartPanel panel = new ChartPanel(chart);
        spendingsPageGraphPanel.add(panel);
        spendingsPageGraphPanel.updateUI();
    }

    /**
     * Function to create a bar graph based on the ArrayList of trends passed
     * into the parameter
     *
     * @param trends the array list of trends the graph will be built around
     */
    public void addLineGraph(ArrayList<Trend> trends) {
        removeGraph(trendsPageGraphPanel);
        Collections.sort(trends, Trend.TrendFrameComparator1);
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
        removeGraph(budgetsPageGraphPanel);
        Collections.sort(budgets, Budget.BudgetFrameComparator);
        DefaultPieDataset pieData = new DefaultPieDataset();
        budgets.forEach((b) -> {
            double prop = b.getPaid() / b.getAmount() * 100;
            pieData.setValue(b.getType() + ": " + prop + "%", b.getAmount());
            if (b.getAmount() - b.getPaid() > 0) {
                pieData.setValue(b.getType() + " Remaining: " + (100 - prop) + "%", b.getAmount() - b.getPaid());
            }
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
     * Function to remove all of the items in the given table
     *
     * @param table the JTable table you wish to remove all elements from
     */
    public void clearTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    /**
     * Function to disable the button based on the parameter passed in (should
     * only be called once the button has been pressed)
     *
     * @param buttonName the String representing the page in which the button
     * you wish to disable lies
     */
    public void disableButton(String buttonName) {
        switch (buttonName) {
            case "account":
                accountsPageTitleButton.setEnabled(false);
                break;
            case "budget":
                budgetsPageTitleButton.setEnabled(false);
                break;
            case "loan":
                loansPageTitleButton.setEnabled(false);
                break;
            case "spending":
                spendingsPageTitleButton.setEnabled(false);
                break;
            case "transaction":
                transactionsPageTitleButton.setEnabled(false);
                break;
            case "trend":
                trendsPageTitleButton.setEnabled(false);
                break;
            default:
                break;
        }
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
     * Function to return the array list of combo boxes for each of our pages
     * that will get information
     *
     * @return the array list of combo boxes on each of our pages
     */
    public ArrayList<JComboBox> getBoxes() {
        return boxes;
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
     * Function to get the selected information (from the combo box) on the
     * parameter's page
     *
     * @param pageName the page in which you are looking to get the information
     * from
     * @return the information that the user has selected on the given page
     */
    public String getItemSelected(String pageName) {
        switch (pageName) {
            case "account":
                return (String) accountsPageComboBox.getSelectedItem();
            case "budget":
                return (String) budgetsPageComboBox.getSelectedItem();
            case "loan":
                return (String) loansPageComboBox.getSelectedItem();
            case "spending":
                return (String) spendingsPageComboBox.getSelectedItem();
            case "transaction":
                return (String) transactionsPageComboBox.getSelectedItem();
            case "trend":
                return (String) trendsPageComboBox.getSelectedItem();
            default:
                return "";
        }
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
            case "spending":
                return spendingsPageGraphPanel;
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
        clearTable(accountsPageTable);
        DefaultTableModel model = (DefaultTableModel) accountsPageTable.getModel();
        for (int i = 0; i < accounts.size(); i++) {
            Account a = accounts.get(i);
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
        clearTable(transactionsPageTable);
        DefaultTableModel model = (DefaultTableModel) transactionsPageTable.getModel();
        for (int i = 0; i < transactions.size(); i++) {
            Transaction t = transactions.get(i);
            Object[] list = {t.getAmount(), t.getFrame(), t.getInstitution()};
            model.addRow(list);
        }
    }

    /**
     * Function to take an arraylist of accounts and insert each item into the
     * accounts page combo box
     *
     * @param accounts the arraylist of accounts to be inserted into the combo
     * box
     */
    public void insertIntoAccountsComboBox(ArrayList<Account> accounts) {
        accounts.forEach((a) -> {
            accountsPageComboBox.addItem(a.getInstitution() + ", " + a.getType());
        });
    }

    /**
     * Function to take an arraylist of budgets and insert each item into the
     * budgets page combo box
     *
     * @param budgets the arraylist of budgets to be inserted into the combo box
     */
    public void insertIntoBudgetsComboBox(ArrayList<Budget> budgets) {
        budgets.forEach((b) -> {
            budgetsPageComboBox.addItem(b.getFrame());
        });
    }

    /**
     * Function to take an arraylist of loans and insert each item into the
     * loans page combo box
     *
     * @param loans the arraylist of loans to be inserted into the combo box
     */
    public void insertIntoLoansComboBox(ArrayList<Loan> loans) {
        loans.forEach((l) -> {
            loansPageComboBox.addItem(l.getInstitution() + ", " + l.getLoanID());
        });
    }

    /**
     * Function to take an arraylist of spendings and insert each item into the
     * spendings page combo box
     *
     * @param spendings the arraylist of spendings to be inserted into the combo
     * box
     */
    public void insertIntoSpendingsComboBox(ArrayList<Spending> spendings) {
        spendings.forEach((s) -> {
            spendingsPageComboBox.addItem(s.getFrame());
        });
    }

    /**
     * Function to take an arraylist of transactions and insert each item into
     * the transactions page combo box
     *
     * @param transactions the arraylist of transactions to be inserted into the
     * combo box
     */
    public void insertIntoTransactionsComboBox(ArrayList<Transaction> transactions) {
        transactions.forEach((t) -> {
            transactionsPageComboBox.addItem(t.getFrame());
        });
    }

    /**
     * Function to take an arraylist of trends and insert each item into the
     * trends page combo box
     *
     * @param trends the arraylist of trends to be inserted into the combo box
     */
    public void insertIntoTrendsComboBox(ArrayList<Trend> trends) {
        trends.forEach((t) -> {
            trendsPageComboBox.addItem(t.getType());
        });
    }

    /**
     * Function to insert the loan (in the unlikely chance there's more than
     * one, the first one)
     *
     * @param loans the arraylist (hopefully) containing one loan
     */
    public void insertLoan(ArrayList<Loan> loans) {
        Loan loan = loans.get(0);
        loanPageLoanDateInfo.setText("Date: " + loan.getSDF());
        loanPageLoanAmountInfo.setText("Amount: " + loan.getAmount());
        loanPageLoanInstitutionInfo.setText("Institution: " + loan.getInstitution());
        loanPagePaymentSlider.enable();
    }

    /**
     * Function to set the tab that the user selected to the loans page tab
     *
     * @param evt the user's click
     */
    private void loansPageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        enablePage(3);
    }

    private void loansPagePaymentSliderStateChanged(javax.swing.event.ChangeEvent evt) {
        String[] split = loanPageLoanAmountInfo.getText().split(" ");
        if (!split[1].equals("N/A")) {
            double loanAmt = Double.parseDouble(split[1]);
            int paymentAmt = loanPagePaymentSlider.getValue();
            loanPageHighPayment.setText(String.valueOf(loanAmt * paymentAmt / 2000));
        }
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
     * Function to reset the laons page display to their default
     */
    public void resetLoansPage() {
        loanPageHighPayment.setText("-");
        loanPageLowPayment.setText("0");
        loanPageLoanDateInfo.setText("Date: N/A");
        loanPageLoanAmountInfo.setText("Amount: N/A");
        loanPageLoanInstitutionInfo.setText("Institution: N/A");
        loanPagePaymentSlider.setValue(0);
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
    private javax.swing.JScrollPane accountsPageBriefingPane;
    private javax.swing.JTextArea accountsPageBriefingTextArea;
    private javax.swing.JMenuItem accountsPageButton;
    private javax.swing.JComboBox<String> accountsPageComboBox;
    private javax.swing.JScrollPane accountsPageHelpPane;
    private javax.swing.JTextArea accountsPageHelpTextArea;
    private javax.swing.JPanel accountsPagePanel;
    private javax.swing.JLabel accountsPagePanelTitle;
    private javax.swing.JTable accountsPageTable;
    private javax.swing.JButton accountsPageTitleButton;
    private javax.swing.JPanel accountsPageTitlePanel;
    private javax.swing.JScrollPane accountsPageTableScrollPane;
    private javax.swing.JPanel accountsPageTablePanel;

    private javax.swing.JScrollPane budgetsPageBriefingScrollPane;
    private javax.swing.JTextArea budgetsPageBriefingTextArea;
    private javax.swing.JMenuItem budgetsPageButton;
    private javax.swing.JComboBox<String> budgetsPageComboBox;
    private javax.swing.JTextArea budgetsPageHelpTextArea;
    private javax.swing.JScrollPane budgetsPageHelpScrollPane;
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
    private javax.swing.JScrollPane homePageTextScrollPane;

    private javax.swing.JMenuItem loansPageButton;
    private javax.swing.JComboBox<String> loansPageComboBox;
    private javax.swing.JPanel loansPagePanel;
    private javax.swing.JPanel loansPageTitlePanel;
    private javax.swing.JButton loansPageTitleButton;
    private javax.swing.JLabel loansPageTitle;
    private javax.swing.JLabel loanPageLoanInstitutionInfo;
    private javax.swing.JLabel loanPageLoanAmountInfo;
    private javax.swing.JLabel loanPageLoanDateInfo;
    private javax.swing.JLabel loanPageLoanExtraInfo1;
    private javax.swing.JLabel loanPageLoanExtraInfo2;
    private javax.swing.JLabel loanPageLoanExtraInfo3;
    private javax.swing.JLabel loanPageLowPayment;
    private javax.swing.JSlider loanPagePaymentSlider;
    private javax.swing.JLabel loanPageHighPayment;
    private javax.swing.JPanel loansPageTablePanel;
    private javax.swing.JTextArea loansPageHelpTextArea;
    private javax.swing.JScrollPane loansPageHelpScrollPane;

    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu pagesButton;
    private javax.swing.JMenuItem quitButton;

    private javax.swing.JTextArea spendingsPageBriefingArea;
    private javax.swing.JScrollPane spendingsPageBriefingScrollArea;
    private javax.swing.JMenuItem spendingsPageButton;
    private javax.swing.JComboBox<String> spendingsPageComboBox;
    private javax.swing.JPanel spendingsPageGraphPanel;
    private javax.swing.JTextArea spendingsPageHelpArea;
    private javax.swing.JPanel spendingsPagePanel;
    private javax.swing.JScrollPane spendingsPageHelpScrollArea;
    private javax.swing.JLabel spendingsPageTitle;
    private javax.swing.JButton spendingsPageTitleButton;
    private javax.swing.JPanel spendingsPageTitlePanel;

    private javax.swing.JTabbedPane tabbedPane;

    private javax.swing.JTextArea transactionsPageBriefingArea;
    private javax.swing.JMenuItem transactionsPageButton;
    private javax.swing.JComboBox<String> transactionsPageComboBox;
    private javax.swing.JTextArea transactionsPageHelpArea;
    private javax.swing.JScrollPane transactionsPageHelpScrollArea;
    private javax.swing.JPanel transactionsPagePanel;
    private javax.swing.JScrollPane transactionsPageScrollArea;
    private javax.swing.JTable transactionsPageTable;
    private javax.swing.JPanel transactionsPageTablePanel;
    private javax.swing.JScrollPane transactionsPageTableScrollArea;
    private javax.swing.JLabel transactionsPageTitle;
    private javax.swing.JButton transactionsPageTitleButton;
    private javax.swing.JPanel transactionsPageTitlePanel;

    private javax.swing.JTextArea trendsPageBriefingArea;
    private javax.swing.JScrollPane trendsPageBriefingScrollArea;
    private javax.swing.JMenuItem trendsPageButton;
    private javax.swing.JComboBox<String> trendsPageComboBox;
    private javax.swing.JPanel trendsPageGraphPanel;
    private javax.swing.JTextArea trendsPageHelpArea;
    private javax.swing.JScrollPane trendsPageHelpScrollArea;
    private javax.swing.JPanel trendsPagePanel;
    private javax.swing.JLabel trendsPageTitle;
    private javax.swing.JButton trendsPageTitleButton;
    private javax.swing.JPanel trendsPageTitlePanel;
}
