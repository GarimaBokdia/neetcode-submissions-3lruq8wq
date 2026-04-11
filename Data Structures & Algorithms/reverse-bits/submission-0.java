class Solution {
    /*
    The Java Specifics
n & 1: Retrieves the last bit (0 or 1).

result << 1: Shifts bits to the left (e.g., 001 becomes 010).

n >> 1: Shifts bits to the right (e.g., 110 becomes 011).

Why loop 32 times? Even if n becomes 0 early (e.g., n = 1), we must continue shifting result to ensure the 1 ends up at the very front (the 32nd position), not just in the middle.
 */
    public int reverseBits(int n) {
        int result=0;
        for(int i=0; i<32; i++){
           // 1. Shift result to the left to open up the LSB spot
            result = result << 1;
            // 2. Get the last bit of n
            int bit = n & 1;         
            // 3. Add the extracted bit to the LSB of result
            result = result | bit; // OR operation adds the bit           
            // 4. Shift n to the right to process the next bit
            n = n >> 1;
        }
        return result;
    }


    /**
    Follow-up: Optimization (The "Byte" Strategy)Question: If this function is called millions of times, how do we optimize it?Answer: We use Memoization (Caching) with a lookup table.Instead of reversing 32 bits bit-by-bit, we split the integer into 4 bytes (8 bits each).We pre-compute the reverse of every possible 8-bit number ($0$ to $255$) and store it in an array cache[256].To reverse a 32-bit integer, we just break it into 4 bytes, look up their reversed versions, and place them in the correct opposite positions.Formula:Reverse(Byte0 Byte1 Byte2 Byte3) = Reverse(Byte3) Reverse(Byte2) Reverse(Byte1) Reverse(Byte0)This reduces the work from 32 bitwise operations to 4 lookups and some bit masking. This is significantly faster for high-throughput systems.
    
    public class Solution {
    // 1. The Lookup Table (Cache)
    // Stores the reversed version of every number from 0 to 255.
    private static final int[] cache = new int[256];

    // 2. Pre-computation Block
    // This runs only ONCE when the class is loaded into memory.
    static {
        for (int i = 0; i < 256; i++) {
            cache[i] = reverseByte(i);
        }
    }

    // Helper to reverse a single 8-bit byte (used only during init)
    private static int reverseByte(int b) {
        int result = 0;
        for (int i = 0; i < 8; i++) {
            result = (result << 1) | (b & 1);
            b >>= 1;
        }
        return result;
    }

    // 3. The Optimized Function
    public int reverseBits(int n) {
        // Step A: Extract the 4 bytes from the 32-bit integer
        // Use 0xFF (binary 11111111) to mask and get exactly 8 bits
        int byte0 = n & 0xFF;              // Least significant byte
        int byte1 = (n >> 8) & 0xFF;
        int byte2 = (n >> 16) & 0xFF;
        int byte3 = (n >>> 24) & 0xFF;     // Use >>> to handle sign bit safely!

        // Step B: Look up the reversed version of each byte
        // Step C: Place them in the REVERSE positions
        // byte0 (was last) -> Goes to front (shift left 24)
        // byte3 (was first) -> Goes to end (no shift)
        return (cache[byte0] << 24) |
               (cache[byte1] << 16) |
               (cache[byte2] << 8)  |
               cache[byte3];
    }
}


    
     */
}