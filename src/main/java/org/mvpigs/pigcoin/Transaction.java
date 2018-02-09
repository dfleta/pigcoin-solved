package org.mvpigs.pigcoin;

import java.security.PublicKey;

public class Transaction {

    private String hash = null;
    private String prev_hash = null;
    private PublicKey pKey_sender = null;
    private PublicKey pKey_recipient = null;
    private double pigcoins = 0d;
    // private double signature = null;

    /**
     * Constructores
     */
    public Transaction() {
    };

    public Transaction(String hash, String prev_hash, PublicKey pKey_sender, PublicKey pKey_recipient, double pigcoins) {
        this.hash = hash;
        this.prev_hash = prev_hash;
        this.pKey_sender = pKey_sender;
        this.pKey_recipient = pKey_recipient;
        this.pigcoins = pigcoins;
    }

    /**
     * Getters y setters
     */

    public double getPigCoins() {
        return this.pigcoins;
    }

    @Override
    public String toString() {
        return "\n" + "hash = "+ this.hash + "\n" + 
                "prev_hash = " + this.prev_hash + "\n" +
                "pKey_sender = " + get_PK_sender().getEncoded() + "\n" +
                "pKey_recipient = " + get_PK_recipient().getEncoded() + "\n" +
                "pigcoins = " + getPigCoins() + "\n";
    }

    public PublicKey get_PK_sender() {
        return this.pKey_sender;
    }

    public PublicKey get_PK_recipient() {
        return this.pKey_recipient;
    }

    public String getHash() {
        return this.hash;
    }

    public String getPrevHash() {
        return this.prev_hash;
    }

}