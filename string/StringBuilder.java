public interface StringBuilderADT {
    // constructors
    public StringBuilder();
    public StringBuilder(int capacity);
    public StringBuilder(String str);

    // access methods
    public int length();
    public char chatAt(int indx);
    public int compareTo(StringBuilder another);
    public int indexOf(String str);
    public int indexOf(String str, int fromIndex);
    public int lastIndexOf(String str);
    public int lastIndexOf(String str, int fromIndex);

    // append methods
    public StringBuilder append(char c);
    public StringBuilder append(char[] str);
    public StringBuilder append(char[] str, int offset, int len);
    public StringBuilder append(String str);
    public StringBuilder append(StringBuilder sb);

    // insert methods
    public StringBuilder insert(int offset, char c);
    public StringBuilder insert(int offset, char[] str);
    public StringBuilder insert(int index, char[] str, int offset, int len);
    public StringBuilder insert(int offset, String str);

    // delete methods
    public StringBuilder delete(int start, int end);
    public StringBuilder deleteCharAt(int index);

    // modify methods
    public StringBuilder replace(int start, int end, String str);
    public StringBuilder reverse();
    public void setChatAt(int index, char ch);
    public void setLength(int newLength);

    // slice methods
    public String substring(int start);
    public String substring(int start, int end);

    // convert methods
    public String toString();
}
