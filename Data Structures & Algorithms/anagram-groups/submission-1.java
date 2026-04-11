class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null || strs.length<1)
            return null;
        
        List<List<String>> anagrams = new ArrayList<>();
        
        Map<String,List<String>> groups = new HashMap<>();
        
        for(String str : strs ){
            
          //Create a generic string value for current string , by making a array out of it
            char[] alphs = new char[26];
            for(char ch : str.toCharArray()){
                alphs[ch-'a']++;
            }
            
            String genStr = String.valueOf(alphs);
            
            if(!groups.containsKey(genStr))
            {
                 groups.put(genStr,new ArrayList<String>());
            }
          groups.get(genStr).add(str);
        }
        
        return new ArrayList<>(groups.values());
    }
}