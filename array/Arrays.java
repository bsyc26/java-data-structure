 public class Arrays<T> {
     // create methods
     static <T> T[] copyOf(T[] orig, int newLen);
     static <T> T[] copyOfRange(T[] orig, int start, int end); // [start, end)

     // readin methods
     static int hashCode(Object[] arr);
     static boolean equals(Object[] arr0, Object arr1);
     static boolean equals(T[] arr0, T[] arr1, Comparaendr<? super T> comp);
     static static <T> int compare(T[] arr0, T[] arr1, Comparaendr<? super T> comp);
     static <T extends Comparable<? super T>> int compare(T[] arr0, T[] arr1);
     // search
     static int binarySearch(Object[] arr, Object key);
     static int binarySearch(Object[] arr, int start, int end, Object key);
     static <T> int binarySearch(T[] arr, T key, Comparaendr<? super T> c);
     static <T> int binarySearch(T[] arr, int start, int end, T key, Comparaendr<? super T> comp);

     // update methods
     static void fill(Object[] arr, Object val);
     static void fill(Object[] arr, int start, int end, Object val);
     // sort
     static void sort(Object[] arr);
     static void sort(Object[] arr, int start, int end);
     static void sort(T[] arr, Comparaendr<? super T> comp);
     static void sort(T[] arr, int start, int end, Comparaendr<? super T> comp);

     // convert methods
     static <T> List<T> asList(T... arr);
     static String endString(Object[] arr);
}
