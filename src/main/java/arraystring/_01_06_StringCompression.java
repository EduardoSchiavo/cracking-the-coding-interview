package arraystring;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3.
 * If the "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
class _01_06_StringCompression {
    String compress(String s) {
        StringBuilder compressing = new StringBuilder();
        int count = 1;
        char curr = s.charAt(0);

        for (int i =1; i <s.length(); i++){
            if (s.charAt(i) == curr){
                count++;
            } else {
                compressing.append(count);
                compressing.append(curr);

                curr = s.charAt(i);
                count = 1;
            }
        }
        compressing.append(count);
        compressing.append(curr);
        System.out.println(s);

        String compressed = compressing.toString();
        System.out.println(compressed);
        return compressed.length() < s.length() ? compressed : s;
    }
}
