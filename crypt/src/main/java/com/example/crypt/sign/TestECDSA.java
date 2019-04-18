import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.security.*;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @ClassName TestECDSA
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/28 0028 1:34
 * @Version 1.0
 **/
public class TestECDSA {
    private static String src="wufei";
    public static void main(String[] args) {
        try {
            jdkECDSA();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void jdkECDSA() throws Exception{
        //1.初始化密钥
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        keyPairGenerator.initialize(256);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        ECPrivateKey ecPrivateKey=(ECPrivateKey)keyPair.getPrivate();
        ECPublicKey ecPublicKey=(ECPublicKey)keyPair.getPublic();

        //2.执行签名
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(ecPrivateKey.getEncoded());
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature sha1WithECDSA = Signature.getInstance("SHA1WithECDSA");
        sha1WithECDSA.initSign(privateKey);
        sha1WithECDSA.update(src.getBytes());
        byte[] sign = sha1WithECDSA.sign();
        System.out.println(HexBin.encode(sign));

        //3.验证签名
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(ecPublicKey.getEncoded());
        keyFactory = KeyFactory.getInstance("EC");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        sha1WithECDSA = Signature.getInstance("SHA1WithECDSA");
        sha1WithECDSA.initVerify(publicKey);
        sha1WithECDSA.update(src.getBytes());
        boolean verify = sha1WithECDSA.verify(sign);
        System.out.println(verify);
    }
}
