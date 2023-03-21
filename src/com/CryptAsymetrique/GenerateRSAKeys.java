package com.CryptAsymetrique;

import java.security.*;
import java.util.Arrays;
import java.util.Base64;

public class GenerateRSAKeys {
    public static KeyPair generateKeyPair() throws Exception{
        KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);
        return keyPairGenerator.generateKeyPair();
    }
    public static void main(String[] args) throws Exception {
       KeyPair keyPair=generateKeyPair();

        //Public Key :
        PublicKey publicKey= keyPair.getPublic();
        String encodedPublicKey= Base64.getEncoder().encodeToString(publicKey.getEncoded());


        //Private key :
        PrivateKey privateKey=keyPair.getPrivate();
        String encodedPrivateKey= Base64.getEncoder().encodeToString(privateKey.getEncoded());

        //Affichage de clé publique :

        System.out.println("-----------------------------Clé publique -------------------------------");
        System.out.println(encodedPublicKey);


        //Affichage de clé privée :

        System.out.println("-----------------------------Clé privée -------------------------------");
        System.out.println(encodedPrivateKey);
    }

}
