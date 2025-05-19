class Solution {
    public int maxArea(int[] height) {
        int max = 0, i = 0, j = height.length - 1;

        while (i < j) {
            int hi = height[i];
            int hj = height[j];
            int h = hi < hj ? hi : hj;
            int area = h * (j - i);
            if (area > max) max = area;

            if (hi < hj) i++;
            else j--;
        }

        return max;
    }
}
