class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int entry = nums[0];
        while (entry != slow) {
            entry = nums[entry];
            slow = nums[slow];
        }

        return entry;
    }
}