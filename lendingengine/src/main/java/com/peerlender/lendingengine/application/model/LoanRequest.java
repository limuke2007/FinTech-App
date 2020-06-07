package com.peerlender.lendingengine.application.model;

import java.util.Objects;

public class LoanRequest {

    private final int amount;
    private final int daysToRepay;
    private final double interestRate;

    public LoanRequest(int amount, int daysToRepay, double interestRate) {
        this.amount = amount;
        this.daysToRepay = daysToRepay;
        this.interestRate = interestRate;
    }

    public int getAmount() {
        return amount;
    }

    public int getDaysToRepay() {
        return daysToRepay;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanRequest that = (LoanRequest) o;
        return amount == that.amount &&
                daysToRepay == that.daysToRepay &&
                Double.compare(that.interestRate, interestRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, daysToRepay, interestRate);
    }

    @Override
    public String toString() {
        return "LoanRequest{" +
                "amount=" + amount +
                ", borrowerId=" +
                ", daysToRepay=" + daysToRepay +
                ", interestRate=" + interestRate +
                '}';
    }
}
