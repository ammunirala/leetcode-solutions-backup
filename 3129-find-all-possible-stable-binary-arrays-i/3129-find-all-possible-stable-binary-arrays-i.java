class Solution {

    static final int MOD = 1000000007;
    Integer[][][][] dp;

    public int numberOfStableArrays(int zero, int one, int limit) {

        dp = new Integer[zero + 1][one + 1][2][limit + 1];

        long ans = 0;

        if (zero > 0)
            ans = (ans + solve(zero - 1, one, 0, 1, limit)) % MOD;

        if (one > 0)
            ans = (ans + solve(zero, one - 1, 1, 1, limit)) % MOD;

        return (int) ans;
    }

    long solve(int z, int o, int last, int count, int limit) {

        if (z == 0 && o == 0) return 1;

        if (dp[z][o][last][count] != null)
            return dp[z][o][last][count];

        long res = 0;

        if (last == 0) {

            if (z > 0 && count < limit)
                res = (res + solve(z - 1, o, 0, count + 1, limit)) % MOD;

            if (o > 0)
                res = (res + solve(z, o - 1, 1, 1, limit)) % MOD;

        } else {

            if (o > 0 && count < limit)
                res = (res + solve(z, o - 1, 1, count + 1, limit)) % MOD;

            if (z > 0)
                res = (res + solve(z - 1, o, 0, 1, limit)) % MOD;
        }

        return dp[z][o][last][count] = (int) res;
    }
}