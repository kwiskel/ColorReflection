package com.flyingbrowniegames.ballgame;

/**
 * Created by kyle on 2017-12-24.
 */

public class bitManipulation {

    public static void hashManipulation() {
        // Replace this with your encoded key.
        String base64EncodedPublicKey = "";

// Get byte sequence to play with.
        byte[] bytes = base64EncodedPublicKey.getBytes();

// Swap upper and lower case letters.
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] >= 'A' && bytes[i] <= 'Z')
                bytes[i] = (byte) ('a' + (bytes[i] - 'A'));
            else if (bytes[i] >= 'a' && bytes[i] <= 'z')
                bytes[i] = (byte) ('A' + (bytes[i] - 'a'));
        }

// Assign back to string.
        base64EncodedPublicKey = new String(bytes);
    }
}
