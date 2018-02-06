package org.mvpigs.pigcoin;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Wallet {

    private String address = null;
    private String SK = null;
    private double total_input = 0d;
    private double total_output = 0d;
    private double balance = 0d;
    private List<Transaction> transactions = null;

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

    // solo a efectos de testing => eliminar al hacer key pair
    public void setAddress_sin_hash(String address_sin_hash) {
        this.address = address_sin_hash;
    }

    public void setAddress(String feed) {
        this.address = generateKey(feed);
    }

    public String getAddress() {
        return this.address;
    }

    public void setTotalInput(double total_input) {
        this.total_input = total_input;
    }

    public double getTotalInput() {
        return this.total_input;
    }

    public void setTotalOutput(double total_output) {
        this.total_output = total_output;
    }

    public double getTotalOutput() {
        return this.total_output;
    }

    public double getBalance() {
		return this.balance;
	}

	public void updateBalance() {
		this.balance = this.getTotalInput() - this.getTotalOutput();
    }
    
    public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
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

    public void loadCoins(BlockChain bChain) {
        double[] pigcoins = {0d, 0d};
        pigcoins = bChain.load(getAddress());
        setTotalInput(pigcoins[0]);
        setTotalOutput(pigcoins[1]);
        updateBalance();
    }

    public void loadInputTransactions(BlockChain bChain) {
        setTransactions(bChain.loadInputTransactions(getAddress()));        
    }

    @Override
    public String toString() {
        return "\n" + "Wallet = " + getAddress() + "\n" + 
                      "Total input = " + getTotalInput() + "\n" +
                      "Total output = " + getTotalOutput() + "\n" +
                      "Balance = " + getBalance() + "\n";
    }

}