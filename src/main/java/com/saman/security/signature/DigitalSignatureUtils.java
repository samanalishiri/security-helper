package com.saman.security.signature;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

/**
 * @author Saman Alishiri Shahrbabak
 */

public final class DigitalSignatureUtils {

    public static final String SIGNING_ALGORITHM = "SHA256withRSA";

    private DigitalSignatureUtils() {
    }

    public static byte[] createDigitalSignature(byte[] input, PrivateKey key) throws Exception {
        Signature signature = Signature.getInstance(SIGNING_ALGORITHM);
        signature.initSign(key);
        signature.update(input);
        return signature.sign();
    }

    public static boolean verifyDigitalSignature(byte[] input, byte[] signatureToVerify, PublicKey key) throws Exception {
        Signature signature = Signature.getInstance(SIGNING_ALGORITHM);
        signature.initVerify(key);
        signature.update(input);
        return signature.verify(signatureToVerify);
    }
}
