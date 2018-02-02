package org.mvpigs.pigcoin;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

public class App {

    public static void main( String[] args )
    {
        /**
         * Crear una transaccion
         */

        System.out.println("\n" + "Ver transaccion" + "\n" +
                                "==============="        );

        Transaction transaction = new Transaction();
        transaction = new Transaction("hash_1", "0", "aaaaaaaa", "0", 20);
        transaction.sumarize();


        System.out.println("\n" + "Ver BlockChain" + "\n" + 
                                "=============="        );

        BlockChain bChain = new BlockChain();
        transaction = new Transaction("hash_1", "0", "origin", "wallet_1", 20);
        bChain.addOrigin(transaction);
        transaction = new Transaction("hash_2", "1", "origin", "wallet_2", 10);
        bChain.addOrigin(transaction);

        bChain.sumarize();


        System.out.println("\n" + "Ver Transaccion en posicion 0 del BlockChain" + "\n" + 
                                "============================================"        );
        bChain.sumarize(0);

        System.out.println("\n" + "Ver Hashes Clave Privada y Clave Pública" + "\n" + 
                                "========================================"        );

        Wallet wallet = new Wallet();
        // problema al testear Gava desde Junit => hacerlo desde main App
        wallet.setSK("gelpiorama");
        System.out.println("SK = " + wallet.getSK());

        wallet.setAddress("gelpiorama@gmail.com");
        System.out.println("PK = " + wallet.getAddress());

    }
}
