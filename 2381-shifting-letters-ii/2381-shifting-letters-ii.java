class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1];

        
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int dir = shift[2];

            if (dir == 1) { // forward
                diff[start] += 1;
                diff[end + 1] -= 1;
            } else { // backward
                diff[start] -= 1;
                diff[end + 1] += 1;
            }
        }

        
        StringBuilder sb = new StringBuilder();
        int currShift = 0;

        for (int i = 0; i < n; i++) {
            currShift += diff[i];

            int ch = s.charAt(i) - 'a';
            int newChar = (ch + currShift) % 26;
            if (newChar < 0) newChar += 26;

            sb.append((char) ('a' + newChar));
        }

        return sb.toString();
    }
}
