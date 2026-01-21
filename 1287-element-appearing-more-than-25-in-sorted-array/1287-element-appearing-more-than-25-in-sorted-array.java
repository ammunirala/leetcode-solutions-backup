class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int check = n / 4;

        for (int i = 0; i + check < n; i++) {
            if (arr[i] == arr[i + check]) {
                return arr[i];
            }
        }
        return -1; 
    }
}
