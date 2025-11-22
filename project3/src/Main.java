import AlgorithmToolkit.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // ---------------- Sorting Tests ----------------
        int[] arr1 = {5, 2, 9, 1};
        int[] arr2 = {10, 3, 7, 4};

        SortingUtil.bubbleSort(arr1);
        SortingUtil.mergeSort(arr2);

        System.out.println("BubbleSort: " + Arrays.toString(arr1));
        System.out.println("MergeSort: " + Arrays.toString(arr2));

        // ---------------- Search Tests ----------------
        int[] sortedArr = {1, 3, 5, 7, 9};

        System.out.println("Linear Search (5): " +
                SearchUtil.linearSearch(sortedArr, 5));

        System.out.println("Binary Search (7): " +
                SearchUtil.binarySearch(sortedArr, 7));

        // ---------------- Stack & Queue Tests ----------------
        CollectionUtil.Stack<Integer> stack = new CollectionUtil.Stack<>();
        stack.push(10);
        stack.push(20);
        System.out.println("Stack Pop: " + stack.pop());

        CollectionUtil.Queue<String> queue = new CollectionUtil.Queue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        System.out.println("Queue Dequeue: " + queue.dequeue());

        // ---------------- Timer Tests ----------------
        long time = AnalysisUtil.measureTime(() ->
                SortingUtil.quickSort(sortedArr)
        );

        System.out.println("QuickSort execution time: " + time + "ms");
    }
}
