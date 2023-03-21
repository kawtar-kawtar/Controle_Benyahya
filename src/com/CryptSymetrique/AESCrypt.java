package com.CryptSymetrique;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AESCrypt {
    public static void main(String[] args) throws Exception {
        String message="Message en claire";
        String secret="1234567891452369";
        SecretKey secretKey=new SecretKeySpec(secret.getBytes(),0,secret.length(),"AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        byte[] encriptMsg = cipher.doFinal(message.getBytes());
        String encodedEncriptedMsg = Base64.getEncoder().encodeToString(encriptMsg);
        System.out.println(encodedEncriptedMsg);
    }
}
