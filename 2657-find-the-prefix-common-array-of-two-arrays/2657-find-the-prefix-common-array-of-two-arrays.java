import java.util.*;

public class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        Set<Integer> seenA = new HashSet<>();
        Set<Integer> seenB = new HashSet<>();
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            seenA.add(A[i]);
            seenB.add(B[i]);

            
            if (seenB.contains(A[i])) {
                commonCount++;
            }

            
            if (A[i] != B[i] && seenA.contains(B[i])) {
                commonCount++;
            }

            result[i] = commonCount;
        }

        return result;
    }

    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A1 = {1, 3, 2, 4};
        int[] B1 = {3, 1, 2, 4};
        System.out.println(Arrays.toString(sol.findThePrefixCommonArray(A1, B1))); // [0, 2, 3, 4]

        int[] A2 = {2, 3, 1};
        int[] B2 = {3, 1, 2};
        System.out.println(Arrays.toString(sol.findThePrefixCommonArray(A2, B2))); // [0, 1, 3]
    }
}