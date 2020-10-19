package com.example.leetCode;

import java.util.Objects;

public class BackSpaceCompare {
    public boolean backspaceCompare(String S, String T) {
        int si = S.length() - 1;
        int ti = T.length() - 1;

        int sb = 0, tb = 0;

        while (si >= 0 || ti >= 0) {
            Character sc = null;
            Character tc = null;
            if (si >= 0) {
                sc = S.charAt(si);
            }
            if (ti >= 0) {
                tc = T.charAt(ti);
            }

            if ((sc != null && sc == '#') || (tc != null && tc == '#')) {
                if (sc != null && sc == '#') {
                    sb++;
                    si--;
                }
                if (tc != null && tc == '#') {
                    tb++;
                    ti--;
                }
                continue;
            }

            if (sb > 0 || tb > 0) {
                if (sb > 0) {
                    sb--;
                    si--;
                }
                if (tb > 0) {
                    tb--;
                    ti--;
                }
                continue;
            }

            if (!Objects.equals(sc, tc)) {
                return false;
            } else {
                si--;
                ti--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new BackSpaceCompare().backspaceCompare("abc", "abc"));
        System.out.println(new BackSpaceCompare().backspaceCompare("ab#c", "ad#c"));
        System.out.println(new BackSpaceCompare().backspaceCompare("ab##", "ad##"));
        System.out.println(new BackSpaceCompare().backspaceCompare("tcmsiocdna", "tcmsiocdnp#a"));
        System.out.println(new BackSpaceCompare().backspaceCompare("a#c#", "ab##"));
        System.out.println(new BackSpaceCompare().backspaceCompare("bxj##tw", "bxo#j##tw"));
    }
}
