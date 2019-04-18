package com.example.crypt.rsa;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @ClassName jdkRSA
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/2 0002 17:11
 * @Version 1.0
 **/
public class jdkRSA {
    private static String src="wufei zhen shuai";
    public static void main(String[] args) throws Exception {
        jdkdeRSA();
    }

    private static void jdkdeRSA() throws Exception{
        //1初始化密钥
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rsaPublicKey=(RSAPublicKey)keyPair.getPublic();
        RSAPrivateKey rsaPrivateKey=(RSAPrivateKey)keyPair.getPrivate();
        byte[] encoded = rsaPublicKey.getEncoded();
        System.out.println(Base64.encodeBase64String(encoded));

        //2私钥加密，公钥解密---加密
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,privateKey);
        byte[] result = cipher.doFinal(src.getBytes());
        System.out.println(Hex.encodeHexString(result));
        System.out.println(Base64.encodeBase64String(result));

        //3私钥加密，公钥解密---解密
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
        KeyFactory keyFactory1 = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory1.generatePublic(x509EncodedKeySpec);
        Cipher cipher1 = Cipher.getInstance("RSA");
        cipher1.init(Cipher.DECRYPT_MODE,publicKey);
        byte[] bytes = cipher1.doFinal(result);
        System.out.println(new String(bytes));
    }
}
