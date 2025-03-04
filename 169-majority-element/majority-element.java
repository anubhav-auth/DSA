class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 0;
        int i= 0;
        int val = nums[i]; 


        while(i < nums.length){
            if(count == 0){
                val = nums[i];
            }
            if(val == nums[i]) count++;
            else count--;
            i++;
        }
        return val;
    }
}