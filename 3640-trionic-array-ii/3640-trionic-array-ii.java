class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long NEG = Long.MIN_VALUE / 4;

        long[] dp0 = new long[n];
        long[] dp1 = new long[n];
        long[] dp2 = new long[n];
        long[] dp3 = new long[n];

        dp0[0] = nums[0];
        dp1[0] = dp2[0] = dp3[0] = NEG;

        for (int i = 1; i < n; i++) {
            dp0[i] = nums[i];   // ❗ no carry

            dp1[i] = dp2[i] = dp3[i] = NEG;

            if (nums[i] > nums[i - 1]) {
                // start or continue first increasing
                dp1[i] = Math.max(dp1[i - 1] + nums[i],
                                  dp0[i - 1] + nums[i]);

                // start or continue last increasing
                dp3[i] = Math.max(dp3[i - 1] + nums[i],
                                  dp2[i - 1] + nums[i]);
            }

            if (nums[i] < nums[i - 1]) {
                // start or continue decreasing
                dp2[i] = Math.max(dp2[i - 1] + nums[i],
                                  dp1[i - 1] + nums[i]);
            }
            // nums[i] == nums[i-1] → nothing continues (strict)
        }

        long ans = NEG;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp3[i]);
        }
        return ans;
    }
}
