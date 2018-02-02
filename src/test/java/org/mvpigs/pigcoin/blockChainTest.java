package org.mvpigs.pigcoin;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class blockChainTest {

    @Test
    public void construnctorTest() {
        BlockChain bc = new BlockChain();
        assertNotNull(bc);
    }

}