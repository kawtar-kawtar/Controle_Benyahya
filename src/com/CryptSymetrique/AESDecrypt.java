package com.CryptSymetrique;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AESDecrypt {
    public static void main(String[] args) throws Exception {

        String encryptedMsg="/WM8cMF/po2r3aQuWbd1Zm/ZNKRWxmES6u5RRmDdh4o=";
        byte[] encodedEncryptedMsg = Base64.getDecoder().decode(encryptedMsg);
        String secret="1234567891452369";
        SecretKey secretKey=new SecretKeySpec(secret.getBytes(),0,secret.length(),"AES");
        Cipher cipher =Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        byte[] decryptMsg= cipher.doFinal(encodedEncryptedMsg);
        System.out.println(new String(decryptMsg));
    }
}
