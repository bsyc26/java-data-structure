public interface StringBuilder {

     // constructors
     StringBuilder();
     StringBuilder(int capacity);
     StringBuilder(String str);

     // create methods
     StringBuilder append(char c);
     StringBuilder append(char[] str);
     StringBuilder append(char[] str, int offset, int len);
     StringBuilder append(String str);
     StringBuilder append(StringBuilder sb);
     StringBuilder insert(int offset, char c);
     StringBuilder insert(int offset, char[] str);
     StringBuilder insert(int index, char[] str, int offset, int len);
     StringBuilder insert(int offset, String str);

     // readin methods
     int length();
     char chatAt(int indx);
     int compareTo(StringBuilder another);
     int indexOf(String str);
     int indexOf(String str, int fromIndex);
     int lastIndexOf(String str);
     int lastIndexOf(String str, int fromIndex);
     String substring(int start);
     String substring(int start, int end);
     String toString();

     // update methods
     StringBuilder replace(int start, int end, String str);
     StringBuilder reverse();
     void setChatAt(int index, char ch);
     void setLength(int newLength);

     // delete methods
     StringBuilder delete(int start, int end);
     StringBuilder deleteCharAt(int index);

}
