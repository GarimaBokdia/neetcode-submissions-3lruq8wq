class Solution {
    public boolean checkValidString(String s) {
        if(s==null || s.isEmpty()){
            return true;
        }

        Stack<Integer> openIndices = new Stack<>();
        Stack<Integer> starIndices = new Stack<>();

        for(int i=0; i< s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                openIndices.push(i);
            }
            else if(ch == '*'){
                starIndices.push(i);
            }
            else{
                if(!openIndices.isEmpty()){
                    openIndices.pop();
                }else if(!starIndices.isEmpty()){
                    starIndices.pop();
                }else{
                    return false;
                }
            }

        }

        while(!openIndices.isEmpty() && !starIndices.isEmpty()){
            if(openIndices.peek() > starIndices.peek()){
                return false;
            }
            openIndices.pop();
            starIndices.pop();
        }

        return openIndices.isEmpty();
    }
}
