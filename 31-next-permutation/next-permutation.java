class Solution {
    public int[] nextPermutation(int[] nums) {
        int pivot = -1; 
        int n = nums.length;

        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                pivot = i - 1;
                break;
            }
        }

        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return nums;
        }

        int nextBig = pivot + 1;
        for (int i = pivot + 1; i < n; i++) {
            if (nums[i] > nums[pivot]) {
                nextBig = i;
            }
        }

        swap(nums, pivot, nextBig);

        reverse(nums, pivot + 1, n - 1);
        
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
