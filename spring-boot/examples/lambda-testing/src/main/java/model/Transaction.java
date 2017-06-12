package model;

/**
 * Created by wanggang on 10/27/16.
 */
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;


    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Trader: " + trader.getName() + " year: " + year + " value: " + value;
    }
}
