package com.RSASignature;

import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class RSAVerify {
    public static void main(String[] args) throws Exception{
        PublicKey publicKey =CryptoUtils.getPublicKeyFromCertificate("certificate.cert");
        String receivedDocSign = "Message en claire"+"-__-"+"U+gukOQ60sQ3Pf9/MElrJ0SHDPmnTR2hzK01lF79U6qzrazCCHF6i96n0djT7eltk/QQuXSArYiUwI+y6lASwPHFm/5BH99xh/mk7EDOvH7gwstUjTvu6auKaX3yY8QQJov2jtwQkqAVZ8RCnJauUuCXSHvbJ9l+eNx3KxrHK4ZFnpmN1bJU/MuajvTmFARnxTje3OA5SxryN35wK/FziyIVZIcGCMOZwHsOjgIHQAfo0XmhmdTyqGDuGTHHIEbLHwMkz395hhVO9bu6VIr01S8DSLDj31gPx4q38GRdK6WUFLIlh4UKEHIPfd7Tobwum6fpoDQAYFUmFq/+z0DRiw==";
        String [] splitedDoc= receivedDocSign.split("-__-");
        String receivedSignature=splitedDoc[1];
        String receiveDoc=splitedDoc[0];
        Signature signature1=Signature.getInstance("SHA256withRSA");
        signature1.initVerify(publicKey);
        signature1.update(receiveDoc.getBytes());
        byte[] decodeSign= Base64.getDecoder().decode(receivedSignature);
        boolean verify=signature1.verify(decodeSign);
        System.out.println(verify?"Signature OK" : "Signature Non OK");
    }

}
