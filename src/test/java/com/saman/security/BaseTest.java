package com.saman.security;

import javax.xml.bind.DatatypeConverter;
import java.net.URI;

/**
 * @author Saman Alishiri Shahrbabak
 */

public abstract class BaseTest {

    protected URI fileURI(String fileName) throws Exception {
        return this.getClass().getClassLoader().getResource(fileName).toURI();
    }

    protected String translateToHexBinary(byte[] encryptText) {
        return DatatypeConverter.printHexBinary(encryptText);
    }

    protected void printDecryptText(String decryptText) {
        System.out.println("decryptText = " + decryptText);
    }

    protected void printEncryptText(byte[] encryptText) {
        String hexText = translateToHexBinary(encryptText);
        System.out.println("encryptText = " + hexText);
    }

    protected void printKeyValue(String key, String value) {
        System.out.println(key + " = " + value);
    }

    protected void print(String str) {
        System.out.println(str);
    }
}
