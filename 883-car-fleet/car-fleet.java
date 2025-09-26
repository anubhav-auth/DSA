class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        double[] arr = new double[target];

        for(int i = 0; i < position.length; i++){
            arr[position[i]] = (double)(target-position[i])/speed[i];
        }

        double leader_time = 0.0;
        int fleet_no = 0;

        for(int i = arr.length-1; i >= 0; i--){
            if(arr[i] > leader_time){
                fleet_no++;
                leader_time = arr[i];
            }
        }

        return fleet_no;
    }
}