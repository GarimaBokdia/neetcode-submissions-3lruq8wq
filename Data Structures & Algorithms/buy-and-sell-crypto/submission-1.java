class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0 , minPrice = Integer.MAX_VALUE;
        for(int priceToday : prices ){
            if(priceToday < minPrice){
                minPrice = priceToday;
            }else{
                profit = Math.max(profit,priceToday-minPrice);
            }
        }
        return profit;
    }
}
