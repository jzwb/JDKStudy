package com.aapo.sortalgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7111, 2, 92, 111, 104, 36, 225, 34, 87, 18, 3};
        //获取各个位数
        /*for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] / 1000 % 10 + ",");
            System.out.print(arr[i] / 100 % 10 + ",");
            System.out.print(arr[i] / 10 % 10 + ",");
            System.out.print(arr[i] / 1 % 10 + ",");
            System.out.println("==");
        }*/

        //准备一个根据基数来决定数组长度
        //数组中每个元素为链表，用于存储每一轮比较结果后的元素
        //最后把所有链表数据串起来
        //直到访问位数结束

        //桶初始化
        List<Integer>[] buckets = new List[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        int n = 1;
        while (n > 0) {
            boolean flag = false;
            for (int i = 0; i < arr.length; i++) {
                //获取位数值，当如不同的桶
                int value = arr[i];
                int b = value / n % 10;
                buckets[b].add(arr[i]);
                //前面还有为数
                if (value / (n * 10) > 0) {
                    flag = true;
                }
            }
            int i = 0;
            for (List<Integer> bucket : buckets) {
                for (Integer value : bucket) {
                    arr[i++] = value;
                }
                bucket.clear();
            }
            //没有更高位数就退出循环
            if (!flag) {
                break;
            }
            //继续下个高位
            n *= 10;
        }

        //打印结果
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}
