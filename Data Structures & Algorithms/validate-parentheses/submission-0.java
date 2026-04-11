class Solution {
    public boolean isValid(String s) {
                if(s ==null || s.length() < 0 || s.length() %2 == 1)
        return false;

        Map<Character,Character> parantheses = new HashMap<>();
        parantheses.put(')','(');
        parantheses.put('}','{');
        parantheses.put(']','[');

        Stack<Character> paraStack = new Stack<Character>();

        for(char ch : s.toCharArray()){
            if(!paraStack.isEmpty() && parantheses.containsKey(ch)){ //current character is a closing char
            //check what is ton the yop;
                char topChar = paraStack.pop();
                if(parantheses.get(ch) != topChar)
                return false;

            }else{
                paraStack.push(ch);
                
            }
        }
        return paraStack.isEmpty();
    }
}
