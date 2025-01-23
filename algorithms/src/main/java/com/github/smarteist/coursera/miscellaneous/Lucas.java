package com.github.smarteist.coursera.miscellaneous;

public class Lucas {

    // Method to multiply two 2x2 matrices (Order: O(1))
    private static long[][] matrixMult(long[][] A, long[][] B) {
        return new long[][]{
                {A[0][0] * B[0][0] + A[0][1] * B[1][0], A[0][0] * B[0][1] + A[0][1] * B[1][1]},
                {A[1][0] * B[0][0] + A[1][1] * B[1][0], A[1][0] * B[0][1] + A[1][1] * B[1][1]}
        };
    }

    // Method to raise a matrix to the power of n using exponentiation by squaring (Order: O(log n))
    private static long[][] matrixPow(long[][] mat, long n) {
        long[][] result = {{1, 0}, {0, 1}}; // Identity matrix
        // Loop runs O(log n) times
        while (n > 0) {
            if (n % 2 == 1) {
                result = matrixMult(result, mat);
            }
            mat = matrixMult(mat, mat);
            n /= 2;
        }
        return result;
    }

    // Method to calculate the n-th Fibonacci number and (n-1)-th Fibonacci number (Order: O(log n))
    public static long[] lucas(long n) {
        if (n == 0) {
            return new long[]{1, 0}; // F_0 = 1, F_{-1} = 0 (not defined, but we return 0 for consistency)
        } else if (n == 1) {
            return new long[]{1, 1}; // F_1 = 1, F_0 = 1
        }

        // The transformation matrix for Fibonacci
        long[][] transformationMatrix = {{1, 1}, {1, 0}};

        // Raise the transformation matrix to the power of n (Order: O(log n))
        long[][] resultMatrix = matrixPow(transformationMatrix, n);

        // The n-th Fibonacci number is in the first row, first column of the result matrix
        // The (n-1)-th Fibonacci number is in the first row, second column of the result matrix
        return resultMatrix[0]; // { F_n, F_{n-1} }
    }


    // Main method for testing
    public static void main(String[] args) {
        long n = 55; // Example input for Fibonacci
        long[] fibNumbers = lucas(n); // Calculate the n-th and (n-1)-th lucas numbers (Order: O(log n))

        System.out.println("The " + (n + 1) + "-th Fibonacci number is: " + fibNumbers[0]);
        System.out.println("The " + (n) + "-th Fibonacci number is: " + fibNumbers[1]);
    }
}