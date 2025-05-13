class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] output = new int[nums.length];

        prefix[0] = 1;

        for(int i = 1; i<nums.length; i++){
            prefix[i] = nums[i-1] * prefix[i-1];
        }

        int suffixProd = 1;

        for(int i = nums.length-1; i >= 0; i--){
            output[i] = prefix[i] * suffixProd;
            suffixProd *= nums[i];
        }

        return output;
    }
}