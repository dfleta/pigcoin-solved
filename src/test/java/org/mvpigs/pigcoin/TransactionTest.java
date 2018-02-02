package org.mvpigs.pigcoin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TransactionTest {

    /**
     * Crear clase transaction
     */
    @Test
    public void constructor_test() {
        
        Transaction transaction = new Transaction();
        assertNotNull(transaction);

        transaction = new Transaction("hash_1", "0", "aaaaaaaa", "0", 20);
        assertNotNull(transaction);
        assertEquals(20, transaction.getPigCoins(), 0);
    }



}