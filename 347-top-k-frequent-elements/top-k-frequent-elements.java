class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> h = new HashMap<>();
        Queue<Map.Entry<Integer,Integer>> q = new PriorityQueue<>(k, (a,b)-> Integer.compare(a.getValue(),b.getValue()));
        for(int i: nums){
            h.put(i, h.getOrDefault(i, 0) +1 );
        }
        for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
            q.offer(entry);
            if(q.size() > k){
                q.poll();
            }
        }

        int[] result = new int[k];
        int i = 0;
        while (!q.isEmpty()) {
            result[i++] = q.poll().getKey();
        }

        return result;

    }
}