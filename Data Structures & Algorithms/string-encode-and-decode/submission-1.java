class Solution {
    public static final String DELIMETER = "#";
    public String encode(List<String> strs) {
            StringBuilder encodedFinalString = new StringBuilder();
            //Length of Curr String + Delimeter + String + <Repeat this process for next string ...>
            
            for(String str : strs){
                int len = str.length();
                encodedFinalString.append(len);
                 encodedFinalString.append(DELIMETER);
                  encodedFinalString.append(str);
            }
            return encodedFinalString.toString();
    }

    public List<String> decode(String str) {
        //For the string we should identify the , length and separators and then the word itself
        int begin=0,end=0;
        int len = str.length();
        List<String> decodedList = new ArrayList<>();
        while(begin < len)
        {
             System.out.println("str"+str);
            //Find the index of first delimeter starting from the begin position
            int delimPos = str.indexOf(DELIMETER,begin);
            if(delimPos == -1){
                return decodedList; 
            }
           System.out.println("delimPos"+delimPos);
          
            int lenStr =  Integer.parseInt(str.substring(begin,delimPos)); //NUmbewrFormatException
            if(lenStr < 0)
            return decodedList;
            begin=delimPos+1;
            end = begin+lenStr;
             System.out.println("begin"+begin);

             System.out.println("end"+end);
            String currStr = str.substring(begin,end);
            decodedList.add(currStr);
            begin = end;

        }

        return decodedList;
    }
}
