class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0, right =0, maxLen =0 , n= s.length();
        int bestStart = 0;
        Set<Character> subStr = new HashSet<>();
        while(right < n){
            if(!subStr.contains(s.charAt(right))){
                subStr.add(s.charAt(right++));
                 int currLen = right -left;
                 if(currLen > maxLen){
                    maxLen = currLen;
bestStart=left;
                 }
                
            }
            else{             
                    subStr.remove(s.charAt(left));
                    left++;
            }
           
        }
        //System.out.println(s.substring(bestStart,bestStart+maxLen));
        return maxLen;
    }
}