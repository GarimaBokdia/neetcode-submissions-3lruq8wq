class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>();
        int min=0,max=0;

        for(String word: wordDict){
             min= Math.min(min,word.length());
             max= Math.max(max,word.length());
            wordDictSet.add(word);
        }
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true; //empty string as valid
        for(int curr = 1 ; curr <= len ; curr++){
            for(int begin = 0 ; begin < curr ; begin++){
                //optimisation
                 String currStr = s.substring(begin,curr);
                int currLen = currStr.length();
                if(currLen < min || currLen > max){
                    continue;
                }
                //valid checkes
               
                if(dp[begin] && wordDictSet.contains(currStr)){
                    dp[curr] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}