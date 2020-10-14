package com.example.leetCode;

import java.util.*;

public class FindCommonCharacters {

    public List<String> commonChars(String[] A) {
        if (A == null || A.length == 0) {
            return Collections.emptyList();
        }

        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            counter.put((char) ((int) 'a' + i), Integer.MAX_VALUE);
        }

        for (String s : A) {
            Map<Character, Integer> characterCountMap = new HashMap<>();
            for (char c : s.toCharArray()) {
                characterCountMap.putIfAbsent(c, 0);
                characterCountMap.put(c, characterCountMap.get(c) + 1);
            }

            for (int i = 0; i < 26; i++) {
                char c = (char) ((int) 'a' + i);
                counter.put(c, Math.min(counter.get(c), characterCountMap.getOrDefault(c, 0)));
            }
        }

        List<String> result = new LinkedList<>();
        for (Map.Entry<Character, Integer> e : counter.entrySet()) {
            if (e.getValue() > 0) {
                for (Integer i = 0; i < e.getValue(); i++) {
                    result.add(e.getKey().toString());
                }
            }
        }
        return result;
    }
}
