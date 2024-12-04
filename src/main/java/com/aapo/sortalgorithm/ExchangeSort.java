package com.aapo.sortalgorithm;

/**
 * 交换排序
 * -冒泡排序
 * -快速排序
 */
public class ExchangeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 9, 1, 10, 6, 5, 4, 7, 8, 2, 3};
        //bubbleSort(arr);
        quickSort(arr);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
    
    /**
     * 冒泡排序
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    /**
     * 快速排序
     * -挖坑法
     * -Hoare版
     * -双指针
     * @param arr
     */
    private static void quickSort(int[] arr) {
        quickSortByHole(arr, 0, arr.length - 1);
        //quickSortByHoare(arr, 0, arr.length - 1);
    }

    /**
     * 挖坑法
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void quickSortByHole(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int left = l, right = r;

        int hole = left;
        //随机选取基准值（降低基准值选到最值的几率）
        /*int hole = new Random().nextInt(right - left) + left;
        int temp = arr[left];
        arr[left] = arr[hole];
        arr[hole] = temp;
        hole = left;*/

        int key = arr[hole];
        while (left < right) {
            //寻找比基准值小的右侧值
            while (left < right && arr[right] >= key) {
                right--;
            }
            //和坑位交换
            arr[hole] = arr[right];
            hole = right;

            //寻找比基准值大的左侧值
            while (left < right && arr[left] <= key) {
                left++;
            }
            //和坑位交换
            arr[hole] = arr[left];
            hole = left;
        }
        //基准值放到坑位
        arr[hole] = key;

        //递归左右子区间
        quickSortByHole(arr, l, hole - 1);
        quickSortByHole(arr, hole + 1, r);
    }


    /**
     * Hoare
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void quickSortByHoare(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int left = l, right = r;
        int p = left;
        int key = arr[p];
        while (left < right) {
            //寻找比基准值小的右侧值
            while (left < right && arr[right] >= key) {
                right--;
            }
            //寻找比基准值小的左侧值
            while (left < right && arr[left] <= key) {
                left++;
            }
            //交换
            if (left < right) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }
        //基准值放到正确位置
        int temp = arr[left];
        arr[left] = key;
        arr[p] = temp;
        
        //递归左右子区间
        quickSortByHoare(arr, l, left - 1);
        quickSortByHoare(arr, left + 1, r);
    }
}
