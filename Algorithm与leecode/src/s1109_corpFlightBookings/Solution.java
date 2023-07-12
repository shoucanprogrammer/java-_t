package s1109_corpFlightBookings;

public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        for (int[] book : bookings){
            diff[book[0] -1] += book[2];
            if (book[1] < n){
                diff[book[1]] -= book[2];
            }
        }
        for (int i = 1; i < n; i++){
            diff[i] += diff[i -1];
        }
        return diff;
    }
}
