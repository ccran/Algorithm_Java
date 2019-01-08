package leetcode.Array;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 * <p>
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 * <p>
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 ≤ N ≤ 30.
 */
public class Fibonacci_Number {
    class Solution {
        public int fib(int N) {
            int a = 0, b = 1, c = 0;
            if (N == 0)
                return a;
            else if (N == 1)
                return b;
            else {
                for (int i = 2; i <= N; i++) {
                    c = a + b;
                    a = b;
                    b = c;
                }
                return c;
            }
        }
    }
}
