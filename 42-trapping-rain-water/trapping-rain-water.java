class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int l = 0;
        int r = height.length - 1;
        int leftMax = 0; 
        int rightMax = 0;
        int count = 0;
        
        while (l < r) {
            if (height[l] < height[r]) {
                
                if (height[l] >= leftMax) {
                    leftMax = height[l];
                } else {
                    count += leftMax - height[l];
                }
                l++;
                
            } else {
                if (height[r] >= rightMax) {
                    rightMax = height[r];
                } else {
                    count += rightMax - height[r];
                }
                r--;
            }
        }
        return count;
    }
}