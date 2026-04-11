class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high=0;
        for(int p : piles){
            high = Math.max(p,high);
        }
        int minK = high;
        while(low <= high){
            int mid = low + (high - low)/2;
            int timeNeeded = calculateTimeNeeded(piles,mid);
            if(timeNeeded <= h){
                minK = mid;
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return minK;
    }
    private int calculateTimeNeeded(int[] piles, int speed){
        int timeNeeded=0;
        for(int p : piles){
            timeNeeded = timeNeeded + (p+speed-1)/speed;
        }
        return timeNeeded;
    }
}
