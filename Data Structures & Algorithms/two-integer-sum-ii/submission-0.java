class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers==null || numbers.length <2)
         return new int[]{};

            int N = numbers.length;
            int begin =0, end = N-1;

            while(begin <end){
               int currSum = numbers[begin]+numbers[end];
               if(currSum == target){
                return new int[]{begin+1,end+1};
               }
               else if(currSum < target){
                begin++;
               }else{
                end--;
               }
            } 

            return new int[]{-1,-1};
    }
}
