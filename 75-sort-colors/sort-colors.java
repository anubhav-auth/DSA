class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int index = 0;
        while(index <= end){
            if(nums[index] == 0){
                int temp = nums[start];
                nums[start] = nums[index];
                nums[index] = temp;
                start++;
                index++;
            }else if(nums[index] == 2){
                int temp = nums[end];
                nums[end] = nums[index];
                nums[index] = temp;
                end--;
            }else{
                index++;
            }

        }
    }
}