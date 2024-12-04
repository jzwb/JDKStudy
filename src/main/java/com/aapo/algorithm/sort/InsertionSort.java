package com.aapo.algorithm.sort;

/**
 * 插入排序
 * -直接插入排序
 * -折半插入排序
 * -希尔排序
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 9, 1, 10, 6, 5, 4, 7, 8, 2, 3};
        //insertSort(arr);
        //halfInsertSort(arr);
        shellSort(arr);
        for (int i : arr) {
            System.out.print(i + ",");
        }
        System.out.println("==");
        //System.out.println(halfSearch(arr, 3));
    }

    /**
     * 直接插入排序
     * 时间复杂度：O(n^2)
     *
     * @param arr
     */
    private static void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];//当前待排序元素
            int j = i - 1;
            //将当前元素插入到已排序部分的适合位置
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * 折半插入排序
     *
     * @param arr
     */
    private static void halfInsertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            if (key < arr[i - 1]) {
                int index = searchInsertIndex(arr, 0, i - 1, key);
                int j = i;
                //将插入位置的后续元素依次往后面移动
                while (j > index) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[index] = key;
            }
        }
    }

    /**
     * 折半查找插入位置
     *
     * @param arr
     * @param left
     * @param right
     * @param key
     * @return
     */
    private static int searchInsertIndex(int[] arr, int left, int right, int key) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (key < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            //System.out.println("left = " + left + ",right = " + right + ",mid = " + mid);
        }
        return left;
    }

    /**
     * 折半查找（前提：要有序）
     *
     * @param arr
     * @param key
     * @return
     */
    private static int halfSearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 希尔排序
     *
     * @param arr
     */
    private static void shellSort(int[] arr) {
        int d = arr.length / 2;
        while (d >= 1) {
            for (int i = 0; i < d; i++) {
                for (int j = i + d; j < arr.length; j = j + d) {
                    int key = arr[j];
                    int z = j - d;
                    //将当前元素插入到已排序部分的适合位置
                    while (z >= 0 && arr[z] > key) {
                        arr[z + d] = arr[z];
                        z -= d;
                    }
                    arr[z + d] = key;
                }
            }
            d = d / 2;
        }
    }
}