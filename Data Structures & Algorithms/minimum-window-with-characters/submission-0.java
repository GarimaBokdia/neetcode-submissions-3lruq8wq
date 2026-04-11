class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        if(s.length() < t.length()){
            return result;
        }

        int[] charMap = new int[128];
        for(char ch : t.toCharArray()){
            charMap[ch]++;
        }

        int matchCount=0;

        int left=0,minWindow=Integer.MAX_VALUE,beginIndex=0;
        for(int right=0; right <s.length(); right++){
            char ch = s.charAt(right);
            // If this char is part of T and we still need it (count > 0), it contributes to match
            if(charMap[ch] > 0){
                matchCount++;
            }
            // Always decrement the map. 
            // If charMap goes negative, it means we have a surplus of this character in the window.
            charMap[ch]--;

            while(matchCount == t.length()){
                int windowSize = right - left + 1;
                if(windowSize < minWindow){
                    minWindow = windowSize;
                    beginIndex = left;
                }

                char leftChar = s.charAt(left);
                charMap[leftChar]++;             
                // If the map becomes positive, it means we effectively removed a 'required' char
                // (we didn't have any surplus to spare)
                if(charMap[leftChar] > 0){
                    matchCount--;
                }
                
                left++;
            }
        }
        if(minWindow != Integer.MAX_VALUE){
            return s.substring(beginIndex,beginIndex+minWindow);
        }
        return result;
    }
}