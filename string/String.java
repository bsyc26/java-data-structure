public interface String {

    // constructors
    public String(char[] chars);
    public String(char[] chars, int start, int len);
    public String(String str);
    public String(StringBuilder builder);

    // create methods
    public String valueOf(char ch);
    public String valueOf(char[] chars);
    public String valueOf(int idx);

    // readin methods
    public int length();
    public boolean isEmpty();
    public boolean isBlank();
    public char charAt(int idx);
    public int compareTo(String str);
    public boolean equals(Object obj);
    public int indexOf(String str);
    public int indexOf(String str, int from);
    public int lastIndexOf(String str);
    public int lastIndexOf(String str, int from);
    public boolean startsWith(String prefix);
    public boolean startsWith(String prefix, int start);
    public boolean endsWith(String suffix);
    public int hashCode(String str);
    public String substring(int from);
    public String substring(int from, int to);
    public String[] split(String delim);
    public char[] toCharArray();

    // update methods
    public String concat(String str);
    public static String join(CharSequence delim, CharSequence... elems);
    public String repeat(int cnt);
    public String replace(char oldCh, char newCh);
    public String replace(CharSequence oldSeq, CharSequence newSeq);
    public String strip();
    public String trim();
    public String toUpperCase();
    public String toLowerCase();

}
