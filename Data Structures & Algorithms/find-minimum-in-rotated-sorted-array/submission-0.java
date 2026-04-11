class Solution {
    public int findMin(int[] nums) {
        // If the array is empty or null (optional safety check)
        if (nums == null || nums.length == 0) return -1;
        
        // If array has 1 element, it is the min
        if (nums.length == 1) return nums[0];

        int low = 0;
        int high = nums.length - 1;

        // If the array is not rotated (already sorted)
        if (nums[low] < nums[high]) {
            return nums[low];
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid is greater than high, the min must be to the right
            // Example: [4, 5, 6, 0, 1, 2], mid=6, high=2. 6 > 2.
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } 
            // If mid is smaller than high, the min is at mid or to the left
            // Example: [6, 0, 1, 2], mid=0, high=2. 0 < 2.
            else {
                high = mid;
            }
        }

        // When low == high, we found the minimum
        return nums[low];
    }
}