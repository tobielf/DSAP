class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        for (int i = 0; ; ++i) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < strs.length; ++j) {
                if (strs[j].length() <= i)
                    return prefix;
                set.add(strs[j].charAt(i));
            }
            if (set.size() == 1)
                prefix += strs[0].charAt(i);
            else
                return prefix;
        }
    }
}