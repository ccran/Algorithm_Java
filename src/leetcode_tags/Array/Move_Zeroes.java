package leetcode_tags.Array;

import java.util.LinkedList;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * <p>
 * 在不改变原有数字顺序的前提下将0全部移动到最后
 */
public class Move_Zeroes {
    static class Solution {
        public void moveZeroes(int[] nums) {
            LinkedList<Integer> empty = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    empty.add(i);
                } else {
                    if (!empty.isEmpty()) {
                        nums[empty.poll()] = nums[i];
                        empty.add(i);
                    }
                }
            }
            while (!empty.isEmpty()) {
                nums[empty.poll()] = 0;
            }
        }

        //对于插入的位置无需存入队列中
        public void moveZeros_Most_Votes(int[] nums){
            if (nums == null || nums.length == 0) return;

            int insertPos = 0;
            for (int num: nums) {
                if (num != 0) nums[insertPos++] = num;
            }

            while (insertPos < nums.length) {
                nums[insertPos++] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        Solution solution = new Solution();
        solution.moveZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
