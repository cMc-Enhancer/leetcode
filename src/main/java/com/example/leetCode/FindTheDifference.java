package com.example.leetCode;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        short[] chars = new short[26];
        for (char c : t.toCharArray()) {
            chars[((byte) c - (byte) 'a')]++;
        }

        for (char c : s.toCharArray()) {
            chars[((byte) c - (byte) 'a')]--;
        }

        for (byte i = 0; i < chars.length; i++) {
            if (chars[i] > 0) {
                return (char) ((byte) 'a' + i);
            }
        }

        throw new AssertionError();
    }
}
