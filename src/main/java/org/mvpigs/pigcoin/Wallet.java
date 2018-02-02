package org.mvpigs.pigcoin;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
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

    public Wallet() {
    };

    public Wallet(String gmail) {
        setSk(gmail);
    };

    /**
     * Getter y Setters
     */

    public void setSk(String sk) {
        this.sk = sk;
    }

    public String getSk() {
        return this.sk;
    }

    /**
     * Logica
     */

    public void generateSk(String gmail) {
        String sha256hex = Hashing.sha256()
                                  .hashString(gmail, StandardCharsets.UTF_8)
                                  .toString();
        setSk(sha256hex);
    }


}