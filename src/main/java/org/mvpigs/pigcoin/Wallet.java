package org.mvpigs.pigcoin;

import java.util.ArrayList;

public class Wallet {

    private String address = null;
    private String sk = null;
    private double total_input = 0d;
    private double total_output = 0d;
    private double balance = 0d;
    private ArrayList<Transaction> transactions = null;

    /**
     * Constructor
     */

    public void Wallet() {
    };

}