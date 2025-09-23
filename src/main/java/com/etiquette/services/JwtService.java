package com.etiquette.services;

import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import org.springframework.stereotype.Service;

import java.io.InputStream;

import java.util.Date;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;

@Service
public class JwtService {

    Dotenv dotenv = Dotenv.load();
    String keyStorePassword = dotenv.get("KEY_STORE_PASSWORD");

    private final PrivateKey privateKey;
    private final PublicKey publicKey;

    // Token expiration: 1 hour
    private final long expirationMillis = 60 * 60 * 1000;

    public JwtService() throws Exception {
        // Load keystore from classpath (adjust path as needed)
        String keystorePath = "/jwtkeystore.p12";
        String keystorePassword = keyStorePassword;  // Use your actual password
        String keyAlias = "jwtkey";
        String keyPassword = keyStorePassword;       // Use your actual key password

        KeyStore keyStore = KeyStore.getInstance("PKCS12");

        try (InputStream is = getClass().getResourceAsStream(keystorePath)) {
            if (is == null) {
                throw new RuntimeException("Keystore not found at " + keystorePath);
            }
            keyStore.load(is, keystorePassword.toCharArray());
        }

        // Get private key
        privateKey = (PrivateKey) keyStore.getKey(keyAlias, keyPassword.toCharArray());

        // Get public key from certificate
        Certificate cert = keyStore.getCertificate(keyAlias);
        publicKey = cert.getPublicKey();
    }

    /**
     * Generate a signed JWT token for the given subject.
     */
    public String generateToken(String subject) {
    Date now = new Date();
    Date expiryDate = new Date(now.getTime() + expirationMillis);

    return Jwts.builder()
            .claim("sub", subject)
            .issuedAt(now)
            .expiration(expiryDate)
            .signWith(privateKey) // No SignatureAlgorithm needed
            .compact();
    }

    /**
     * Validate the token: verifies signature and expiration.
     */
    public boolean isTokenValid(String token) {
        try {
            parseClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Check if the token is expired.
     */
    public boolean isTokenExpired(String token) {
        try {
            return getExpirationDate(token).before(new Date());
        } catch (JwtException e) {
            return true;
        }
    }

    /**
     * Get token expiration date.
     */
    public Date getExpirationDate(String token) {
        return parseClaims(token).getExpiration();
    }

    /**
     * Get subject (e.g., username or user ID) from token.
     */
    public String getSubject(String token) {
        return parseClaims(token).getSubject();
    }

    /**
     * Internal method to parse claims using public key.
     */
    private Claims parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(publicKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
