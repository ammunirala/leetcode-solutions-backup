import java.util.*;

class Solution {

    TreeMap<Integer, Integer> left = new TreeMap<>();   // k-1 smallest
    TreeMap<Integer, Integer> right = new TreeMap<>();  // rest
    int leftSize = 0;
    long leftSum = 0;

    void addLeft(int x) {
        left.put(x, left.getOrDefault(x, 0) + 1);
        leftSize++;
        leftSum += x;
    }

    void removeLeft(int x) {
        left.put(x, left.get(x) - 1);
        if (left.get(x) == 0) left.remove(x);
        leftSize--;
        leftSum -= x;
    }

    void addRight(int x) {
        right.put(x, right.getOrDefault(x, 0) + 1);
    }

    void removeRight(int x) {
        right.put(x, right.get(x) - 1);
        if (right.get(x) == 0) right.remove(x);
    }

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        if (k == 1) return nums[0];

        // initial window
        for (int i = 1; i <= dist + 1; i++) {
            addLeft(nums[i]);
            if (leftSize > k - 1) {
                int mx = left.lastKey();
                removeLeft(mx);
                addRight(mx);
            }
        }

        long ans = nums[0] + leftSum;

        // sliding window
        for (int i = dist + 2; i < n; i++) {
            int add = nums[i];
            int rem = nums[i - dist - 1];

            // add
            if (!left.isEmpty() && add <= left.lastKey()) {
                addLeft(add);
            } else {
                addRight(add);
            }

            // remove
            if (left.containsKey(rem)) {
                removeLeft(rem);
            } else {
                removeRight(rem);
            }

            // rebalance
            while (leftSize < k - 1) {
                int mn = right.firstKey();
                removeRight(mn);
                addLeft(mn);
            }

            while (leftSize > k - 1) {
                int mx = left.lastKey();
                removeLeft(mx);
                addRight(mx);
            }

            ans = Math.min(ans, nums[0] + leftSum);
        }

        return ans;
    }
}
