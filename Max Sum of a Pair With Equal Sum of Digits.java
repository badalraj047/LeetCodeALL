// This Problem contains my solution to the [LeetCode "2342. Max Sum of a Pair With Equal Sum of Digits" problem] - https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
// To run this code in VS Code, you need to:
// Add a main method to execute the code.
// Ensure your Java setup is correct (JDK installed and configured).

// 2342. Max Sum of a Pair With Equal Sum of Digits
// Problem Statement:

// You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].
// Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.

// Example 1:
// Input: nums = [18,43,36,13,7]
// Output: 54
// Explanation: The pairs (i, j) that satisfy the conditions are:
// - (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
// - (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
// So the maximum sum that we can obtain is 54.

// Example 2:
// Input: nums = [10,12,19,14]
// Output: -1
// Explanation: There are no two numbers that satisfy the conditions, so we return -1.

// Constraints:

// 1 <= nums.length <= 10^5
// 1 <= nums[i] <= 10^9

// Solution:

class Solution {
    private int getDigitSum(int val) {
        int sum = 0;
        while (val != 0) {
            sum += val % 10;
            val /= 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {
        Map<Integer, Integer> sumMaxVal = new HashMap<>();
        int maxSum = -1;

        for (int ele : nums) {
            int digitSum = getDigitSum(ele);
            if (sumMaxVal.containsKey(digitSum)) {
                maxSum = Math.max(maxSum, ele + sumMaxVal.get(digitSum));
                if (sumMaxVal.get(digitSum) < ele) {
                    sumMaxVal.put(digitSum, ele);
                }
            } else {
                sumMaxVal.put(digitSum, ele);
            }
        }

        return maxSum;
    }
}


