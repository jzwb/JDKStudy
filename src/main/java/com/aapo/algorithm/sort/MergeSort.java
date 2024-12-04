package com.aapo.algorithm.sort;

/**
 * 归并排序
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] arr = new int[]{7, 2, 1, 3, 7, 5, 4, 9, 8, 10, 6};
        //每个元素单独作为一个子序列
        //每轮对两个相邻子序列进行归并
        //直到归并到只有1个序列
        recursion(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    private static void recursion(int[] arr, int left, int right) {
        if (left < right) {
            //中间分隔，递归左右两边，直到只有一个元素（所以有序）
            int mid = (left + right) / 2;
            recursion(arr, left, mid);
            recursion(arr, mid + 1, right);

            //左右两边放到分别两个新数组
            int aLen = mid - left + 1;
            int bLen = right - mid;
            int[] aArr = new int[aLen];
            int[] bArr = new int[bLen];
            for (int i = 0; i < aLen; i++) {
                aArr[i] = arr[left + i];
            }
            for (int i = 0; i < bLen; i++) {
                bArr[i] = arr[mid + 1 + i];
            }
            //通过对比两个素组值，找到最值并且放到当前比对部分相应位置
            int i = 0, j = 0, n = left;
            while (i < aLen && j < bLen) {
                if (aArr[i] <= bArr[j]) {
                    arr[n++] = aArr[i++];
                } else {
                    arr[n++] = bArr[j++];
                }
            }
            //当其中一个数组已经比对完，那就可以直接把另外数组的元素直接放到剩下位置即可
            while (j < bLen) {
                arr[n++] = bArr[j++];
            }
            while (i < aLen) {
                arr[n++] = aArr[i++];
            }
        }
    }
}
