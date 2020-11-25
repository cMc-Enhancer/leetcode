package com.example.leetCode;

public class IncreasingDecreasingString {
    public String sortString(String s) {
        int[] charCountArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCountArray[(int) c - (int) 'a']++;
        }

        int count = s.length();
        StringBuilder resultBuilder = new StringBuilder();

        while (true) {
            for (int i = 0; i < charCountArray.length; i++) {
                if (charCountArray[i] > 0) {
                    charCountArray[i]--;
                    resultBuilder.append((char) (i + (int) 'a'));
                    count--;
                    if (count == 0) {
                        return resultBuilder.toString();
                    }
                }
            }

            for (int i = charCountArray.length - 1; i >= 0; i--) {
                if (charCountArray[i] > 0) {
                    charCountArray[i]--;
                    resultBuilder.append((char) (i + (int) 'a'));
                    count--;
                    if (count == 0) {
                        return resultBuilder.toString();
                    }
                }
            }
        }
    }
}
