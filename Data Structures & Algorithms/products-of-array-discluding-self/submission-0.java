class Solution {
    public int[] productExceptSelf(int[] nums) {
          if(nums==null || nums.length <1)
        return new int[]{};

        int N = nums.length;
        int[] answer = new int[N];

        //Lets traverse through teh array and keep the product till the left point
        int leftProduct=1;
        for(int i=0; i<N ; i++){        
            answer[i] = leftProduct;
            leftProduct = leftProduct*nums[i];
        }
     

        int rightProduct =1;
        for(int i=N-1; i>=0;i--){
            answer[i] = answer[i] *rightProduct;
            rightProduct = rightProduct * nums[i];
           
        }

        return answer;
    }
}  
