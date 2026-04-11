class Solution {
    public int evalRPN(String[] tokens) {
                if(tokens == null || tokens.length <=0)
            return -1;

        Deque<Integer> rpnStack = new ArrayDeque<>();

        for(String token : tokens){
            if(!"+-*/".contains(token)){
                rpnStack.push(Integer.parseInt(token));
            }else{
                int second = rpnStack.pop();
                int first = rpnStack.pop();
                switch(token){
                    case "+" : rpnStack.push(first + second); break;
                    case "-" : rpnStack.push(first - second) ; break;
                    case "*" : rpnStack.push(first * second) ; break;
                    case "/" : rpnStack.push(first / second) ; break;
                }
            }
        }

        return rpnStack.pop();
    }
}
