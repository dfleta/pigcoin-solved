package org.mvpigs.pigcoin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WalletTest {

    @Test
    public void constructor_test() {
        Wallet wallet = new Wallet();
        assertNotNull(wallet);
    }

    @Test
    public void generateSk_test() {
        // problema al testear Gava desde Junit => hacerlo desde main App
        // wallet.generateSk("gelpiorama@gmail.com");
    }

    @Test
    public void constructor_arguments_test() {
        Wallet wallet = new Wallet("feed");
        assertNotNull(wallet);
    }

    @Test
    public void total_pigcoins_input_y_output_test() {

        BlockChain bChain = new BlockChain();
        Transaction transaction = new Transaction("hash_1", "0", "origin", "wallet_1", 20);
        bChain.addOrigin(transaction);
        transaction = new Transaction("hash_2", "1", "origin", "wallet_2", 10);
        bChain.addOrigin(transaction);

        Wallet wallet = new Wallet("feed");
        wallet.setAddress_sin_hash("wallet_1");
        wallet.loadCoins(bChain);
        assertEquals(20, wallet.getTotalInput(), 0);
        assertEquals(0, wallet.getTotalOutput(), 0);
        assertEquals(20, wallet.getBalance(), 0);

        wallet = new Wallet("feed");
        wallet.setAddress_sin_hash("wallet_2");
        wallet.loadCoins(bChain);
        assertEquals(10, wallet.getTotalInput(), 0);
        assertEquals(0, wallet.getTotalOutput(), 0);
        assertEquals(10, wallet.getBalance(), 0);

        // una wallet que no existe
        wallet.setAddress_sin_hash("wallet_3");
        wallet.loadCoins(bChain);
        assertEquals(0, wallet.getTotalInput(), 0);
        assertEquals(0, wallet.getTotalOutput(), 0);
        assertEquals(0, wallet.getBalance(), 0);
    }

    @Test
    public void enviar_transaccion_test() {

        BlockChain bChain = new BlockChain();
        Transaction transaction = new Transaction("hash_1", "0", "origin", "wallet_1", 20);
        bChain.addOrigin(transaction);
        transaction = new Transaction("hash_2", "1", "origin", "wallet_2", 10);
        bChain.addOrigin(transaction);

        Wallet wallet = new Wallet("feed");
        wallet.setAddress_sin_hash("wallet_1");
        wallet.loadCoins(bChain);
        assertEquals(20, wallet.getTotalInput(), 0);
        assertEquals(0, wallet.getTotalOutput(), 0);
        assertEquals(20, wallet.getBalance(), 0);
    }

    @Test
    public void load_input_transactions_test() {

        BlockChain bChain = new BlockChain();
        Transaction transaction = new Transaction("hash_1", "0", "origin", "wallet_1", 20);
        bChain.addOrigin(transaction);
        transaction = new Transaction("hash_2", "1", "origin", "wallet_2", 10);
        bChain.addOrigin(transaction);

        Wallet wallet = new Wallet("feed");
        wallet.setAddress_sin_hash("wallet_1");
        wallet.loadInputTransactions(bChain);
        assertTrue(wallet.getTransactions().size() == 1);

        wallet = new Wallet("feed");
        wallet.setAddress_sin_hash("wallet_2");
        wallet.loadInputTransactions(bChain);
        assertTrue(wallet.getTransactions().size() == 1);

        wallet = new Wallet("feed");
        wallet.setAddress_sin_hash("wallet_3");
        wallet.loadInputTransactions(bChain);
        assertTrue(wallet.getTransactions().size() == 0);
    }
}