package org.mvpigs.pigcoin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;
import javax.swing.text.TabableView;

import org.junit.Test;

public class BlockChainTest {

    @Test
    public void constructorTest() {
        BlockChain bc = new BlockChain();
        assertNotNull(bc);
    }

    @Test
    public void addOriginTransaction() {
        BlockChain bc = new BlockChain();
        Transaction transaction = new Transaction();
        transaction = new Transaction("hash_1", "0", "origin", "wallet_1", 20);
        bc.addOrigin(transaction);
        assertEquals(20, bc.getBlockChain().get(0).getPigCoins(), 0);
    }

    @Test
    public void load_Input_Transactions_test() {

        BlockChain bChain = new BlockChain();
        Transaction transaction = new Transaction("hash_1", "0", "origin", "wallet_1", 20);
        bChain.addOrigin(transaction);
        transaction = new Transaction("hash_2", "1", "origin", "wallet_2", 10);
        bChain.addOrigin(transaction);

        List<Transaction> inputTransactions = bChain.loadInputTransactions("wallet_1");
        assertNotNull(inputTransactions);
        assertTrue(inputTransactions.size() == 1);
        assertFalse(inputTransactions.contains(transaction));

        inputTransactions = bChain.loadInputTransactions("wallet_2");
        assertNotNull(inputTransactions);
        assertTrue(inputTransactions.size() == 1);
        assertTrue(inputTransactions.contains(transaction));

        inputTransactions = bChain.loadInputTransactions("wallet_3");
        assertNotNull(inputTransactions);
        assertTrue(inputTransactions.size() == 0);
        assertFalse(inputTransactions.contains(transaction));
    }
}