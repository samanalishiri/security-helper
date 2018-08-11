package com.saman.security.keystore;

import javax.crypto.SecretKey;
import java.security.KeyStore;

/**
 * @author Saman Alishiri Shahrbabak
 */

public final class KeyStoreUtils {

    public static final String SECRET_KEY_KEYSTORE_TYPE = "JCEKS";

    private KeyStoreUtils() {
    }

    public static KeyStore createPrivateKeyJavaKeyStore(KeyStoreObject args) throws Exception {
        KeyStore keyStore = KeyStore.getInstance(SECRET_KEY_KEYSTORE_TYPE);
        keyStore.load(null, args.getKeystorePassword());
        KeyStore.PasswordProtection secretKeyPasswordEntry = new KeyStore.PasswordProtection(args.getSecretKeyPassword());
        KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(args.getSecretKey());
        keyStore.setEntry(args.getKeyAlias(), secretKeyEntry, secretKeyPasswordEntry);
        return keyStore;
    }

    public static SecretKey loadPrivateKeyJavaKeyStore(KeyStore keyStore, KeyStoreObject args) throws Exception {
        keyStore.load(null, args.getKeystorePassword());
        KeyStore.PasswordProtection secretKeyPasswordEntry = new KeyStore.PasswordProtection(args.getSecretKeyPassword());
        KeyStore.SecretKeyEntry secretKeyEntry = (KeyStore.SecretKeyEntry) keyStore.getEntry(args.getKeyAlias(), secretKeyPasswordEntry);
        return secretKeyEntry.getSecretKey();
    }
}
