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

    public void sumarize(int index) {
        getBlockChain().get(index).sumarize();
    }

    public double[] load(String address) {
        double pigcoinsIn = 0d;
        double pigcoinsOut = 0d;

        for(Transaction transaction : getBlockChain()) {
            if(address.equals(transaction.get_PK_recipient())) {
                    pigcoinsIn = pigcoinsIn + transaction.getPigCoins();
            } else if (address.equals(transaction.get_PK_sender())) {
                pigcoinsOut = pigcoinsOut + transaction.getPigCoins();
            } else {
                continue;
            }
        }

        double[] pigcoins = {pigcoinsIn, pigcoinsOut};
        return pigcoins;
    }
}
