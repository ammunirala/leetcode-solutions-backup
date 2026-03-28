class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        
        // DSU
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        // Find
        java.util.function.IntUnaryOperator find = new java.util.function.IntUnaryOperator() {
            public int applyAsInt(int x) {
                if (parent[x] != x)
                    parent[x] = applyAsInt(parent[x]);
                return parent[x];
            }
        };
        
        // Union
        java.util.function.BiConsumer<Integer, Integer> union = (a, b) -> {
            int pa = find.applyAsInt(a);
            int pb = find.applyAsInt(b);
            if (pa != pb) parent[pb] = pa;
        };
        
        // Step 1: Grouping
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] > 0) {
                    union.accept(i, j);
                }
            }
        }
        
        // Step 2: Assign chars
        char[] res = new char[n];
        java.util.Map<Integer, Character> map = new java.util.HashMap<>();
        
        char ch = 'a';
        for (int i = 0; i < n; i++) {
            int p = find.applyAsInt(i);
            if (!map.containsKey(p)) {
                if (ch > 'z') return ""; // not possible
                map.put(p, ch++);
            }
            res[i] = map.get(p);
        }
        
        String s = new String(res);
        
        // Step 3: Validate LCP
        int[][] calc = new int[n][n];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 < n && j + 1 < n)
                        calc[i][j] = 1 + calc[i + 1][j + 1];
                    else
                        calc[i][j] = 1;
                }
            }
        }
        
        // Compare
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (calc[i][j] != lcp[i][j])
                    return "";
            }
        }
        
        return s;
    }
}