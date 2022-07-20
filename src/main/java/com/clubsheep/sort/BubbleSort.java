package com.clubsheep.sort;

public class BubbleSort {

  /** 冒泡排序1 */
  public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int tmp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = tmp;
        }
      }
    }
  }

  /** 冒泡排序2 */
  public static void optimizedBubbleSort1(int[] arr) {
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
      if (isSorted) {
        break;
      }
    }
  }

  /** 冒泡排序3 */
  public static void optimizedBubbleSort2(int[] arr) {
    // 记录最后一次交换的位置
    int lastExchangeIndex = 0;
    // 无序数组的边界
    int sortBorder = arr.length - 1;

    for (int i = 0; i < arr.length - 1; i++) {
      boolean isSorted = true;
      for (int j = 0; j < sortBorder; j++) {
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
      if (isSorted) {
        break;
      }
    }
  }
}
