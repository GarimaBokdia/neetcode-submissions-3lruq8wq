class MinStack {

    ArrayDeque<Integer> mainStack ,minStack;
    public MinStack() {
        mainStack = new ArrayDeque<Integer>();
        minStack = new ArrayDeque<Integer>();
        
    }
    
    public void push(int val) {
        mainStack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
    }
    
    public void pop() {
        int val = mainStack.pop();
        if(minStack.peek() == val)
            minStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
