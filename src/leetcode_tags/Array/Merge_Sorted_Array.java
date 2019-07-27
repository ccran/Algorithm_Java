package leetcode_tags.Array;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */
public class Merge_Sorted_Array {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int sumLen = m + n;
            int[] res = new int[sumLen];
            int cnt = 0, a = 0, b = 0;
            while (a < m && b < n) {
                while (a<m && nums1[a] <= nums2[b]) res[cnt++] = nums1[a++];
                if(a>=m) break;
                while (b<n && nums1[a] > nums2[b]) res[cnt++] = nums2[b++];
            }
            while (a < m) {
                res[cnt++] = nums1[a++];
            }
            while (b < n) {
                res[cnt++] = nums2[b++];
            }
            for (int i = 0; i < sumLen; i++) {
                nums1[i] = res[i];
            }
        }
    }
}
