package com.pacifique.ssiach14ex1.config;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PlayAround {
    public static void main(String[] args) throws NoSuchAlgorithmException {
//        Base64.Encoder encoder = Base64.getEncoder();
//        System.out.println(encoder.encodeToString(encoder.encode("client:secret".getBytes())));
//        Base64.Decoder decoder = Base64.getDecoder();
//        byte[] decode = decoder.decode("Y2xpZW50OnNlY3JldA==");
//
//        System.out.println(new String(decode));

        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);
        String verifier = Base64.getEncoder()
                .withoutPadding()
                .encodeToString(randomBytes);

        System.out.println("verifier = " + verifier);
        String message = "Hello World";

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] digest = messageDigest.digest(verifier.getBytes(StandardCharsets.UTF_8));
        String challenge = Base64.getEncoder().withoutPadding().encodeToString(digest);
        byte[] digest1 = messageDigest.digest(message.getBytes(StandardCharsets.UTF_8));
        String encodeToString = Base64.getEncoder().withoutPadding().encodeToString(digest1);
        System.out.println("encodeToString = " + encodeToString);
        System.out.println("challenge = " + challenge);

        String code = "opaque-oauth2-client:opaque-oauth2-client-secret";
        Base64.Encoder encoder = Base64.getEncoder();
        String encodeToString1 = encoder.withoutPadding().encodeToString(code.getBytes(StandardCharsets.UTF_8));
        System.out.println("encodeToString1 = " + encodeToString1);
    }
}
