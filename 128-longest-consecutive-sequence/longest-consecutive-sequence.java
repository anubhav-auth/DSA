class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Set<Integer> s = new HashSet<>();
        for(int i: nums) s.add(i);

        int max = 1;
        
        for(int i: s){
            if(!s.contains(i-1)){
                int x = i;
                int count = 1;
                while(s.contains(x+1)){
                    count++;
                    x += 1;
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }
}