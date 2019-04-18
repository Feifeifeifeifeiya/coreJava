import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @ClassName TestRSA
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/28 0028 0:59
 * @Version 1.0
 **/
public class TestRSA {

    private static String src="wufei";

    public static void main(String[] args) {
        try {
            jdkRSA();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void jdkRSA() throws Exception{
        //1.初始化密钥
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rsaPublicKey = (RSAPublicKey)keyPair.getPublic();
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)keyPair.getPrivate();

        //2.执行签名
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature md5WithRSA = Signature.getInstance("MD5WithRSA");
        md5WithRSA.initSign(privateKey);
        md5WithRSA.update(src.getBytes());
        byte[] sign = md5WithRSA.sign();
        System.out.println(HexBin.encode(sign));

        //3.验证签名
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
        keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        md5WithRSA = Signature.getInstance("MD5WithRSA");
        md5WithRSA.initVerify(publicKey);
        md5WithRSA.update(src.getBytes());
        boolean verify = md5WithRSA.verify(sign);
        System.out.println(verify);

    }
}
