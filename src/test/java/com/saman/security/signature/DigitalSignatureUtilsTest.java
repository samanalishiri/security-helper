package com.saman.security.signature;

import com.saman.security.BaseTest;
import com.saman.security.asymmetric.AsymmetricEncryptionUtils;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyPair;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Saman Alishiri Shahrbabak
 */

public class DigitalSignatureUtilsTest extends BaseTest {

    @Test
    public void createDigitalSignature() throws Exception {
        byte[] input = Files.readAllBytes(Paths.get(fileURI("demo.txt")));
        KeyPair keyPair = AsymmetricEncryptionUtils.generateKeyPair();
        byte[] signature = DigitalSignatureUtils.createDigitalSignature(input, keyPair.getPrivate());
        assertNotNull(signature);

        boolean verify = DigitalSignatureUtils.verifyDigitalSignature(input, signature, keyPair.getPublic());
        assertTrue(verify);

        printEncryptText(signature);
    }
}