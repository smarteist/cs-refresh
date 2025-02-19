package com.github.smarteist.coursera.miscellaneous;

import java.util.Stack;

public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        int maxLength = 0;
        int left = 0, right = 0;

        // Left to Right pass
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLength = Math.max(maxLength, left + right);
            } else if (right > left) {
                left = right = 0;
            }
        }

        left = right = 0;

        // Right to Left pass
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else {
                left++;
            }

            if (left == right) {
                maxLength = Math.max(maxLength, left + right);
            } else if (left > right) {
                left = right = 0;
            }
        }

        return maxLength;
    }


    public static void main(String[] args) {
        longestValidParentheses("()(())");
        longestValidParentheses("(()(()))");
    }

}
