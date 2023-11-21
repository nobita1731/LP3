import java.util.Arrays;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class merge {
    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        System.out.println("\nOriginal array:");
        printArray(arr);
        // Merge Sort
        int[] mergeSortedArray = mergeSort(arr.clone());
        System.out.println("\nSorted array using Merge Sort:");
        printArray(mergeSortedArray);
        // Multithreaded Merge Sort
        ForkJoinPool pool = new ForkJoinPool();
        MultithreadedMergeSort multithreadedSorter = new MultithreadedMergeSort(arr.clone());
        int[] multithreadedSortedArray = pool.invoke(multithreadedSorter);
        System.out.println("\nSorted array using Multithreaded Merge Sort:");
        printArray(multithreadedSortedArray);
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }
        while (i < left.length) {
            merged[k++] = left[i++];
        }
        while (j < right.length) {
            merged[k++] = right[j++];
        }
        return merged;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

class MultithreadedMergeSort extends RecursiveTask<int[]> {
    private int[] arr;

    MultithreadedMergeSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected int[] compute() {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        MultithreadedMergeSort leftTask = new MultithreadedMergeSort(left);
        MultithreadedMergeSort rightTask = new MultithreadedMergeSort(right);
        leftTask.fork();
        rightTask.fork();
        int[] leftResult = leftTask.join();
        int[] rightResult = rightTask.join();
        return merge(leftResult, rightResult);
    }

    private int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }
        while (i < left.length) {
            merged[k++] = left[i++];
        }
        while (j < right.length) {
            merged[k++] = right[j++];
        }
        return merged;
    }
}