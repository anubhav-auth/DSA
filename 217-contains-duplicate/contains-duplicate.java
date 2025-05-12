class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> ha = new HashSet<>();
        for(int i: nums){
            if(ha.contains(i)) return true;
            else ha.add(i);
        }
        return false;
    }
}