package com.clubsheep;

import java.util.Arrays;

public class BubbleSort {

    /**
     * 冒泡排序1
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 冒泡排序2
     */
    public static void sort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isSorted = false;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 冒泡排序3
     */
    public static void sort3(int[] arr) {
        // 记录最后一次交换的位置
        int lastExchangeIndex = 0;
        // 无序数组的边界
        int sortBorder = arr.length - 1;

        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < sortBorder - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isSorted = false;
                    // 更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            System.out.println(Arrays.toString(arr));
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 鸡尾酒排序
     */
    public static void sort4(int[] arr) {
        int tmp = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            boolean isSorted = true;
            // 奇数轮，从左到右
            for (int j = i; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isSorted = false;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (isSorted) {
                break;
            }

            isSorted = true;
            // 偶数轮
            for (int j = arr.length - i - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                    isSorted = false;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (isSorted) {
                break;
            }
        }
    }
}
