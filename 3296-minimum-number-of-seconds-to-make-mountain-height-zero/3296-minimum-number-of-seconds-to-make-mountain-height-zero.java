class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long left = 1;
        long right = (long)1e18;
        long ans = right;

        while(left <= right) {

            long mid = left + (right - left) / 2;

            long reduced = 0;

            for(int w : workerTimes) {

                long val = (2 * mid) / w;

                long k = (long)((Math.sqrt(1 + 4.0 * val) - 1) / 2);

                reduced += k;

                if(reduced >= mountainHeight)
                    break;
            }

            if(reduced >= mountainHeight) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}