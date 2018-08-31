class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] jewels = new boolean[256];
        char[] jewels_string = J.toCharArray();
        char[] s_string = S.toCharArray();
        int count = 0;
        for (boolean j: jewels) {
            j = false;
        }
        for (char j: jewels_string) {
            jewels[j] = true;
        }
        for (char s: s_string) {
            if (jewels[s])
                count++;
        }
        return count;
    }
}