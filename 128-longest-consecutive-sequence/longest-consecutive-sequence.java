class Solution {
    public int longestConsecutive(int[] nums) {
        int l = nums.length;

        if(l == 0) return 0;

        Set<Integer> s = new TreeSet<>();
        for(int i: nums) s.add(i);

        int max = 1;
        int count = 1;
        
        for(int i: s){
            if(!s.contains(i-1)){
                int x = i;
                count = 1;
                while(s.contains(x+1)){
                    count++;
                    x += 1;
                }
            }

            max = Math.max(max, count);
        }

        return max;
    }
}