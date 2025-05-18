class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] h = new int[heights.length + 1];
        System.arraycopy(heights, 0, h, 0, heights.length);
        h[h.length - 1] = 0;

        Stack<Integer> s = new Stack<>();
        int max = 0;

        for(int i = 0; i<h.length; i++){
            while(!s.empty() && h[i] < h[s.peek()]){
                int he = h[s.pop()];
                int b = (s.empty())? i : i - s.peek() - 1;
                max = Math.max(he*b, max);
            }
            s.push(i);
        }

        return max;
    }
}