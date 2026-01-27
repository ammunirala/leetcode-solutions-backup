class Solution {
    public int maxRepOpt1(String text) {
        int[] freq = new int[26];
        for (char c : text.toCharArray()) {
            freq[c - 'a']++;
        }

        int n = text.length();
        int ans = 0;

        for (int i = 0; i < n; ) {
            char ch = text.charAt(i);
            int j = i;

            while (j < n && text.charAt(j) == ch) {
                j++;
            }

            int len1 = j - i;
            int k = j + 1;

            while (k < n && text.charAt(k) == ch) {
                k++;
            }

            int len2 = k - j - 1;

            int total = len1 + len2;
            if (freq[ch - 'a'] > total) {
                total++;
            }

            ans = Math.max(ans, total);
            i = j;
        }

        return ans;
    }
}
