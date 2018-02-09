package org.mvpigs.pigcoin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BlockChain {

    List<Transaction> blockChain = new ArrayList<Transaction>();

    /**
     * Constructor
     */

    public BlockChain() {
    };

    /**
     * Getters y setters
     */

     public List<Transaction> getBlockChain() {
         return this.blockChain;
     }

    /**
     * Logica
     */

    public void addOrigin(Transaction transaction) {
        this.getBlockChain().add(transaction);
    }

    public void summarize(){
        for(Transaction transaction : getBlockChain()) {
            System.out.println(transaction.toString());
        }
    }

    public void summarize(int index) {
        System.out.println(getBlockChain().get(index).toString());
    }

    public double[] loadWallet(String address) {

        double pigcoinsIn = 0d;
        double pigcoinsOut = 0d;

        Set<String> consumedCoins = new HashSet<>();

        for (Transaction transaction : getBlockChain()) {

            if(address.equals(transaction.get_PK_recipient())) {
                    pigcoinsIn = pigcoinsIn + transaction.getPigCoins();
            }
            if (address.equals(transaction.get_PK_sender())) {
                pigcoinsOut = pigcoinsOut + transaction.getPigCoins();
            }
        }

        double[] pigcoins = {pigcoinsIn, pigcoinsOut};
        return pigcoins;
    }

    public List<Transaction> loadInputTransactions(String address) {
   
        List<Transaction> inputTransactions = getBlockChain().stream()
            .filter(transaction -> transaction.get_PK_recipient().equals(address))
            .collect(Collectors.toCollection(ArrayList<Transaction>::new));
        
        return inputTransactions;
    }

    public List<Transaction> loadOutputTransactions(String address) {
   
        List<Transaction> outputTransactions = getBlockChain().stream()
            .filter(transaction -> transaction.get_PK_sender().equals(address))
            .collect(Collectors.toCollection(ArrayList<Transaction>::new));
        
        return outputTransactions;
    }

    public boolean isSignatureValid(String Signature) {
        return true;
    }

    public boolean isConsumedCoinValid(Map<String, Double> consumedCoins) {
        for (String hash : consumedCoins.keySet()) {
            for (Transaction transaction : blockChain) {
                if (hash.equals(transaction.getPrevHash())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void createTransaction(String PK_sender, String PK_recipient, Map<String, Double> consumedCoins,
            String signature) {

        String address_recipient = PK_recipient;
        Integer lastBlock = 0;
        for (String prev_hash : consumedCoins.keySet()) {
            if (prev_hash.startsWith("CA_")) {
                PK_recipient = PK_sender;
            }
            lastBlock = blockChain.size() + 1;
            Transaction transaction = new Transaction("hash_" + lastBlock.toString(), prev_hash, PK_sender,
                    PK_recipient, consumedCoins.get(prev_hash));
            // falta añadir la signature
            getBlockChain().add(transaction);
            PK_recipient = address_recipient;
        }
    }

    public void processTransactions(String PK_sender, String PK_recipient, Map<String, Double> consumedCoins,
            String signature) {
        
        if (isSignatureValid(signature) && isConsumedCoinValid(consumedCoins)) {
            // crear las nuevas transacciones y añadirlas al blockchain
            createTransaction(PK_sender, PK_recipient, consumedCoins, signature);
        }

    }


}
