package DP.MinMaxPathToTarget;
import java.util.Arrays;

// The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones
public class Fibonacci {
    static int[] arr;
    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(5));
        System.out.println(fib(8));
    }

    // Top Down Approach
    public static int fib(int N) {
        if(N <= 1) return N;
        arr = new int[N+1];
        Arrays.fill(arr,-1);
        arr[0]=0;
        arr[1]=1;
        return fibonacci(N);
    }
    public static int fibonacci(int n) {
        if(arr[n] != -1) return arr[n];
        arr[n] = fibonacci(n-1)+fibonacci(n-2);
        return arr[n];
    }

    // Bottom Up Approach
    // public static int fib(int N) {
    //     if(N<=1) return N;
    //     return memoize(N);
    // }
    // public static int memoize(int n) {
    //     int[] memo = new int[n+1];
    //     memo[0]=0;
    //     memo[1]=1;
    //     for(int i=2;i<=n;i++) {
    //         memo[i]=memo[i-1]+memo[i-2];
    //     }
    //     return memo[n];
    // }
}
