class Solution {
    public int climbStairs(int n) {
        //dp
        if(n<=1)
            return n;
   
        /*int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2;i<n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];*/
        
   int first =1;
        int second = 2;
        int current =0;
        for(int i=2; i<n; i++){
            current = first+second;
            first = second;
            second= current;
        }
        return second;
    }
}