/*ATM System Manual

The ATM System simulates a basic Automated Teller Machine interface. It allows users to perform various banking operations such as logging in, checking transaction history, withdrawing, depositing, transferring funds, and quitting the session.

Getting Started:

Upon launching the application, the initial screen displays the name of the bank, "Bank of India," at the top. Below the bank name, there's a login button.
Logging In:

Click the "Login" button to access the login screen.
Enter the predefined User ID (1234) and PIN (1234) to log in successfully. If the provided credentials match, it will proceed to the main menu.
Main Menu:

After successful login, the main menu appears, displaying options:
Transaction History: View a history of transactions.
Withdraw: Withdraw funds from the account.
Deposit: Deposit funds into the account.
Transfer: Transfer funds to another account.
Quit: Close the session and exit the application.
Functionality:

Transaction History: Displays a window showing past transactions retrieved from a file named "transaction_history.txt".
Withdraw: Allows the user to input an amount to withdraw. It checks for a valid amount and sufficient balance before processing the withdrawal.
Deposit: Provides an interface to input an amount for deposit into the account.
Transfer: Facilitates transferring funds to another account by entering the recipient's User ID and the amount.
Quit: Closes the main menu and ends the session.
Notes:

The system maintains a simple balance of Rs. 1000 for demonstration purposes.
All transaction actions update both the display on the interface and the transaction history file ("transaction_history.txt").
Usage:

Follow the on-screen instructions and button clicks to navigate through the application.
Ensure to input valid amounts and follow the prompts to complete transactions.
Use the "Quit" option to exit the application gracefully.
Additional Information:

This system is a simulation for educational purposes and does not involve real banking operations or connections to any live banking services.
 */




import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

class ATMSystem extends JFrame {
    private String userID = "1234";
    private String pin = "1234";
    private double balance = 1000.0;
    private JTextArea textArea;
    private String bankName = "Bank of India";
    // Define a color scheme

    private Color primaryColor = new Color(227, 147, 43);

    private Color backgroundColor = new Color(213, 206, 237);
    private Color buttonTextColor = Color.WHITE;

    public ATMSystem() {

        System.out.println(
                "------------------------------------------ATM System Started------------------------------------------");

        setTitle("ATM INTERFACE");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(backgroundColor);

        JLabel bankLabel = new JLabel(bankName);
        bankLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Adjust font size and style as needed
        bankLabel.setHorizontalAlignment(JLabel.CENTER); // Center the text horizontally
        panel.add(bankLabel, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(primaryColor);
        loginButton.setForeground(buttonTextColor);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showLoginScreen();
            }
        });

        panel.add(loginButton, BorderLayout.SOUTH);
        panel.setBackground(backgroundColor);
        textArea.setBackground(Color.WHITE);
        textArea.setForeground(Color.BLACK);

        loginButton.setBackground(primaryColor);
        loginButton.setForeground(Color.WHITE);
        getContentPane().add(panel);
    }

    private void showLoginScreen() {
        System.out.println("Kindly Login");
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(300, 150);
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);

        JPanel loginPanel = new JPanel();
        loginFrame.add(loginPanel);
        loginPanel.setLayout(new GridLayout(3, 2));
        JLabel userIDLabel = new JLabel("User ID:");
        userIDLabel.setForeground(primaryColor);

        JTextField userIDField = new JTextField();

        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setForeground(primaryColor);
        loginPanel.setBackground(backgroundColor);

        JPasswordField pinField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(primaryColor);
        loginButton.setForeground(buttonTextColor);

        loginPanel.add(userIDLabel);
        loginPanel.add(userIDField);
        loginPanel.add(pinLabel);
        loginPanel.add(pinField);
        loginPanel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputUserID = userIDField.getText();
                String inputPin = new String(pinField.getPassword());
                if (inputUserID.equals(userID) && inputPin.equals(pin)) {
                    showMainMenu();
                    loginFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid User ID or PIN", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        loginFrame.setVisible(true);
    }

    private void showMainMenu() {
        System.out.println("Displaying Main Menu");
        System.out.println("Kindly Choose any of the following:");
        System.out.println("1. Transaction History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");

        JFrame mainMenuFrame = new JFrame("Main Menu");
        mainMenuFrame.setSize(400, 300);
        mainMenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainMenuFrame.setLocationRelativeTo(null);

        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(new GridLayout(5, 1));
        mainMenuPanel.setBackground(backgroundColor);

        JButton transactionHistoryButton = new JButton("Transactions History");
        transactionHistoryButton.setBackground(primaryColor);
        transactionHistoryButton.setForeground(buttonTextColor);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBackground(primaryColor);
        withdrawButton.setForeground(buttonTextColor);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBackground(primaryColor);
        depositButton.setForeground(buttonTextColor);

        JButton transferButton = new JButton("Transfer");
        transferButton.setBackground(primaryColor);
        transferButton.setForeground(buttonTextColor);

        JButton quitButton = new JButton("Quit");
        quitButton.setBackground(primaryColor);
        quitButton.setForeground(buttonTextColor);

        mainMenuPanel.add(transactionHistoryButton);
        mainMenuPanel.add(withdrawButton);
        mainMenuPanel.add(depositButton);
        mainMenuPanel.add(transferButton);
        mainMenuPanel.add(quitButton);

        mainMenuFrame.add(mainMenuPanel);
        mainMenuFrame.setVisible(true);
        transactionHistoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showTransactionHistory();
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showWithdrawScreen();
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDepositScreen();
            }
        });

        transferButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showTransferScreen();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenuFrame.dispose();
            }
        });

        mainMenuFrame.setVisible(true);
    }

    private void showTransactionHistory() {

        System.out.println("Displaying Transaction History -->");
        JFrame historyFrame = new JFrame("Transaction History");
        historyFrame.setSize(400, 300);
        historyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        historyFrame.setLocationRelativeTo(null);

        JPanel historyPanel = new JPanel();
        historyFrame.add(historyPanel);
        historyPanel.setLayout(new BorderLayout());
        historyPanel.setLayout(new BorderLayout());
        historyPanel.setBackground(backgroundColor);

        JTextArea historyTextArea = new JTextArea();
        historyTextArea.setEditable(false);

        try (BufferedReader br = new BufferedReader(new FileReader("transaction_history.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                historyTextArea.append(line + "\n");
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(historyTextArea);
        historyPanel.add(scrollPane, BorderLayout.CENTER);

        historyFrame.setVisible(true);
    }

    private void showWithdrawScreen() {
        System.out.println("Displaying Withdrawals -->");
        JFrame withdrawFrame = new JFrame("Withdraw");
        withdrawFrame.setSize(300, 150);
        withdrawFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        withdrawFrame.setLocationRelativeTo(null);

        JPanel withdrawPanel = new JPanel();
        withdrawFrame.add(withdrawPanel);
        withdrawPanel.setLayout(new GridLayout(2, 2));
        withdrawPanel.setBackground(backgroundColor);

        JLabel amountLabel = new JLabel("Enter Amount:");
        amountLabel.setForeground(primaryColor);
        JTextField amountField = new JTextField();
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBackground(primaryColor);
        withdrawButton.setForeground(buttonTextColor);

        withdrawPanel.add(amountLabel);
        withdrawPanel.add(amountField);
        withdrawPanel.add(withdrawButton);

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    if (amount > 0 && amount <= balance) {
                        balance -= amount;
                        updateTransactionHistory("Withdraw: Rs." + amount);
                        JOptionPane.showMessageDialog(null, "Withdrawal Successful!");
                        System.out.println("Withdrawal Successful!");
                        withdrawFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Amount or Insufficient Balance", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        System.out.println("Invalid Amount or Insufficient Balance");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Amount", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Invalid Amount");
                }
            }
        });

        withdrawFrame.setVisible(true);
    }

    private void showDepositScreen() {
        System.out.println("Deposit procedure Starteed -->");

        JFrame depositFrame = new JFrame("Deposit");
        depositFrame.setSize(300, 150);
        depositFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        depositFrame.setLocationRelativeTo(null);

        JPanel depositPanel = new JPanel();
        depositFrame.add(depositPanel);
        depositPanel.setLayout(new GridLayout(2, 2));
        depositPanel.setBackground(backgroundColor);

        JLabel amountLabel = new JLabel("Enter Amount:");
        amountLabel.setForeground(primaryColor);
        JTextField amountField = new JTextField();
        JButton depositButton = new JButton("Deposit");
        depositButton.setBackground(primaryColor);
        depositButton.setForeground(buttonTextColor);

        depositPanel.add(amountLabel);
        depositPanel.add(amountField);
        depositPanel.add(depositButton);

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    if (amount > 0) {
                        balance += amount;
                        updateTransactionHistory("Deposit: Rs." + amount);
                        JOptionPane.showMessageDialog(null, "Deposit Successful!");
                        System.out.println("Deposit Successful");
                        depositFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Amount", "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("Invalied Amount");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Amount", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Invalid Amount");
                }
            }
        });

        depositFrame.setVisible(true);
    }

    private void showTransferScreen() {
        System.out.println("Transfer Procedure Started -->");
        JFrame transferFrame = new JFrame("Transfer");
        transferFrame.setSize(300, 150);
        transferFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        transferFrame.setLocationRelativeTo(null);

        JPanel transferPanel = new JPanel();
        transferFrame.add(transferPanel);
        transferPanel.setLayout(new GridLayout(3, 2));
        transferPanel.setBackground(backgroundColor);

        JLabel recipientLabel = new JLabel("Recipient's User ID:");
        recipientLabel.setForeground(primaryColor);
        JTextField recipientField = new JTextField();
        JLabel amountLabel = new JLabel("Enter Amount:");
        amountLabel.setForeground(primaryColor);
        JTextField amountField = new JTextField();
        JButton transferButton = new JButton("Transfer");
        transferButton.setBackground(primaryColor);
        transferButton.setForeground(buttonTextColor);

        transferPanel.add(recipientLabel);
        transferPanel.add(recipientField);
        transferPanel.add(amountLabel);
        transferPanel.add(amountField);
        transferPanel.add(transferButton);

        transferButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String recipientID = recipientField.getText();
                    double amount = Double.parseDouble(amountField.getText());
                    if (amount > 0 && amount <= balance) {
                        balance -= amount;
                        updateTransactionHistory("Transfer: Rs." + amount + " to User ID: " + recipientID);
                        JOptionPane.showMessageDialog(null, "Transfer Successful!");
                        System.out.println("Transfer Successful!");
                        transferFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Amount or Insufficient Balance", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        System.out.println("Invalid Amount or Insufficient Balance");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Amount", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Invalid Amount");
                }
            }
        });

        transferFrame.setVisible(true);
    }

    private void updateTransactionHistory(String transaction) {
        textArea.append(transaction + "\n");
        try (FileWriter writer = new FileWriter("transaction_history.txt", true)) {
            writer.write(transaction + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ATMSystem().setVisible(true);
            }
        });
    }
}
