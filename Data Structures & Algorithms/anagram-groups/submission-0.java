class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList();
        Map<String, List<String>> groupings = new HashMap<>();
        
        char[] currArr ;
        for(String currStr: strs){
            currArr = new char[26];
            for(char curr : currStr.toCharArray())
            {
                currArr[curr-'a']++;
            }
            String uniqueKey = String.valueOf(currArr);
            if(groupings.containsKey(uniqueKey))
            {
                groupings.get(uniqueKey).add(currStr); 
            }
            else
            {
                List<String> lstStrs = new ArrayList<>();
                lstStrs.add(currStr);
                groupings.put(uniqueKey,lstStrs);       
            }          
             
        }

        for(String key : groupings.keySet()){
            result.add(groupings.get(key));
        }

        return result;
    }
}
