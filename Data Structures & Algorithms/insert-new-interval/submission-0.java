class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> results = new ArrayList<>();
        int i =0 , N = intervals.length;

        while(i < N && intervals[i][1] < newInterval[0]){
            results.add(intervals[i]);
            i++;
        }
        while(i < N && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;

        }
        results.add(newInterval);
        while(i < N){
            results.add(intervals[i]);
            i++;
        }
            
        return results.toArray(new int[results.size()][]);

    }
}