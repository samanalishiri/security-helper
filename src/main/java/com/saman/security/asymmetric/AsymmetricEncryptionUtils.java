package com.saman.security.asymmetric;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

/**
 * @author Saman Alishiri Shahrbabak
 */

public final class AsymmetricEncryptionUtils {

    public static final String RSA = "RSA";

    private AsymmetricEncryptionUtils() {
    }

    public static KeyPair generateKeyPair() throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
        keyPairGenerator.initialize(4096, secureRandom);
        return keyPairGenerator.generateKeyPair();
    }

    public static byte[] performRSAEncryption(String plainText, PrivateKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(plainText.getBytes());
    }

    public static String performRSADecryption(byte[] cipherText, PublicKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] result = cipher.doFinal(cipherText);
        return new String(result);
    }
}
