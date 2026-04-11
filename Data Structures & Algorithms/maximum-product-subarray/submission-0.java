class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }

        int minProdSoFar = nums[0] , maxProdSoFar = nums[0] , maxProduct = maxProdSoFar;

        for(int i=1; i< nums.length; i++){
            int num = nums[i];
            int currProd = Math.max(num,Math.max(num * minProdSoFar,num * maxProdSoFar));
            minProdSoFar = Math.min(num,Math.min(num * minProdSoFar,num * maxProdSoFar));
            maxProdSoFar = currProd;
            maxProduct = Math.max(maxProduct,maxProdSoFar);
        }

        return maxProduct;
    }
}