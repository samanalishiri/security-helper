package com.saman.security.keystore;

import javax.crypto.SecretKey;

/**
 * @author Saman Alishiri Shahrbabak
 */

public final class KeyStoreObject {

    private final SecretKey secretKey;
    private final String keystorePassword;
    private final String keyAlias;
    private final String secretKeyPassword;

    private KeyStoreObject(Builder builder) {
        secretKey = builder.secretKey;
        keystorePassword = builder.keystorePassword;
        keyAlias = builder.keyAlias;
        secretKeyPassword = builder.secretKeyPassword;
    }

    public static Builder builder() {
        return new Builder();
    }

    public SecretKey getSecretKey() {
        return secretKey;
    }

    public char[] getKeystorePassword() {
        return keystorePassword.toCharArray();
    }

    public String getKeyAlias() {
        return keyAlias;
    }

    public char[] getSecretKeyPassword() {
        return secretKeyPassword.toCharArray();
    }

    public static final class Builder {
        private SecretKey secretKey;
        private String keystorePassword;
        private String keyAlias;
        private String secretKeyPassword;

        private Builder() {
        }

        public Builder secretKey(SecretKey val) {
            secretKey = val;
            return this;
        }

        public Builder keystorePassword(String val) {
            keystorePassword = val;
            return this;
        }

        public Builder keyAlias(String val) {
            keyAlias = val;
            return this;
        }

        public Builder secretKeyPassword(String val) {
            secretKeyPassword = val;
            return this;
        }

        public KeyStoreObject build() {
            return new KeyStoreObject(this);
        }
    }
}
