package org.mvpigs.pigcoin;

public class Transaction {

    private String hash = null;
    private String prev_hash = null;
    private String PK_sender = null;
    private String PK_recipient = null;
    private double pigcoins = 0d;

    /**
     * Constructores
     */
    public Transaction() {
    };

    public Transaction(String hash, String prev_hash, String pk_sender, String pk_recipient, double pigcoins) {
        this.hash = hash;
        this.prev_hash = prev_hash;
        this.PK_sender = pk_sender;
        this.PK_recipient = pk_recipient;
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
                           "pk_sender = " + this.PK_sender + "\n" +
                           "pk_recipient = " + this.PK_recipient + "\n" +
                           "pigcoins = " + this.pigcoins + "\n");
    }

    public String get_PK_sender() {
        return this.PK_sender;
    }

    public String get_PK_recipient() {
        return this.PK_recipient;
    }

}