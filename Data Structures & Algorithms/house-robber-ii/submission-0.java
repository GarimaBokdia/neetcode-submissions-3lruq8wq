class Solution {
    public int rob(int[] nums) {
        if ( nums == null || nums.length == 0)
            return 0;
        
        if(nums.length == 1)
            return nums[0];
        
        int N = nums.length;
        //checking two scenario 
        return Math.max(robbery(nums,0,N-2), robbery(nums,1,N-1));
    }

    private int robbery(int[] nums, int beginIndex,int endIndex){
        int prev2=0,prev1=0;
        for(int i=beginIndex; i<=endIndex; i++){
            int current = Math.max(nums[i]+prev2, prev1);
            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }
}