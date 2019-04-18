import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.security.*;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @ClassName TestDSA
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/28 0028 1:22
 * @Version 1.0
 **/
public class TestDSA {
    private static String src="WUFEI";
    public static void main(String[] args) {
        try {
            jdkDSA();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void jdkDSA() throws Exception{
        //1.初始化密钥
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        keyPairGenerator.initialize(512);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        DSAPrivateKey dsaPrivateKey=(DSAPrivateKey)keyPair.getPrivate();
        DSAPublicKey dsaPublicKey=(DSAPublicKey)keyPair.getPublic();

        //2.执行签名
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(dsaPrivateKey.getEncoded());
        KeyFactory keyFactory = KeyFactory.getInstance("DSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature sha1WithDSA = Signature.getInstance("SHA1WithDSA");
        sha1WithDSA.initSign(privateKey);
        sha1WithDSA.update(src.getBytes());
        byte[] sign = sha1WithDSA.sign();
        System.out.println(HexBin.encode(sign));

        //验证签名
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(dsaPublicKey.getEncoded());
        keyFactory = KeyFactory.getInstance("DSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        sha1WithDSA = Signature.getInstance("SHA1WithDSA");
        sha1WithDSA.initVerify(publicKey);
        sha1WithDSA.update(src.getBytes());
        boolean verify = sha1WithDSA.verify(sign);
        System.out.println(verify);
    }
}
