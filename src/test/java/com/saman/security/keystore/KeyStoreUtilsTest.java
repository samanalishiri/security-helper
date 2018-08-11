package com.saman.security.keystore;

import com.saman.security.BaseTest;
import com.saman.security.symmetric.SymmetricEncryptionUtils;
import org.junit.Test;

import javax.crypto.SecretKey;
import java.security.KeyStore;

import static com.saman.security.keystore.KeyStoreObject.builder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Saman Alishiri Shahrbabak
 */

public class KeyStoreUtilsTest extends BaseTest {

    @Test
    public void createPrivateKeyJavaKeyStore() throws Exception {
        SecretKey secretKey = SymmetricEncryptionUtils.createAESKey();
        assertNotNull(secretKey);
        String secretKeyHexBinary = translateToHexBinary(secretKey.getEncoded());
        print(secretKeyHexBinary);

        KeyStoreObject keyStoreObject = builder()
                .keystorePassword("password")
                .keyAlias("alias")
                .secretKey(secretKey)
                .secretKeyPassword("keyPassword")
                .build();

        KeyStore keyStore = KeyStoreUtils.createPrivateKeyJavaKeyStore(keyStoreObject);
        assertNotNull(keyStore);

        SecretKey loadedSecretKey = KeyStoreUtils.loadPrivateKeyJavaKeyStore(keyStore, keyStoreObject);
        assertNotNull(loadedSecretKey);
        String loadedSecretKeyHexBinary = translateToHexBinary(loadedSecretKey.getEncoded());
        print(loadedSecretKeyHexBinary);

        assertEquals(secretKeyHexBinary, loadedSecretKeyHexBinary);
    }
}