package com.aapo.sortalgorithm;

/**
 * 堆排序
 * 前提条件：完全二叉树，建成大堆根或者小堆根，然后把堆顶放到最后，进行排序
 * 步骤：建堆、排序
 */
public class HeapSort {
    
    public static void main(String[] args) {
        int[] arr = new int[]{7, 2, 1, 3, 7, 5, 4, 9, 8, 10, 6};
        //构建堆：从最后一个非叶子节点开始
        for (int len = arr.length; len > 0; len--) {
            //从最后一个非叶子节点开始，逐个向上调整堆
            for (int n = len / 2; n > 0; n--) {
                recursion(arr, n, len);
            }
            //交换根节点和当前堆的最后一个元素
            int temp = arr[0];
            arr[0] = arr[len - 1];
            arr[len - 1] = temp;
        }
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    /**
     * @param arr
     * @param n
     * @param len
     */
    private static void recursion(int[] arr, int n, int len) {
        int max = n;//根节点
        int left = n * 2;//左节点
        int right = n * 2 + 1;//右节点
        //如果左节点比根节点大
        if (left <= len && arr[left - 1] > arr[max - 1]) {
            max = left;
        }
        //如果右节点比根节点大
        if (right <= len && arr[right - 1] > arr[max - 1]) {
            max = right;
        }
        //如果最大值不是根节点，交换并递归调整
        if (max != n) {
            int temp = arr[n - 1];
            arr[n - 1] = arr[max - 1];
            arr[max - 1] = temp;
            recursion(arr, max, len);//递归调整交换后的子树
        }
    }
}