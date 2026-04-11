class Solution {
    public int countSubstrings(String s) {
        if(s==null || s.length() < 1)
        return 0;
        int count=0;
        for(int i=0; i<s.length(); i++){
            count += expandFromCentre(s,i,i);
            count += expandFromCentre(s,i,i+1);
            
        }
        return count;
    }

      private int expandFromCentre(String s,int left, int right)
    {
        int found=0;
        while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            found++;
            left--;
            right++;
        }
//Why right - left - 1? When the while loop breaks, left and right are pointing to the first mismatch (or out of bounds).
// Return length. Note: (right - 1) - (left + 1) + 1 simplifies to right - left - 1
        return found ;
    }
}