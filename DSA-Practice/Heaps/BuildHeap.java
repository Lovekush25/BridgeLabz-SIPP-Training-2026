public class Main {

    static void buildHeap(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(arr, i, n);
        }
    }

    static void siftDown(int[] arr, int i, int size) {

        int smallest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left] < arr[smallest])
            smallest = left;

        if (right < size && arr[right] < arr[smallest])
            smallest = right;

        if (smallest != i) {

            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            siftDown(arr, smallest, size);
        }
    }

    public static void main(String[] args) {

        int[] arr = {10, 5, 30, 2, 8};

        buildHeap(arr);

        for (int x : arr)
            System.out.print(x + " ");
    }
}