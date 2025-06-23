class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n-k+1];

        for(int i = 0; i < n; i++){
            while(!dq.isEmpty() && dq.peekFirst() < i-k+1){
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.removeLast();
            }

            dq.addLast(i);

            if(i >= k-1){
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        } 

        return res;
    }
}