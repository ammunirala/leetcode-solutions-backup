class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int cost = nums[0];

        int[] arr = new int[n - 1];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = nums[i];
        }

        java.util.Arrays.sort(arr);

        cost += arr[0] + arr[1];

        return cost;
    }
}
