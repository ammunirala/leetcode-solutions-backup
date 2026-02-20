class Solution {
    public String makeLargestSpecial(String s) {
        List<String> list = new ArrayList<>();
        int count = 0, start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            else count--;

            
            if (count == 0) {
                String inner = s.substring(start + 1, i);
                String processed = makeLargestSpecial(inner);
                list.add("1" + processed + "0");
                start = i + 1;
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        StringBuilder res = new StringBuilder();
        for (String str : list) res.append(str);

        return res.toString();
    }
}