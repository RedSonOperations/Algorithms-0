import java.util.Arrays;
//Using Arrays import solely for printing array contents, ease of concatenation in sysout statements

public class QuickSort {
	private static int comparisons;
	private static int swaps;
    //First item as pivot
    public static String quickSortFirstPivot(int[] arr) {
    	String if50="";
    	
    	comparisons=0;
    	swaps=0;
        quickSortFirstPivot(arr, 0, arr.length - 1);
        
        if(arr.length==50) { //only show results of sort if array has length 50
        	if50="Quick sort using first partition item as pivot: " + Arrays.toString(arr);
    	}
        
        return "QuickSort (First Pivot) Comparisons: " + comparisons + "\n" + "QuickSort (First Pivot) Swaps: " + swaps + "\n" + if50;
    }

    private static void quickSortFirstPivot(int[] arr, int low, int high) {
    	
        if (low < high) {
            int pivot = partitionFirstPivot(arr, low, high);

            quickSortFirstPivot(arr, low, pivot - 1);
            quickSortFirstPivot(arr, pivot + 1, high);
            
        }
    }
    //partition method partitions array by traversing from left to right and right
    //to left. If during left to right traversal an element > pivot and right to left
    //traversal an element < pivot is found, they are swapped. Repeats until j>i where
    //j becomes the new 'high' parameter and this is employed in recursive QuickSort 
    //method above.
    private static int partitionFirstPivot(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        int j = high;

        while (i <= j) {
            while (i <= j && arr[i] <= pivot) {
            	increaseComparisons(); //increments comparisons
                i++;
            }
            while (i <= j && arr[j] > pivot) {
            	increaseComparisons();
                j--;
            }
            if (i < j) {
            	increaseComparisons();
                swap(arr, i, j); //swap elements at index i and j of array
            }
        }

        swap(arr, low, j);

        return j;
    }

    //Insertion sort for partition size 100 or less
    public static String quickSortInsertion100(int[] arr) {
        String if50="";
         
        comparisons = 0;
        swaps = 0;
        quickSortInsertion100(arr, 0, arr.length - 1);
        if (arr.length == 50) {
            if50 = "Quick sort using same pivot but insertion sort for partition of size <= 100: " + Arrays.toString(arr);
        }
        return "QuickSort (Insertion 100) Comparisons: " + comparisons + "\n" + "QuickSort (Insertion 100) Swaps: " + swaps + "\n" + if50;
    }

    private static void quickSortInsertion100(int[] arr, int low, int high) {
        if (low < high) {
            if (high - low + 1 <= 100) {
                insertionSort(arr, low, high);
                return;
            }

            int pivot = arr[low];
            int i = low + 1;
            int j = high;

            while (i <= j) {
                while (i <= j && arr[i] <= pivot) {
                	increaseComparisons();
                    i++;
                }
                while (i <= j && arr[j] > pivot) {
                	increaseComparisons();
                    j--;
                }
                if (i < j) {
                	increaseComparisons();
                    swap(arr, i, j);
                }
            }

            swap(arr, low, j);

            quickSortInsertion100(arr, low, j - 1);
            quickSortInsertion100(arr, j + 1, high);
        }
    }

    //Insertion sort for partition size 50 or less
    public static String quickSortInsertion50(int[] arr) {
        String if50="";
        
        comparisons = 0;
        swaps = 0;
        quickSortInsertion50(arr, 0, arr.length - 1);
        if (arr.length == 50) {
            if50 = "Quick sort using same pivot but insertion sort for partition of size <= 50: " + Arrays.toString(arr);
        }
        return "QuickSort (Insertion 50) Comparisons: " + comparisons + "\n" + "QuickSort (Insertion 50) Swaps: " + swaps + "\n" + if50;
    }

    private static void quickSortInsertion50(int[] arr, int low, int high) {
        if (low < high) {
            if (high - low + 1 <= 50) {
                insertionSort(arr, low, high);
                return;
            }

            int pivot = arr[low];
            int i = low + 1;
            int j = high;

            while (i <= j) {
                while (i <= j && arr[i] <= pivot) {
                	increaseComparisons();
                    i++;
                }
                while (i <= j && arr[j] > pivot) {
                	increaseComparisons();
                    j--;
                }
                if (i < j) {
                	increaseComparisons();
                    swap(arr, i, j);
                }
            }

            swap(arr, low, j);

            quickSortInsertion50(arr, low, j - 1);
            quickSortInsertion50(arr, j + 1, high);
        }
    }

    //Median-of-three as pivot
    public static String quickSortMedianOfThree(int[] arr) {
        String if50="";
        
        
        comparisons = 0;
        swaps = 0;
        quickSortMedianOfThree(arr, 0, arr.length - 1);
        if (arr.length == 50) {
            if50 = "Quick sort using median of 3 pivots: " + Arrays.toString(arr);
        } 
        return "QuickSort (Median-of-Three) Comparisons: " + comparisons + "\n" + "QuickSort (Median-of-Three) Swaps: " + swaps + "\n" + if50;
    }

    private static void quickSortMedianOfThree(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = medianOfThree(arr, low, high);

            int i = low + 1;
            int j = high;

            while (i <= j) {
                while (i <= j && arr[i] <= pivot) {
                	increaseComparisons();
                    i++;
                }
                while (i <= j && arr[j] > pivot) {
                	increaseComparisons();
                    j--;
                }
                if (i < j) {
                	increaseComparisons();
                    swap(arr, i, j);
                }
            }

            swap(arr, low, j);

            quickSortMedianOfThree(arr, low, j - 1);
            quickSortMedianOfThree(arr, j + 1, high);
        }
    }
    //calculates median of 3 pivots
    private static int medianOfThree(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        int a = arr[low];
        int b = arr[mid];
        int c = arr[high];

        if ((a <= b && b <= c) || (c <= b && b <= a)) {
            return b;
        } else if ((b <= a && a <= c) || (c <= a && a <= b)) {
            return a;
        } else {	
            return c;
        }
    }
    
    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                increaseComparisons();
            }
            arr[j + 1] = key;
        }
    }

    private static void swap(int[] arr, int i, int j) {
    	swaps++;
    	
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static void increaseComparisons() {
    	comparisons++;
    }
}
