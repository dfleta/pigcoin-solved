package org.mvpigs.pigcoin;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class WalletTest {

    @Test
    public void constructorTest() {
        Wallet wallet = new Wallet();
        assertNotNull(wallet);
    }
}