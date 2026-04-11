class Solution {

    public static  final char DELIMETER = '#';
    
    public String encode(List<String> strs) {
            if(strs==null || strs.size() ==0)
                return new String();

    StringBuilder encodeString = new StringBuilder();
            for(String str : strs){
                encodeString.append(str.length()).append(DELIMETER).append(str);
            }

            return encodeString.toString();
    }

    public List<String> decode(String str) {
        if(str == null || str.length() == 0)
            return new ArrayList<>();

        int begin =0, len = str.length();
        List<String> decList = new ArrayList<>();
        while(begin < len){
            int delimPos = str.indexOf(DELIMETER,begin);
            if(delimPos == -1)
                return decList;

          int lenStr = Integer.parseInt(str.substring(begin,delimPos));
          begin = delimPos+1;
          int end = begin+lenStr;
        
            if (end > len){
                return decList;
            }
            String word = str.substring(begin,end);
            decList.add(word);
            begin = end;
        


        }
        
        return decList;
    }
}
