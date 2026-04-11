class Solution {
    public int getSum(int a, int b) {
        // Iterate until there is no carry left
        while (b != 0) {
            // Step 1: Calculate the carry (bits where both are 1)
            // We shift left because carry adds to the next position
            int carry = (a & b) << 1;
            
            // Step 2: Add without carry (XOR simulates simple addition)
            a = a ^ b;
            
            // Step 3: The carry becomes the new 'b' to add in the next iteration
            b = carry;
        }
        
        return a;
    }
}