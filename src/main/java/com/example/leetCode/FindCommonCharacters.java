package com.example.leetCode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindCommonCharacters {

    public List<String> commonChars(String[] A) {
        if (A == null || A.length == 0) {
            return Collections.emptyList();
        }

        int[] counter = new int[26];
        for (int i = 0; i < 26; i++) {
            counter[i] = Integer.MAX_VALUE;
        }

        for (String s : A) {
            int[] characterCountMap = new int[26];
            for (char c : s.toCharArray()) {
                int charIndex = (int) c - (int) 'a';
                characterCountMap[charIndex]++;
            }

            for (int i = 0; i < 26; i++) {
                counter[i] = Math.min(counter[i], characterCountMap[i]);
            }
        }

        List<String> result = new LinkedList<>();
        for (int i = 0; i < counter.length; i++) {
            for (int j = 0; j < counter[i]; j++) {
                result.add(String.valueOf((char) ((int) 'a' + i)));
            }
        }
        return result;
    }
}
