package edu.uci.mvu1;

public class Utility {

    public static long stringToLong(String s) {
        char[] digits = s.toCharArray();
        long result = 0;
        int significance;
        long incomingDigit;
        boolean negative = false;
        int endAt = 0;

        if (digits[0] == '-') {
            // Why not flip it at the end? Because it's not going to work for the max and min
            // (the bounds at each end aren't absolutely equal)
            negative = true;
            endAt = 1;
        }
        // Go through each digit, subtract the ascii offset for numerals
        // and then insert it as a new digit in our result
        for (int i = digits.length - 1; i >= endAt; i--) {
            significance = digits.length - i - 1;
            incomingDigit = (long)(Math.pow(10, significance) * (digits[i] - 48));
            if (negative) {
                incomingDigit = -incomingDigit;
            }

            result += incomingDigit;
        }

        return result;
    }

}
