package com.example.crypt.des;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * @ClassName TestPBE
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/1 0001 1:22
 * @Version 1.0
 **/
public class TestPBE {
    private static String src="wufei zhen shuai";
    public static void main(String[] args) throws Exception{
        jdkPBE();
    }

    private static void jdkPBE() throws Exception{
        //初始化盐
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = secureRandom.generateSeed(8);

        //口令与密钥
        String password="wufei";
        PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBEWITHMD5andDES");
        Key key = secretKeyFactory.generateSecret(pbeKeySpec);

        //加密
        PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 100);
        Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
        cipher.init(Cipher.ENCRYPT_MODE,key,pbeParameterSpec);
        byte[] bytes = cipher.doFinal(src.getBytes());
        System.out.println(Base64.encodeBase64String(bytes));

        //解密
        cipher.init(Cipher.DECRYPT_MODE,key,pbeParameterSpec);
        byte[] bytes1 = cipher.doFinal(bytes);
        System.out.println(new String(bytes1));
    }
}
