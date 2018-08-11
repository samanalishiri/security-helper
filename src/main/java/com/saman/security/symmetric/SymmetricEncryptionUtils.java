package com.saman.security.symmetric;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

/**
 * @author Saman Alishiri Shahrbabak
 */

public final class SymmetricEncryptionUtils {

    public static final String AES = "AES";
    public static final String AES_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";

    private SymmetricEncryptionUtils() {
    }

    public static SecretKey createAESKey() throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
        keyGenerator.init(256, secureRandom);
        return keyGenerator.generateKey();
    }

    public static byte[] createInitializationVector() {
        byte[] initializationVector = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(initializationVector);
        return initializationVector;
    }

    public static byte[] performAESEncryption(String plainText, SecretKey key, byte[] initializationVector) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
        IvParameterSpec parameterSpec = new IvParameterSpec(initializationVector);
        cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);
        return cipher.doFinal(plainText.getBytes());
    }

    public static String performAESDecryption(byte[] encryptText, SecretKey key, byte[] initializationVector) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
        IvParameterSpec parameterSpec = new IvParameterSpec(initializationVector);
        cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);
        byte[] result = cipher.doFinal(encryptText);
        return new String(result);
    }
}