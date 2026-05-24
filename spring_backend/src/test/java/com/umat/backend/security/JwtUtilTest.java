package com.umat.backend.security;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class JwtUtilTest {

    @Test
    public void generateAndParseToken() throws Exception {
        JwtUtil util = new JwtUtil();
        // set private fields via reflection
        Field secretField = JwtUtil.class.getDeclaredField("jwtSecret");
        secretField.setAccessible(true);
        secretField.set(util, "01234567890123456789012345678901"); // 32 bytes

        Field expField = JwtUtil.class.getDeclaredField("jwtExpirationMs");
        expField.setAccessible(true);
        expField.setInt(util, 3600000);

        String token = util.generateToken("testuser@example.com");
        assertNotNull(token);

        String subject = util.getSubject(token);
        assertEquals("testuser@example.com", subject);
    }
}
