class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int current = nums[0];
        int i = 1;
        if(nums.length == 1) return nums[0];
        while(i<nums.length){
            current = Math.max(nums[i], current+nums[i]);
            max = Math.max(current, max);
            i++;
        }
        return max;
    }
}