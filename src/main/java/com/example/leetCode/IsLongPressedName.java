package com.example.leetCode;

public class IsLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null) {
            return false;
        }

        if (name.length() == 0 || typed.length() == 0) {
            return name.length() == typed.length();
        }

        int iName = 0, iTyped = 0;
        while (iName < name.length()) {
            if (iTyped >= typed.length()) {
                return false;
            }
            if (name.charAt(iName) == typed.charAt(iTyped)) {
                iName++;
                iTyped++;
            } else if (iTyped != 0 && typed.charAt(iTyped - 1) == typed.charAt(iTyped)) {
                iTyped++;
            } else {
                return false;
            }
        }

        while (iTyped < typed.length()) {
            if (typed.charAt(iTyped - 1) != typed.charAt(iTyped)) {
                return false;
            }
            iTyped++;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsLongPressedName().isLongPressedName("pyplrz", "ppyypllr"));
    }
}
