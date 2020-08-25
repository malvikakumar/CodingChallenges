package DP.MinMaxPathToTarget;

// Problem statement at the bottom
public class TwoKeysKeyboard {
    public static void main(String[] args) {
        System.out.println(minSteps(3));
        System.out.println(minSteps(7));
        System.out.println(minSteps(6));
    }

    // Prime Factorization
    public static int minSteps(int n) {
        if (n == 1) return 0;
        for (int i = 2; i < n; i++)
            if (n % i == 0) return i + minSteps(n / i);
        return n;
    }
}

// Problem Statement:
// Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:
//    Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
//    Paste: You can paste the characters which are copied last time.
//
//Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.

// Solution Explanation:
//It take 2 ops to double, 3 ops to triple, ...
//        if n % 2 == 0, then f(n) = f(n/2) + 2
//        if n % 3 == 0, then f(n) = f(n/3) + 3
//        2 * 2 = 2 + 2; 2 * 3 > 2 + 3; 4 * 4 > 4 + 4; so it is always better to divide whenever possible.
//        now it became a problem for finding all possible factors;
