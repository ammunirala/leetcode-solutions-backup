import java.util.*;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
      
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();

       
        for (int key : map.keySet()) {
            int freq = map.get(key);

            for (int i = 0; i < freq; i++) {
               
                if (result.size() <= i) {
                    result.add(new ArrayList<>());
                }
                result.get(i).add(key);
            }
        }

        return result;
    }
}