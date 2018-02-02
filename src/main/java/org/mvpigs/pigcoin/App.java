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

        System.out.print("\n" + "Crear transaccion" + "\n");

        Transaction transaction = new Transaction();
        transaction = new Transaction("hash_1", "0", "aaaaaaaa", "0", 20);
        transaction.sumarize();
    }
}
