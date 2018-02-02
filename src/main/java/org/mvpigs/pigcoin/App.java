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
        transaction = new Transaction("hash_1", "0", "origin", "wallet_1", 20);
        transaction.sumarize();

        System.out.print("\n" + "Ver BlockChain" + "\n" + 
                                "=============="        );

        BlockChain bChain = new BlockChain();
        bChain.addOrigin(transaction);
        bChain.sumarize();

        System.out.print("\n" + "Ver Transaccion en posicion 0 del BlockChain" + "\n" + 
                                "=============="        );
        bChain.sumarize(0);


    }
}
