class Solution {
     class Car {
        int position;
        int speed;
        double timeToTarget;
        public Car(int p, int s, int target) {
            this.position = p;
            this.speed = s;
            this.timeToTarget = (double) (target - p) / s;
        }

    }
    public int carFleet(int target, int[] position, int[] speed) {
        if(position == null || speed == null) 
        return 0;   
        int N = position.length;
        Car[] lstCars = new Car[N];
        for(int i=0; i<N; i++)
        {
            lstCars[i] = new Car(position[i], speed[i], target);
        }
        Arrays.sort(lstCars,new Comparator<Car>(){
            @Override
            public int compare(Car a, Car b){
                return b.position - a.position;
            }
        });
    
    //Now we have cards sorted by the leaders chances by positrion .. so the time to reach the taget

        int fleetCount = 0;
        double maxTimeSeen = 0.0; // Arrival time of the current slowest fleet leader
        for(Car car : lstCars){
            if(car.timeToTarget > maxTimeSeen ){
                fleetCount++;
                maxTimeSeen= car.timeToTarget;
            }
        }
        return fleetCount;

    }
    
}