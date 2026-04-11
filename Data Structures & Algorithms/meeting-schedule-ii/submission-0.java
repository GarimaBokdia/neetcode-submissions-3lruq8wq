/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
            if(intervals == null || intervals.size() < 1)
                return 0;
            
            int N = intervals.size();
            int[] startTime = new int[N], endTime = new int[N];
        //separating the start and end times
        for(int i=0; i < N; i++){
            startTime[i] = intervals.get(i).start;
            endTime[i] = intervals.get(i).end;
        }
        //Sorting these arrays
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        //Analogy
        //whenever a meeting starts we give it a room and whene ever a meeting ends it releases the room ;
        // if the meeting starts after ending time then we can reoccupy thta same room
        int endIndex=0;
        int rooms =0;
        for(int startIndex=0; startIndex<N ; startIndex++){
            if(startTime[startIndex] < endTime[endIndex]){
                rooms++;
            }else{
                endIndex++;
            }
        }

        return rooms;
    }
}
