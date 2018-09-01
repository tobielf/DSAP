class Solution {
    public String toLowerCase(String str) {
        char[] convert_dict = new char[256];
        char[] to_convert = str.toCharArray();
        char[] converted = new char[str.length()];
        for (int i = 0; i < 256; i++) {
            if (i >= 'A' && i <= 'Z')
                convert_dict[i] = (char)(i - 'A' + 'a');
            else
                convert_dict[i] = (char)i;
        }

        for (int i = 0; i < str.length(); i++) {
            converted[i] = convert_dict[to_convert[i]];
        }
        return new String(converted);
    }
}
