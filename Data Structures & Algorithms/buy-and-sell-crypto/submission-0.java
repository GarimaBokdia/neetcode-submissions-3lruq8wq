class Solution {
    public int maxProfit(int[] prices) {
        int profit =0, minPrice = Integer.MAX_VALUE;
        for (int currPrice : prices){
            if(currPrice < minPrice){
                minPrice = currPrice ;
                continue;
            }
            profit = Math.max(profit, currPrice-minPrice);
        }
        return profit;
    }
}
