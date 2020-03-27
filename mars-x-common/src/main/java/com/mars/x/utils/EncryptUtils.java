package com.mars.x.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by sj.hu on 2019/8/8.
 */
public class EncryptUtils {
    private static char[] hexChar = { '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public static String MD5 = "MD5";
    public static String SHA = "SHA";
    public static String SHA1 = "SHA1";
    public static String SHA256 = "SHA-256";
    public static String SHA384 = "SHA-384";
    public static String SHA512 = "SHA-512";
    public static String DEFAULT_TYPE = MD5;

    private static final int ENCRYPT_OFFSET = 4;

    /*
     * 加密算法
     */
    public static String encrypt(String input) {
        return encrypt(input, DEFAULT_TYPE);
    }

    public static String encrypt(String input, String type) {
        return encrypt(input, Charset.defaultCharset(), type);
    }

    public static String encrypt(String input, Charset charset, String type) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(type);
        } catch (Throwable th) {
        }
        messageDigest.update(input.getBytes(charset));
        byte byteArr[] = messageDigest.digest();
        return localChar(byteArr);
    }

    /*
     * 使用指定的字符串集合
     */
    private static String localChar(byte[] byteArr) {
        int byteNum = byteArr.length;
        char[] charArr = new char[byteNum << 1];
        int i = 0;
        for (int j = 0; j < byteNum; j++) {
            int k = byteArr[j];
            charArr[i++] = hexChar[(k >>> ENCRYPT_OFFSET & 0xF)];
            charArr[i++] = hexChar[(k & 0xF)];
        }
        return new String(charArr);
    }

    public static String rsaEncrypt(String rsaPrikey,String signDataStr) {
        String rsa = null;
        try {
            byte[] bytesKey = (new BASE64Decoder()).decodeBuffer(rsaPrikey.trim());
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(bytesKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
            Signature signature = Signature.getInstance("MD5WithRSA");
            signature.initSign(priKey);
            signature.update(signDataStr.getBytes("GBK"));
            rsa = (new BASE64Encoder()).encodeBuffer(signature.sign());
        } catch (Throwable th) {
        }
        return rsa;
    }

    public static Boolean rsaDecrypt(String publicKey,String signDataStr,String rsaStr){
        try {
            byte[] keyBytes = (new BASE64Decoder()).decodeBuffer(publicKey);
            // 构造X509EncodedKeySpec对象
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
            // KEY_ALGORITHM 指定的加密算法
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            // 取公钥匙对象
            PublicKey pubKey = keyFactory.generatePublic(keySpec);
            Signature signature = Signature.getInstance("MD5withRSA");
            signature.initVerify(pubKey);
            signature.update(signDataStr.getBytes("UTF-8"));
            // 验证签名是否正常
            boolean result = signature.verify((new BASE64Decoder()).decodeBuffer(rsaStr));
            return result;
        } catch (Throwable th) {
        }
        return false;
    }
}
