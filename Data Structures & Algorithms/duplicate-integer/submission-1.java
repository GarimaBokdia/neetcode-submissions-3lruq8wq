class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums != null && nums.length > 1){
            Set<Integer> uniques = new HashSet<>();
            for(int num : nums){
                if(!uniques.contains(num))
                {
                   
                    uniques.add(num);
                }else{
                    return true;
                }
              
            }
        }
        return false;
    }
}