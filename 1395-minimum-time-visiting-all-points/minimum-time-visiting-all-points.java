class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int seconds = 0;
        int N = points.length - 1;

        for(int i = 0; i < N ; i++){
            
            int x_diff = Math.abs(points[i][0] - points[i+1][0]);
            int y_diff = Math.abs(points[i][1] - points[i+1][1]);

            if(x_diff < y_diff){
                seconds += x_diff;
                seconds += y_diff - x_diff;
            }
            else{
                seconds += y_diff;
                seconds += x_diff - y_diff;
            }
        }
        return seconds;
    }
}