package com.example.crypt.md5;


import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.bouncycastle.crypto.digests.MD5Digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName TestMD5
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/1 0001 23:13
 * @Version 1.0
 **/
public class TestMD5 {
    private static String  src= "wufei zhen shuai";
    public static void main(String[] args)throws Exception {
        jdkMD5();
        bcMD5();
        ccMD5();
    }

    private static void ccMD5() {
        String s = DigestUtils.md5Hex(src.getBytes());
        System.out.println(s);
    }

    private static void bcMD5() throws Exception{
        MD5Digest md5Digest = new MD5Digest();
        md5Digest.update(src.getBytes(),0,src.getBytes().length);
        byte[] bytes = new byte[md5Digest.getDigestSize()];
        md5Digest.doFinal(bytes,0);
        System.out.println(Hex.encodeHexString(bytes));
    }

    private static void jdkMD5() throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest = md5.digest(src.getBytes());
        System.out.println(Hex.encodeHexString(digest));
    }
}
