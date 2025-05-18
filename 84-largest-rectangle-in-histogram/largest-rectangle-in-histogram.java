class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] h = new int[heights.length + 1];
        System.arraycopy(heights, 0, h, 0, heights.length);
        h[h.length - 1] = 0;

        Deque<Integer> s = new ArrayDeque<>();
        int max = 0;

        for(int i = 0; i<h.length; i++){
            while(!s.isEmpty() && h[i] < h[s.peek()]){
                int he = h[s.pop()];
                int b = (s.isEmpty())? i : i - s.peek() - 1;
                max = Math.max(he*b, max);
            }
            s.push(i);
        }

        return max;
    }
}