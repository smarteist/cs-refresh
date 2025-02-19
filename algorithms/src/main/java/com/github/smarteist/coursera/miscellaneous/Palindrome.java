package com.github.smarteist.coursera.miscellaneous;

class Palindrome {
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;

        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        return x == reversed || x == reversed / 10;
    }


    public static void main(String[] args) {
        int number = 121; // Change this to test other numbers
        boolean isPalindrome = isPalindrome(number);
        System.out.println("Is " + number + " a palindrome? " + isPalindrome);
        number = 124;
        isPalindrome = isPalindrome(number);
        System.out.println("Is " + number + " a palindrome? " + isPalindrome);
        number = 1331;
        isPalindrome = isPalindrome(number);
        System.out.println("Is " + number + " a palindrome? " + isPalindrome);
    }

}