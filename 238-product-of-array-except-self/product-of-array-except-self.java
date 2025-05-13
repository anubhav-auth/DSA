class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length; 
        int[] prefix = new int[l];
        int[] suffix = new int[l];
        int[] output = new int[l];
        
        prefix[0] = 1;
        suffix[l-1] = 1;

        for(int i = 1; i<l; i++){
            prefix[i] = nums[i-1] * prefix[i-1];
        }

        for(int i = l-2; i>=0; i--){
            suffix[i] = nums[i+1] * suffix[i+1];
        }

        for(int i = 0; i<l; i++){
            output[i] = prefix[i] * suffix[i];
        }

        return output;
    }
}