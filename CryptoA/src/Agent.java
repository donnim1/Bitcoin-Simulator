import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Agent {
    private String identifier;
    private double balance;
    private List<Transaction> transactionHistory;

    public Agent(String identifier) {
        this.identifier = identifier;
        this.balance = 12.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getIdentifier() {
        return identifier;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public boolean sendTransaction(Agent recipient, double amount) {
        if (balance >= amount) {
            balance -= amount;
            recipient.receiveTransaction(amount);
            transactionHistory.add(new Transaction(this, recipient, amount));
            return true; // Transaction successful
        } else {
            return false; // Insufficient balance, transaction failed
        }
    }

    public void receiveTransaction(double amount) {
        balance += amount;
    }

}