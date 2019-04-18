package com.example.crypt.base64;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @ClassName JdkBase64
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/1 0001 0:21
 * @Version 1.0
 **/
public class TestBase64 {
    private static String src="wufei zhen shuai";
    public static void main(String[] args) throws IOException {
       jdkBase64();
       commonsCode();
       bouncyCastleBase64();
       utilBase64();
    }


    private static void utilBase64() {
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        byte[] encode = encoder.encode(src.getBytes());
        System.out.println("encode"+new String(encode));
        java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
        byte[] decode = decoder.decode(encode);
        System.out.println("decode"+new String(decode));
    }

    private static void bouncyCastleBase64() {
        byte[] encode = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
        System.out.println("encode"+new String(encode));
        byte[] decode = org.bouncycastle.util.encoders.Base64.decode(encode);
        System.out.println("decode"+new String(decode));
    }

    private static void commonsCode() {
        byte[] bytes = Base64.encodeBase64(src.getBytes());
        System.out.println("encode"+new String(bytes));
        byte[] bytes1 = Base64.decodeBase64(bytes);
        System.out.println("decode"+new String(bytes1));
    }

    private static void jdkBase64() throws IOException{
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encode = base64Encoder.encode(src.getBytes());
        System.out.println("encode"+encode);

        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] bytes = base64Decoder.decodeBuffer(encode);
        System.out.println("decode"+new String(bytes));
    }


}
