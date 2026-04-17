class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
       Arrays.sort(nums);
       for(int i=1;i<nums.length;i++){
        if(nums[i] == nums[i-1])
            return nums[i];
       }

       return 0;
    }
}
