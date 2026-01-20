import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxDistinct(String s) {
        Set<Character> seen = new HashSet<>();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                count++;
            }
        }

        return count;
    }
}