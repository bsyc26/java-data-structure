public class StaticArray {
    // unit test
    public static void main(String[] args) {
        // DS
        int[] arr = new int[10]; // start addr + offset idx
        
        // create methods
        arr[5] = 5; // append at tail: O(1)
        for (int i = 6; i > 2; i--) // insert in mid: O(N), reverse
            arr[i] = arr[i-];
        arr[2] = -1; 
        int[] newArr = new int[20];
        for (int i = 0; i < 10; i++) // exceed capacity: O(N)
            newArr[i] = arr[i];
        newArr[10] = 10;

        // readin method: O(1)
        int val0 = arr[0];

        // update method: O(1)
        arr[0] = 0;
        for (int i = 0; i < 5; i++)
            arr[i] = i;

        // delete methods
        arr[6] = -1; // delete the tail: O(1)
        for (int i = 1; i < 6; i++) // delete the mid: O(N)
            arr[i] = arr[i+1];
        arr[5] = -1;
    }
}
