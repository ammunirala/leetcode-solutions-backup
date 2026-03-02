class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] rightmost = new int[n];

        // Step 1: find rightmost 1 in each row
        for (int i = 0; i < n; i++) {
            int pos = -1;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    pos = j;
                    break;
                }
            }
            rightmost[i] = pos;
        }

        int swaps = 0;

        
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && rightmost[j] > i) {
                j++;
            }

            if (j == n) return -1;

            // bring row j to i using swaps
            while (j > i) {
                int temp = rightmost[j];
                rightmost[j] = rightmost[j - 1];
                rightmost[j - 1] = temp;
                swaps++;
                j--;
            }
        }

        return swaps;
    }
}