package org.mvpigs.pigcoin;

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
        System.out.println(transaction.toString());

        /**
         * Crear el blockchain
         * y añadir transacciones que crean moneda
         */

        System.out.println("\n" + "Ver BlockChain" + "\n" + 
                                "=============="        );

        BlockChain bChain = new BlockChain();
        transaction = new Transaction("hash_1", "0", "origin", "wallet_1", 20);
        bChain.addOrigin(transaction);
        transaction = new Transaction("hash_2", "1", "origin", "wallet_2", 10);
        bChain.addOrigin(transaction);

        /**
         * Ver el blockchain
         */

        bChain.sumarize();

        /**
         * Ver la transaccion en una posicion del blockchain
         */

        Integer position = 1;
        System.out.println("\n" + "Ver Transaccion en posicion " + position.toString() + " del BlockChain" + "\n" + 
                                "============================================"        );
        bChain.sumarize(position);

        /**
         * Crear una wallet
         * Generar claves privada y publica de la wallet 
         */

        System.out.println("\n" + "Ver Hashes Clave Privada y Clave Pública" + "\n" + 
                                "========================================"        );

        Wallet wallet = new Wallet();
        // problema al testear Gava desde Junit => hacerlo desde main App
        wallet.setSK("gelpiorama");
        System.out.println("SK = " + wallet.getSK());

        wallet.setAddress("gelpiorama@gmail.com");
        System.out.println("PK = " + wallet.getAddress());

        /**
         * Indicar en la wallet
         * el total de pigcoins que se han enviado,
         * que se han recibido
         * y el balance
         */

        System.out.println("\n" + "Ver el total de pigcoins de una wallet" + "\n" + 
                                  "======================================"        );

        Wallet wallet_1 = new Wallet("feed");
        wallet_1.setAddress_sin_hash("wallet_1");
        wallet_1.loadCoins(bChain);
        System.out.println(wallet_1.toString());

        Wallet wallet_2 = new Wallet("feed");
        wallet_2.setAddress_sin_hash("wallet_2");
        wallet_2.loadCoins(bChain);
        System.out.println(wallet_2.toString());

        /**
         * Cargar en la wallet el total de transacciones recibidas
         * (aquellas que suponen recibir pigcoins)
         * y enviadas (aquellas que envian pigcoins)
         * y mostrarlas
         */

        System.out.println("\n" + "Ver las transacciones entrantes de una wallet" + "\n" + 
                                  "============================================="        );
        wallet_1.loadInputTransactions(bChain);
        System.out.println("Wallet = " + wallet_1.getAddress());
        System.out.println("Transacciones = " + wallet_1.getInputTransactions().toString());

        System.out.println("\n" + "Ver las transacciones enviadas de una wallet" + "\n" + 
                                  "============================================="        );
        wallet_1.loadOutputTransactions(bChain);
        System.out.println("Wallet = " + wallet_1.getAddress());
        System.out.println("Transacciones = " + wallet_1.getOutputTransactions().toString());


        /**
         * Enviar 10 pigcoins de la wallet_1 a la wallet_2 
         */

        wallet_1.sendCoins(wallet_2.getAddress(), 10.2, bChain);


        
    }
}
