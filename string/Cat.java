/** Implementation of Cat (for text) in algs4 */

public class Cat {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++)
            sb.append(args[i]);
        System.out.println(sb.toString());
    }
}
