class Car{
    int pos;
    double arrival;

    Car(int pos, double arrival){
        this.pos = pos;
        this.arrival = arrival;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        Car[] arr = new Car[position.length];

        for(int i = 0; i < position.length; i++){
            arr[i] = new Car(position[i], (double)(target-position[i])/speed[i]);
        }

        Arrays.sort(arr, (a,b) -> Integer.compare(b.pos, a.pos));

        double leader_time = 0.0;
        int fleet_no = 0;

        for(Car car: arr){
            if(car.arrival > leader_time){
                fleet_no++;
                leader_time = car.arrival;
            }
        }

        return fleet_no;
    }
}