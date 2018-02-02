package org.mvpigs.pigcoin;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Wallet {

    private String address = null;
    private String SK = null;
    private double total_input = 0d;
    private double total_output = 0d;
    private double balance = 0d;
    private ArrayList<Transaction> transactions = null;

    /**
     * Constructor
     */

    public Wallet() {
    };

    public Wallet(String feed) {
        setSK(feed);
        setAddress(feed);
    };

    /**
     * Getter y Setters
     */

    public void setSK(String feed) {
        this.SK = generateKey(feed);;
    }

    public String getSK() {
        return this.SK;
    }

    public void setAddress(String feed) {
        this.address = generateKey(feed);
    }

    public String getAddress() {
        return this.address;
    }

    /**
     * Logica
     */

    public String generateKey(String gmail) {
        String sha256hex = Hashing.sha256()
                                  .hashString(gmail, StandardCharsets.UTF_8)
                                  .toString();
        return sha256hex;
    }


}