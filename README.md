# Java-ATM-GUI
ATM System: Java-based GUI  Simulated ATM interface in Java Swing. Secure login, transaction history, withdrawals, deposits, fund transfers, and session control. Emphasizes secure coding and user interaction.
ATM System

This Java-based ATM System simulates the functionalities of an Automated Teller Machine, offering users a graphical interface to perform various banking operations securely. The system includes features for secure login authentication, transaction history display, fund withdrawals, deposits, fund transfers, and session management. Developed using Java's Swing for the user interface and File I/O for transaction history management, this project emphasizes secure coding practices, error handling, and a user-friendly interface.

Key Features:

Secure login with predefined User ID and PIN verification
Transaction history retrieval from a file ("transaction_history.txt")
Withdrawal and deposit functionalities with validation checks
Secure fund transfer option between accounts
Smooth session exit functionality
Purpose:
This project serves as an educational tool for understanding Java GUI development, user authentication, file handling, and transaction processing. It emphasizes secure design principles while providing a platform for experimentation and learning in software development.

Feel free to explore, contribute, and enhance the project to expand its capabilities and explore new functionalities.

#Java #Swing #BankingSystem #FileIO #SecureCoding




ATM System Manual

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
