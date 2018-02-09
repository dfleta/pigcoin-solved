package org.mvpigs.pigcoin;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

public class GenSig {

    /**
     * Generamos el par de clave pública PK
     * y clave privada SK
     * La clave pública PK es la dirección pública de la Wallet
     * La clave privada SK es necesaria para firmar los mensajes 
     */

    public static KeyPair generateKeyPair() {
        try {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        // key length 2048
        // Cryptographically strong random number generator (RNG)
        generator.initialize(2048, new SecureRandom());
        KeyPair pair = generator.generateKeyPair();
        PrivateKey SK = pair.getPrivate();
        PublicKey PK = pair.getPublic();
        return pair;
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}