package com.saman.security.asymmetric;

import com.saman.security.BaseTest;
import org.junit.Test;

import javax.xml.bind.DatatypeConverter;
import java.security.KeyPair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Saman Alishiri Shahrbabak
 */

public class AsymmetricEncryptionUtilsTest extends BaseTest {

    @Test
    public void generateKeyPair() throws Exception {
        KeyPair keyPair = AsymmetricEncryptionUtils.generateKeyPair();
        assertNotNull(keyPair);
        String privateKey = DatatypeConverter.printHexBinary(keyPair.getPrivate().getEncoded());
        printKeyValue("privateKey", privateKey);
        String publicKey = DatatypeConverter.printHexBinary(keyPair.getPublic().getEncoded());
        printKeyValue("privateKey", publicKey);
    }

    @Test
    public void encryptDecrypt() throws Exception {
        KeyPair keyPair = AsymmetricEncryptionUtils.generateKeyPair();
        String plainText = "This is the text we are going to hide in plain sight";

        byte[] encryptText = AsymmetricEncryptionUtils.performRSAEncryption(plainText, keyPair.getPrivate());
        assertNotNull(encryptText);
        printEncryptText(encryptText);

        String decryptText = AsymmetricEncryptionUtils.performRSADecryption(encryptText, keyPair.getPublic());
        assertEquals(plainText, decryptText);
        printDecryptText(decryptText);

    }
}