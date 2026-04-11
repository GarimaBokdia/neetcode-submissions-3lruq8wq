class Solution {
    public int[][] merge(int[][] intervals) {
      

        //Sort by start time
        Arrays.sort(intervals,(a,b) -> (a[0] - b[0]));
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] prevInterval = intervals[0];
   mergedIntervals.add(prevInterval);

        for(int i=1; i< intervals.length; i++){
            int[] currInterval = intervals[i];
            if(currInterval[0] > prevInterval[1]){
               mergedIntervals.add(currInterval);
               prevInterval = currInterval;
            }
            else{
                prevInterval[1] = Math.max(prevInterval[1],currInterval[1]);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);

    }
}