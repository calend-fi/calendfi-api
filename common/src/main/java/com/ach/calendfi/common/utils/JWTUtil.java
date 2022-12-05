package com.ach.calendfi.common.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {//Expiration
    private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;//Default day
    //Private key
    private static final String TOKEN_SECRET = "privateKey";

    /**
     * Generate signature, one day expires
     *
     * @param **username**
     * @param **password**
     * @return
     */
    public static String createToken(String address) {
        try {
            // Set expiration time
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // Private key and encryption algorithm
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // Set header information
            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            // Return token string
            return JWT.create()
                    .withHeader(header)
                    .withClaim("address", address)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Generate token, customize expiration time in milliseconds
     *
     * @param **username**
     * @param **password**
     * @return
     */
    public static String createToken(String userId, long expireDate) {
        try {
            // Set expiration time
            Date date = new Date(System.currentTimeMillis() + expireDate);
            // Private key and encryption algorithm
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // Set header information
            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            // Return token string
            return JWT.create()
                    .withHeader(header)
                    .withClaim("userId", userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Check whether the token is correct
     *
     * @param **token**
     * @return
     */
    public static boolean verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

