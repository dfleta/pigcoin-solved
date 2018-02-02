package org.mvpigs.pigcoin;

public class Transaction {

    String hash = null;
    String prev_hash = null;
    String pk_sender = null;
    String pk_recipient = null;
    double pigcoins = 0d;

    /**
     * Constructores
     */
    public Transaction() {
    };

    public Transaction(String hash, String prev_hash, String pk_sender, String pk_recipient, double pigcoins) {
        this.hash = hash;
        this.prev_hash = prev_hash;
        this.pk_sender = pk_sender;
        this.pk_recipient = pk_recipient;
        this.pigcoins = pigcoins;
    }

    /**
     * Getters y setters
     */

    public double getPigCoins() {
        return this.pigcoins;
    }

    public void sumarize() {
        System.out.println("\n" + "hash = "+ this.hash + "\n" + 
                           "prev_hash = " + this.prev_hash + "\n" +
                           "pk_sender = " + this.pk_sender + "\n" +
                           "pk_recipient = " + this.pk_recipient + "\n" +
                           "pigcoins = " + this.pigcoins + "\n");
    }
}