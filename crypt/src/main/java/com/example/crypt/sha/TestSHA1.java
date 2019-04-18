package com.example.crypt.sha;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.SHA1Digest;

import java.security.MessageDigest;

/**
 * @ClassName TestSHA1
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/2 0002 3:25
 * @Version 1.0
 **/
public class TestSHA1 {
    private static String src="wufei zhen shuai";
    public static void main(String[] args) throws Exception{
        jdkSHA();
        bcSHA();
    }

    private static void bcSHA() {
        SHA1Digest sha1Digest = new SHA1Digest();
        sha1Digest.update(src.getBytes(),0,src.getBytes().length);
        byte[] bytes=new byte[sha1Digest.getDigestSize()];
        sha1Digest.doFinal(bytes,0);
        System.out.println(Hex.encodeHexString(bytes));
    }

    private static void jdkSHA() throws Exception{
        MessageDigest sha = MessageDigest.getInstance("SHA");
        sha.update(src.getBytes());
        System.out.println(Hex.encodeHexString(sha.digest()));

    }
}
