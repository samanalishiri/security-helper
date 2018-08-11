package com.saman.security.symmertic;

import com.saman.security.BaseTest;
import com.saman.security.symmetric.SymmetricEncryptionUtils;
import org.junit.Test;

import javax.crypto.SecretKey;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Saman Alishiri Shahrbabak
 */

public class SymmetricEncryptionUtilsTest extends BaseTest {

    @Test
    public void createAESKey() throws Exception {
        SecretKey key = SymmetricEncryptionUtils.createAESKey();
        assertNotNull(key);
        printEncryptText(key.getEncoded());
    }

    @Test
    public void encryptDecrypt() throws Exception {
        SecretKey key = SymmetricEncryptionUtils.createAESKey();
        byte[] initializationVector = SymmetricEncryptionUtils.createInitializationVector();

        String plainText = "This is the text we are going to hide in plain sight";

        byte[] encryptText = SymmetricEncryptionUtils.performAESEncryption(plainText, key, initializationVector);
        assertNotNull(encryptText);
        printEncryptText(encryptText);

        String decryptText = SymmetricEncryptionUtils.performAESDecryption(encryptText, key, initializationVector);
        assertEquals(plainText, decryptText);
        printDecryptText(decryptText);

    }

}