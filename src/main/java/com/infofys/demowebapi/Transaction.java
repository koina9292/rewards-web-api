package com.infofys.demowebapi;

/**
 * Stores customer identifier along with the associated transaction amount and date
 */
public class Transaction {
    private final String customerId;
    private final double amount;
    private final String date; // format: YYYY-MM-DD

    public Transaction(String customerId, double amount, String date) {
        this.customerId = customerId;
        this.amount = amount;
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
}
