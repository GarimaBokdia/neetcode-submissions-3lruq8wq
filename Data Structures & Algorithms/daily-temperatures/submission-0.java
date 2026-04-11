class Solution {
    /* Finds the number of days to wait for a warmer temperature using a Monotonic Stack.
     * Time Complexity: O(n) - Each index is pushed and popped at most once.
     * Space Complexity: O(n) - For the answer array and the stack in the worst case.
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        
        // Deque is preferred over Stack class in Java for LIFO operations
        // Stores the indices of days in decreasing order of temperature
        Deque<Integer> stack = new ArrayDeque<>(); 
        
        for (int i = 0; i < n; i++) {
            int currentTemp = temperatures[i];
            
            // While the stack is not empty AND the current temperature is warmer 
            // than the temperature at the index on top of the stack:
            while (!stack.isEmpty() && currentTemp > temperatures[stack.peek()]) {
                
                // The index whose warmer day we just found
                int prevIndex = stack.pop();
                
                // Calculate the number of days to wait (index difference)
                answer[prevIndex] = i - prevIndex;
            }
            
            // Push the current day's index onto the stack
            stack.push(i);
        }
        
        // Days whose indices remain in the stack have no warmer future day, 
        // and their answer[i] remains 0 (the initial value).
        return answer;
    }
}
