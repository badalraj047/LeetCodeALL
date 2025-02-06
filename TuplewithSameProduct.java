// This Problem contains my solution to the [LeetCode "Tuple with Same Product" problem] - https://leetcode.com/problems/tuple-with-same-product/
// To run this code in VS Code, you need to:
// Add a main method to execute the code.
// Ensure your Java setup is correct (JDK installed and configured).

// 1726. Tuple with Same Product
// Problem Statement:

// Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d) such that a * b = c * d where a, b, c, and d are elements of nums, and a != b != c != d.

// Example 1:
// Input: nums = [2,3,4,6]
// Output: 8
// Explanation: There are 8 valid tuples:
// (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
// (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)

// Example 2:
// Input: nums = [1,2,4,5,10]
// Output: 16
// Explanation: There are 16 valid tuples:
// (1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
// (2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
// (2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,5,4)
// (4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2) 

// Constraints:

// 1 <= nums.length <= 1000
// 1 <= nums[i] <= 104
// All elements in nums are distinct.

// Solution:

class Solution {
    public int tupleSameProduct(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i){
            for (int j = 0; j < i; ++j) {
                int curr = nums[i]*nums[j];
                ans += 8* map.getOrDefault(curr, 0);
                map.put(curr, map.getOrDefault(curr, 0)+1);
            }
        }
        return ans;
    }
}


