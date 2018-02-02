package org.mvpigs.pigcoin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.swing.text.TabableView;

import org.junit.Test;

public class blockChainTest {

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

}