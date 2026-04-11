class Solution {
    public int maxArea(int[] height) {
        int left = 0 , right = height.length-1;
        int resultArea = 0;
        while(left<right){
            int width = right-left;
            int currHeight = Math.min(height[left],height[right]);
            resultArea = Math.max(resultArea , currHeight * width);
            if(height[left] <= height[right])
                left++;
            else
                right--;
        }
        return resultArea;
    }
}