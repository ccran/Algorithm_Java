package leetcode_tags.HashTable;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example:
 * <p>
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class Count_Primes {
    class Solution {
        public boolean isPrime(int num) {
            int tmp = (int) Math.sqrt(num);
            for (int i = 2; i <= tmp; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }

        public int countPrimes(int n) {
            int cnt = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime(i))
                    cnt++;
            }
            return cnt;
        }
    }
}
