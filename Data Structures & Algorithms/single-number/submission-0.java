class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length <1)
        return -1;

        //XOR
        int uniq =0 ; 
        for(int n : nums){
            uniq = uniq ^ n;
        }

        return uniq;
    }
}