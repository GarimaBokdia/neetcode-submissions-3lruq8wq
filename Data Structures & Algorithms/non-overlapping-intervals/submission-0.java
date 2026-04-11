class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;
        
        //sorting the array
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);

        int prevEnd = intervals[0][1]; //previous end
        int removeCount=0;
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] < prevEnd){
                 // OVERLAP DETECTED!
                // We must remove one. We greedily remove the one that ends later.
                removeCount++;
                
                // Update prevEnd to be the minimum of the two.
                // (Effectively "keeping" the one that ends sooner)
                prevEnd = Math.min(prevEnd,intervals[i][1]);
            }else{
                // NO OVERLAP
                // Just update the pointer to the new end
                prevEnd = intervals[i][1];
            }
        }

        return removeCount;
    }
}
