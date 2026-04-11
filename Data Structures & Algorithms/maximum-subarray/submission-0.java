class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length <1)
        return 0;

        int currentSum = 0, maxSum = nums[0];
        for(int num : nums){
            currentSum = Math.max(num, currentSum + num);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

//Kandanes Algorithm