package com.example.crypt.des;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Random;

/**
 * @ClassName TestAES
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/1 0001 1:10
 * @Version 1.0
 **/
public class TestAES {
    private static String src="wufei zhen shuai";
    public static void main(String[] args)throws Exception {
        jdkAES();
    }

    private static void jdkAES()throws Exception {
        //生成key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] encoded = secretKey.getEncoded();

        //key转换
        Key key = new SecretKeySpec(encoded, "AES");

        //加密
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] bytes = cipher.doFinal(src.getBytes());
        System.out.println("AES"+Base64.encodeBase64String(bytes));

        //解密
        cipher.init(Cipher.DECRYPT_MODE,key);
        byte[] bytes1 = cipher.doFinal(bytes);
        System.out.println("decode"+new String(bytes1));
    }
}
