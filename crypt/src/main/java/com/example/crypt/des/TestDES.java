package com.example.crypt.des;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import org.apache.commons.codec.binary.Hex;
import sun.misc.HexDumpEncoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName TestDES
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/1 0001 0:44
 * @Version 1.0
 **/
public class TestDES {
    private static String src="wufei zhen shuai";

    public static void main(String[] args)throws Exception {
        jdkDes();
    }

    private static void jdkDes() throws Exception {
        //生成key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] encoded = secretKey.getEncoded();

        //key的转换
        DESKeySpec desKeySpec = new DESKeySpec(encoded);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        Key key = secretKeyFactory.generateSecret(desKeySpec);

        //加密
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] bytes = cipher.doFinal(src.getBytes());
        System.out.println(HexBin.encode(bytes));
        System.out.println("jdk des encrypt"+Hex.encodeHexString(bytes));

        //解密
        cipher.init(Cipher.DECRYPT_MODE,key);
        byte[] bytes1 = cipher.doFinal(bytes);
        System.out.println("jdk des decrypt"+new String(bytes1));
    }
}
