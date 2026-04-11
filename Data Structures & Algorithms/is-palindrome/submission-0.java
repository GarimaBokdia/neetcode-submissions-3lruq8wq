class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int begin=0,end=len-1;
        while(begin <= end){
            char beginChar = s.charAt(begin);
            char endChar = s.charAt(end);
            if(!isValidCharacter(beginChar) ){
                begin++;
                continue;
            }
            if(!isValidCharacter(endChar)  ){
                end--;
                continue;
            }
            if(Character.toLowerCase(beginChar) != Character.toLowerCase(endChar) ){
                return false;
            }
            begin++;
            end--;
        }

        return true;
    }

    public static boolean isValidCharacter(char ch){
        if((ch >= 'a' && ch <= 'z') || (  ch >= 'A' && ch <= 'Z')|| (  ch >= '0' && ch <= '9')){
            return true;
        }
        return false;
    }
}
