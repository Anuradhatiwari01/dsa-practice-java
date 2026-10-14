class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int n = time.length;

        long min = Long.MAX_VALUE;
        for(int t : time){
            min = Math.min(min, t);
        }
        long l = 1;
        long r = min * totalTrips;

        while(l < r){
            long midTime = l + (r-l)/2;
            if(isPossible(time, midTime, totalTrips)){
                r = midTime;
            }
            else{
                l = midTime + 1;
            }
        }
        return r;
    }

    public boolean isPossible(int[] time, long midTime, int totalTrip){
        long actualTrip = 0;

        for(int t : time){
            actualTrip += midTime/t;

            if(actualTrip >= totalTrip){
                return true;
            }
        }
        return false;
    }
}