public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int pt1 = -1, max=-1, seat_index = 0;

        for(int i = 0; i < seats.length; i++){
            if (seats[i] == 1){
                //update max
                if((i - pt1)> max){
                    max = i - pt1;
                    if(pt1 == -1 && i != 0){
                        seat_index = 0;
                    }
                    else{
                        seat_index = (pt1 + i)/2;
                    }

                }
                //save last person index
                pt1 = i;
            }
        }
        //edge
        if(( seats.length-1  - pt1)> max){
            return seats.length - 1;
        }

        return seat_index;
    }
}
