// This Problem contains my solution to the [LeetCode "3452. Sum of Good Numbers" problem] - https://leetcode.com/problems/sum-of-good-numbers/
// To run this code in VS Code, you need to:
// Add a main method to execute the code.
// Ensure your Java setup is correct (JDK installed and configured).

// 3452. Sum of Good Numbers
// Problem Statement:

// Given an array of integers nums and an integer k, an element nums[i] is considered good if it is strictly greater than the elements at indices i - k and i + k (if those indices exist). 
// If neither of these indices exists, nums[i] is still considered good.
// Return the sum of all the good elements in the array. 

// Example 1:
// Input: nums = [1,3,2,1,5,4], k = 2
// Output: 12
// Explanation:
// The good numbers are nums[1] = 3, nums[4] = 5, and nums[5] = 4 because they are strictly greater than the numbers at indices i - k and i + k.

// Example 2:
// Input: nums = [2,1], k = 1
// Output: 2
// Explanation:
// The only good number is nums[0] = 2 because it is strictly greater than nums[1].

// Constraints:

// 2 <= nums.length <= 100
// 1 <= nums[i] <= 1000
// 1 <= k <= floor(nums.length / 2)

// Solution:

class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum=0;
        for(int i=0; i<nums.length; i++){
            boolean isGood = true;
            if(i-k >= 0 && nums[i-k] >= nums[i]){
                isGood = false;
            }
            if(i+k < nums.length && nums[i+k] >= nums[i]){
                isGood = false;
            }
            if(isGood){
                sum+=nums[i];
            }
        }
        return sum;
    }
}

