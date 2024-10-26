public class StaticArray {
    // unit test
    public static void main(String[] args) {
        // DS
        int[] arr = new int[10]; // start addr + offset idx
        
        // modify method
        arr[0] = 0;
        for (int i = 0; i < 5; i++)
            arr[i] = i

        // access method, T: O(1)
        int val0 = arr[0];

        // create methods
        // append at tail: O(1)
        arr[5] = 5;
        // insert in mid: O(N)
        for (int i = 6; i > 2; i--) // reverse
            arr[i] = arr[i-];
        arr[2] = -1; 
        // exceed capacity: O(N)
        int[] newArr = new int[20];
        for (int i = 0; i < 10; i++)
            newArr[i] = arr[i];
        newArr[10] = 10;

        // delete methods
        // delete the tail: O(1)
        arr[6] = -1;
        // delete the mid: O(N)
        for (int i = 1; i < 6; i++) // del arr[1]
            arr[i] = arr[i+1];
        arr[5] = -1;
    }
}
