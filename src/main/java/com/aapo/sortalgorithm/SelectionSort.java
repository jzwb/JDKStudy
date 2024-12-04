package com.aapo.sortalgorithm;

/**
 * 选择排序
 * -简单选择排序
 */
public class SelectionSort {
    
    public static void main(String[] args) {
        int[] arr = new int[]{7, 2, 1, 3, 6, 5, 4};
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            //假设当前索引为最小值索引
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;//更新最小值索引
                }
            }
            //将最小值与当前索引交换
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}