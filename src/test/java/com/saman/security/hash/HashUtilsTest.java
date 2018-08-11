package com.saman.security.hash;

import com.saman.security.BaseTest;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Saman Alishiri Shahrbabak
 */

public class HashUtilsTest extends BaseTest {

    @Test
    public void randomGenerateSalt() {
        byte[] salt = HashUtils.randomGenerateSalt();
        assertNotNull(salt);
        printEncryptText(salt);
    }

    @Test
    public void createSHA2Hash() throws Exception {
        byte[] salt = HashUtils.randomGenerateSalt();
        String valueToHash = UUID.randomUUID().toString();

        byte[] firstHashText = HashUtils.createSHA2Hash(valueToHash, salt);
        assertNotNull(firstHashText);
        String firstHexBinary = translateToHexBinary(firstHashText);
        print(firstHexBinary);

        byte[] secondHashText = HashUtils.createSHA2Hash(valueToHash, salt);
        assertNotNull(secondHashText);
        String secondHexBinary = translateToHexBinary(secondHashText);
        print(secondHexBinary);

        assertEquals(firstHexBinary, secondHexBinary);
    }

    @Test
    public void verifyPassword() {
        String plain = "password";

        String hash = HashUtils.hashPassword(plain);
        assertNotNull(hash);

        boolean verify = HashUtils.verifyPassword(plain, hash);
        assertTrue(verify);

        printKeyValue("password", hash);
    }
}