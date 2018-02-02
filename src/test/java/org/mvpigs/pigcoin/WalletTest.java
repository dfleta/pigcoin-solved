package org.mvpigs.pigcoin;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class WalletTest {

    @Test
    public void constructor_test() {
        Wallet wallet = new Wallet();
        assertNotNull(wallet);
    }

    @Test
    public void generateSk_test() {
        Wallet wallet = new Wallet();
        // problema al testear Gava desde Junit => hacerlo desde main App
        // wallet.generateSk("gelpiorama@gmail.com");
    }
}