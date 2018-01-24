package ru.isct.service;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

/**
 * Created by ppetrovt on 24.01.2018.
 */
public class HashGenerator {

    public static String getSha256(String str) {
        return Hashing.sha256().hashString(str, StandardCharsets.UTF_8).toString();
    }
}
