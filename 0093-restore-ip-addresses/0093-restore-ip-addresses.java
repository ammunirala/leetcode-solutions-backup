import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(String s, int idx, int parts, StringBuilder curr, List<String> res) {
        if (parts == 4 && idx == s.length()) {
            res.add(curr.toString());
            return;
        }

        if (parts == 4 || idx == s.length()) return;

        int len = curr.length();

        for (int i = 1; i <= 3 && idx + i <= s.length(); i++) {
            if (i > 1 && s.charAt(idx) == '0') break;

            String part = s.substring(idx, idx + i);
            int val = Integer.parseInt(part);
            if (val > 255) continue;

            if (len != 0) curr.append('.');
            curr.append(part);

            backtrack(s, idx + i, parts + 1, curr, res);

            curr.setLength(len);
        }
    }
}
