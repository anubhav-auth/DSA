class Solution {
    public int[] nextPermutation(int[] nums) {
        int pivot = -1;

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                pivot = i - 1;
                break;
            }
        }

        if (pivot == -1) {
            Arrays.sort(nums);
            return nums;
        }

        int nextBig = pivot + 1;
        for (int i = pivot + 1; i < nums.length; i++) {
            if (nums[i] > nums[pivot] && nums[i] <= nums[nextBig]) {
                nextBig = i;
            }
        }

        int temp = nums[pivot];
        nums[pivot] = nums[nextBig];
        nums[nextBig] = temp;

        int start = pivot + 1;
        int end = nums.length - 1;
        
        while (start < end) {
            int temp2 = nums[start];
            nums[start] = nums[end];
            nums[end] = temp2;
            start++;
            end--;
        }

        return nums;
    }
}
