package org.mvpigs.pigcoin;

import java.util.ArrayList;

public class BlockChain {

    ArrayList<Transaction> blockChain = new ArrayList<Transaction>();

    /**
     * Constructor
     */

    public BlockChain() {
    };

    /**
     * Getters y setters
     */

     public ArrayList<Transaction> getBlockChain() {
         return this.blockChain;
     }

    /**
     * Logica
     */

    public void addOrigin(Transaction transaction) {
        this.getBlockChain().add(transaction);
    }

    public void sumarize(){
        for(Transaction transaction : getBlockChain()) {
            transaction.sumarize();
        }
    }
}
