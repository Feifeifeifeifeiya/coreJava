package com.example.crypt.des;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * @ClassName Test3DES
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/1 0001 1:03
 * @Version 1.0
 **/
public class Test3DES {
    private static String src="wufei zhen shuai";

    public static void main(String[] args)throws Exception {
        jdk3Des();
    }

    private static void jdk3Des() throws Exception {
        //生成key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
        keyGenerator.init(new SecureRandom());
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] encoded = secretKey.getEncoded();

        //key的转换
        DESedeKeySpec desKeySpec = new DESedeKeySpec(encoded);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DESede");
        Key key = secretKeyFactory.generateSecret(desKeySpec);

        //加密
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] bytes = cipher.doFinal(src.getBytes());
        System.out.println(HexBin.encode(bytes));
        System.out.println("jdk desede encrypt"+Hex.encodeHexString(bytes));

        //解密
        cipher.init(Cipher.DECRYPT_MODE,key);
        byte[] bytes1 = cipher.doFinal(bytes);
        System.out.println("jdk desede decrypt"+new String(bytes1));
    }
}
