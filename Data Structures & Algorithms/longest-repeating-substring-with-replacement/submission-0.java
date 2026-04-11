class Solution {
    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        int left=0,right=0, maxLen=0,maxFreq=0,n = s.length();

        for(;right<n;right++)
        {
            charCount[s.charAt(right)-'A']++;

            maxFreq = Math.max(maxFreq,charCount[s.charAt(right)-'A']);

            int currWindow = right-left+1;

            if(currWindow - maxFreq <= k){
                maxLen = Math.max(maxLen,currWindow);
            }else{
                charCount[s.charAt(left)-'A']--;
                left++;
            }

        }

        return maxLen;
    }
}