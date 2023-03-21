package com.CryptAsymetrique;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class RSACrypt {
    public static void main(String[] args) throws Exception {

        KeyFactory keyFactory=KeyFactory.getInstance("RSA");
        String encodedPublicKey="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIaGOWnYQdCT+Z60xPhcJ1kszajGYfBi+H31OolcQQiRabF+8awcLwnnfEWAJ8DkGwAlj9UQ+GjrWv1F5jt3qXkCAwEAAQ==";

        byte[] decodedPuK = Base64.getDecoder().decode(encodedPublicKey);
        PublicKey publicKey= keyFactory.generatePublic(new X509EncodedKeySpec(decodedPuK));

        String message="Message en claire";
        Cipher cipher=Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        byte[] encryptedMsg = cipher.doFinal(message.getBytes());
        String encodedMsg=Base64.getEncoder().encodeToString(encryptedMsg);
        System.out.println(encodedMsg);

    }
}
