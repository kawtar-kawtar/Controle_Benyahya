package com.CryptAsymetrique;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class RSADecrypt {
    public static void main(String[] args) throws Exception {
        String encodedCryptedMsg="IWpENvhGWRPmyb/x7CSq/hHx95dtkazAbn4bcFvyK7eThpVyqZJevHURrLZKKynUxlhTXi1wTpYShWQawwArKQ==";
        byte[] decodedMsg=Base64.getDecoder().decode(encodedCryptedMsg);
        String encodedPrivateKey = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAhoY5adhB0JP5nrTE+FwnWSzNqMZh8GL4ffU6iVxBCJFpsX7xrBwvCed8RYAnwOQbACWP1RD4aOta/UXmO3epeQIDAQABAkAWWnNr3R2ClTQjZRJd2qJHNSSvaNeZZDi6ZWdmr8e2roNtCGwwMpYfnZhWfzfLCmdA4KgOUZ9+aUYNHEVdPpUhAiEA7mnnl+6b24jlqsf7tqcZcDjM8aIWnA8YzP+BN7u0GB0CIQCQcoUgdezgr+Nmewk1AjtzXTvqn6N69QzLzsrIUnEwDQIgPzYVEVNSP4KsYftj4amsNPTaYbZ4CCh4iuGzgPNjbIECIDwznoxi2bDjXZEuoi23mnOAXiJxGj96tjSTISzQP2BZAiEA5rriWgN/zrka22yHtr3Av5d/6Kr7PwJmNBKZWQ6Ti/w=";
        byte[] decodedPrivateKey=Base64.getDecoder().decode(encodedPrivateKey);
        KeyFactory keyFactory=KeyFactory.getInstance("RSA");
        PrivateKey privateKey= keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decodedPrivateKey));

        Cipher cipher1=Cipher.getInstance("RSA");
        cipher1.init(Cipher.DECRYPT_MODE,privateKey);
        byte[] decryptedMsg = cipher1.doFinal(decodedMsg);

        System.out.println(new String(decryptedMsg));
    }
}
