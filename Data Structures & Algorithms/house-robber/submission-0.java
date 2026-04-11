class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length==0)
         return 0;
        
        int N = nums.length;
        if(N == 1)
            return nums[0];

    //dp is storing accumulated values
    /*    int[] dp = new int[N];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);       
        for(int i=2; i<N; i++){
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]); 
        }

        return dp[N-1];*/

        int prev2=0,prev1 =0;
       
        for(int i=0; i<N; i++){
           int current = Math.max(nums[i]+prev2,prev1);
            prev2= prev1;
            prev1 = current;
        }

        return prev1;
    }
}