/** Implementation of String methods in algs4 */

public class StringMethods {
    public static boolean isPalindrome(String str) {
        int N = str.length();
        for (int i = 0; i < N/2; i++)
            if (str.charAt(i) != str.charAt(N-1-i))
                return false;
        return true;
    }

    public static boolean isSorted(String[] strs) {
        for (int i = 1; i < strs.length; i++)
            if (strs[i-1].compareTo(strs[i]) > 0)
                return false;
        return true;
    }

    public static String[] splitWords(String str) {
        String[] words = str.split("\\s+");
        return words;
    }

    public static boolean isContain(String[] strs, String target) {
        for (int i = 0; i < strs.length; i++)
            if (strs[i].contains(target))
                return true;
        return false;
    }
}
