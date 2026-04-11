class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length<1)
            return false;

        int reachableDistance = 0;
        for(int pos=0; pos < nums.length ; pos++){
            if(pos > reachableDistance){
                return false;
            }

            reachableDistance= Math.max(reachableDistance,pos+nums[pos]);

            if(reachableDistance >= nums.length-1)
                return true;
        }
        return true;
    }
}