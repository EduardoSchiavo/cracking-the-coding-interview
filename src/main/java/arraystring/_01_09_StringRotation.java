package arraystring;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, sl and s2, write code to check if s2 is a rotation of s1
 * using only one call to isSubstring (e.g.,"waterbottle" is a rotation of"erbottlewat").
 */
class _01_09_StringRotation {
    boolean rotated(String original, String result) {
        if(original.isEmpty() || result.isEmpty()){
            return true;
        }
        if(original.isEmpty() ^ result.isEmpty()){
            return false;
        }

        if (original.length() != result.length()){
            return false;
        }

        StringBuilder stringBuilder = new StringBuilder();
        int start = result.indexOf(original.charAt(0));
        if (start == -1){
            return false;
        }
        for(int i = start; i< start + result.length(); i++){
            stringBuilder.append(result.charAt(i%result.length()));
        }

        return original.equals(stringBuilder.toString());

    }

}
