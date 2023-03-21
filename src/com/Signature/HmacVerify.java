package com.Signature;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HmacVerify {
    public static void main(String[] args) throws Exception {
        System.out.println("***************** Verify Signature -------------");
        String receivedDoc="Message en claire"+"-__-"+"Wb9+jicrA7eJuG06Qt3WQAyhA7k7xah7h0ZsJelXNx4=";
        String [] splitedDoc= receivedDoc.split("-__-");
        String receivedSignature=splitedDoc[1];
        String document=splitedDoc[0];
        String secret1="123456";
        SecretKeySpec secretKeySpec1=new SecretKeySpec(secret1.getBytes(),"HmacSHA256");
        Mac mac1=Mac.getInstance("HmacSHA256");
        mac1.init(secretKeySpec1);
        byte[] signature1 = mac1.doFinal(document.getBytes());
        String encodedSignature= Base64.getEncoder().encodeToString(signature1);

        //comparer:

        System.out.println(receivedSignature.equals(encodedSignature)?"Signature OK":"Signature non OK");

    }

}
