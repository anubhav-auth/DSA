class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos = 0;
        int neg = 1;
        int [] arr = new int[nums.length];

        for(int i = 0; i<nums.length; i++){
            if(nums[i]<0) {
                arr[neg] = nums[i];
                
                if(neg != nums.length-1) neg += 2;
            }else{
                arr[pos] = nums[i];
                if(pos != nums.length-2) pos +=2;
            }
        }
        return arr;
    }
}