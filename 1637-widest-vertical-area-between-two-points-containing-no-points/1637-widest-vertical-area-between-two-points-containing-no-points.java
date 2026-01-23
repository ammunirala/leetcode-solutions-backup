import java.util.*;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        
        
        int[] x = new int[n];
        for(int i = 0; i < n; i++){
            x[i] = points[i][0];
        }
        
       
        Arrays.sort(x);
        
        
        int maxWidth = 0;
        for(int i = 1; i < n; i++){
            maxWidth = Math.max(maxWidth, x[i] - x[i-1]);
        }
        
        return maxWidth;
    }
}
