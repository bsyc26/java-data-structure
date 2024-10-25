public class Arrays<T> {
    // static builder methods
    public static <T> T[] copyOf(T[] orig, int newLen);
    public static <T> T[] copyOfRange(T[] orig, int from, int to);

    // update methods
    public static void fill(Object[] arr, Object val);
    public static void fill(Object[] arr, int from, int to, Object val);

    // search methods
    public static int binarySearch(Object[] arr, Object key);
    public static int binarySearch(Object[] arr, int from, int to, Object key);
    public static <T> int binarySearch(T[] arr, T key, Comparator<? super T> c);
    public static <T> int binarySearch(T[] arr, int from, int to, T key, Comparator<? super T> comp);

    // sort methods
    public static void sort(Object[] arr);
    public static void sort(Object[] arr, int from, int to);
    public static void sort(T[] arr, Comparator<? super T> comp);
    public static void sort(T[] arr, int from, int to, Comparator<? super T> comp);

    // hash methods
    public static int hashCOde(Object[] arr);

    // compare methods
    public static boolean equals(Object[] arr0, Object arr1);
    public static boolean equals(T[] arr0, T[] arr1, Comparator<? super T> comp);
    public static static <T> int compare(T[] arr0, T[] arr1, Comparator<? super T> comp);
    public static <T extends Comparable<? super T>> int compare(T[] arr0, T[] arr1);

    // convert methods
    public static <T> List<T> asList(T... arr);
    public static String toString(Object[] arr);
}
