import java.util.*;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        
        List<Integer> freqList = new ArrayList<>(freqMap.values());
        Collections.sort(freqList); 

        
        int uniqueCount = freqList.size();
        for (int freq : freqList) {
            if (k >= freq) {
                k -= freq;
                uniqueCount--;
            } else {
                break;
            }
        }

        return uniqueCount;
    }
}
