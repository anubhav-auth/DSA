class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length; 
        int[] prefix = new int[l];
        int[] output = new int[l];

        prefix[0] = 1;

        for(int i = 1; i<l; i++){
            prefix[i] = nums[i-1] * prefix[i-1];
        }

        int suffixProd = 1;

        for(int i = l-1; i >= 0; i--){
            output[i] = prefix[i] * suffixProd;
            suffixProd *= nums[i];
        }

        return output;
    }
}