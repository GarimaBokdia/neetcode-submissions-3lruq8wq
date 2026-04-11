class Solution {
    public int longestConsecutive(int[] nums) {
         if(nums ==null || nums.length <1)
        return nums.length;
        
        Set<Integer> uniqueNums = Arrays.stream(nums).boxed().collect(Collectors.toSet());
   
        int longestSeq=1 ;

        for(int num : uniqueNums){
            if(!uniqueNums.contains(num-1))
            {
                int currStreak =1;
                while(uniqueNums.contains(num+1)){
                    currStreak++;
                    num++;
                }
                  longestSeq = Math.max(longestSeq,currStreak);
            }
          
        }

        return longestSeq;
    }
}
