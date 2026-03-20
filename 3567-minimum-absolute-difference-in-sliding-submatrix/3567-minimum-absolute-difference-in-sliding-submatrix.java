import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] ans = new int[n - k + 1][m - k + 1];

        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= m - k; j++) {

                List<Integer> list = new ArrayList<>();

                // collect elements of k x k submatrix
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        list.add(grid[x][y]);
                    }
                }

                // sort
                Collections.sort(list);

                // find min abs difference
                int minDiff = Integer.MAX_VALUE;

                for (int t = 1; t < list.size(); t++) {
                    if (!list.get(t).equals(list.get(t - 1))) {
                        minDiff = Math.min(minDiff,
                                list.get(t) - list.get(t - 1));
                    }
                }

                // if all elements same
                if (minDiff == Integer.MAX_VALUE) {
                    minDiff = 0;
                }

                ans[i][j] = minDiff;
            }
        }

        return ans;
    }
}