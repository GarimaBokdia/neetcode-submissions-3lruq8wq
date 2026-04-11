class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length <1)
        return -1;
        int n = nums.length;
        int sum = n * (n+1) >> 1  ; //{this is equivaltes to divided by 2}
        int arrSum = Arrays.stream(nums).sum();
        return (sum - arrSum);
    }
}
