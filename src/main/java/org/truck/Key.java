package org.truck;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class Key {
    String sha256Hex;

    public Key() {
        sha256Hex = Hashing.sha256()
                .hashString("Kodiak2024", StandardCharsets.UTF_8)
                .toString();
    }

    public String sendSignal() {
        return sha256Hex;
    }

    public String sendWrongSignal() {
        return "F0F0";
    }
}
