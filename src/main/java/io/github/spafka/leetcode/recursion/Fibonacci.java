package io.github.spafka.leetcode.recursion;

import io.github.spafka.util.Utils;

import java.util.stream.IntStream;

// Fibonacci 数列
public class Fibonacci {

    public static void main(String[] args) {

        IntStream.rangeClosed(1, 39).forEach(x -> {
           Integer fibi= Utils.timeTakeMS(() -> fib(x), "fib" + x);
            System.out.println(fibi);
        });

        IntStream.rangeClosed(1, 39).forEach(x -> {
            Integer fibi = Utils.timeTakeMS(() -> fib2(x), "fib" + x);
            System.out.println(fibi);
        });
    }


    public static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }


    public static int fib2(int n) {
        int[] arr = new int[n + 1];
        return helper(n, arr);

    }

    public static int helper(int n, int[] arr) {
        if (n == 0) {
            arr[0] = 0;
        }
        if (n == 1) {
            arr[1] = 1;
        }
        if (n == 2) {
            arr[2] = 1;
        } else {
            if (arr[n] != 0) {
                // memerized just fast get
                return arr[n];
            }
            arr[n] = helper(n - 1, arr) + helper(n - 2, arr);
        }
        return arr[n];
    }


}
