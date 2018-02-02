package org.mvpigs.pigcoin;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /**
         * Crear una transaccion
         */

        System.out.print("\n" + "Ver transaccion" + "\n" +
                                "==============="        );

        Transaction transaction = new Transaction();
        transaction = new Transaction("hash_1", "0", "aaaaaaaa", "0", 20);
        transaction.sumarize();

        System.out.print("\n" + "Ver BlockChain" + "\n" + 
                                "=============="        );

        BlockChain bChain = new BlockChain();
        transaction = new Transaction("hash_1", "0", "origin", "wallet_1", 20);
        bChain.addOrigin(transaction);
        transaction = new Transaction("hash_2", "1", "origin", "wallet_2", 10);
        bChain.addOrigin(transaction);

        bChain.sumarize();

        System.out.print("\n" + "Ver Transaccion en posicion 0 del BlockChain" + "\n" + 
                                "=============="        );
        bChain.sumarize(0);


    }
}
