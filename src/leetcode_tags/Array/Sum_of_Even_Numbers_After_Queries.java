package leetcode_tags.Array;

public class Sum_of_Even_Numbers_After_Queries {
    class Solution {
        public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
            int sum = 0;
            for (int elem : A)
                if (elem % 2 == 0) sum += elem;
            int[] res = new int[queries.length];
            int cnt = 0;
            for (int i = 0; i < queries.length; i++) {
                int val = queries[i][0], index = queries[i][1];
                if (A[index] % 2 == 0) sum -= A[index];
                A[index] += val;
                if (A[index] % 2 == 0) sum += A[index];
                res[cnt++] = sum;
            }
            return res;
        }
    }
}
