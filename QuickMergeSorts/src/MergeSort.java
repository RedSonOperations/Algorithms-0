import java.util.Arrays;

public class MergeSort {
    private static int comparisons = 0;
    private static int swaps = 0;

    public static String sort(int[] arr) {
        String if50="";
        
        comparisons = 0;
        swaps = 0;
        mergeSort(arr, 0, arr.length - 1);
        if (arr.length == 50) {
            if50 = "Natural merge sorted array: " + Arrays.toString(arr);
        } 
        return "Natural MergeSort Comparisons: " + comparisons + "\n" + "Natural MergeSort Swaps: " + swaps + "\n" + if50;
    }

    
    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }
    //merge function to merge two sorted arrays
    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[arr.length];
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }
        //copy elements from original array to new, temporary array
        int i = low;
        int j = mid + 1;
        int k = low;
        //merge two halves
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
            	
                arr[k++] = temp[i++];
                comparisons++;
                
            } else {
            	
                arr[k++] = temp[j++];
                comparisons++;
                swaps++;
            }
            
        }
        //copy remaining elements from left half
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
    }
}
