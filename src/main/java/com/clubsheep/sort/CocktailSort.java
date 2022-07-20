package com.clubsheep.sort;

/**
 * @author rainb
 * @since 2022/07/19
 */
public class CocktailSort {

  /**
   * 鸡尾酒排序
   *
   * @param arr arr
   */
  public static void cocktailSort(int[] arr) {
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
      if (isSorted) {
        break;
      }
    }
  }

  /**
   * 优化鸡尾酒排序
   *
   * @param arr arr
   */
  public static void optimizedCocktailSort(int[] arr) {
    int tmp = 0;
    // 记录最后一次交换的位置
    int lastExchangeIndex = 0;
    // 顺序无序数组的边界
    int leftSortBorder = arr.length - 1;
    // 逆序无序数组的边界
    int rightSortBorder = 0;
    for (int i = 0; i < arr.length / 2 - 1; i++) {
      boolean isSorted = true;
      // 奇数轮，从左到右
      for (int j = rightSortBorder; j < leftSortBorder; j++) {
        if (arr[j] > arr[j + 1]) {
          tmp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = tmp;
          isSorted = false;
          lastExchangeIndex = j;
        }
      }
      leftSortBorder = lastExchangeIndex;
      if (isSorted) {
        break;
      }
      isSorted = true;
      // 偶数轮
      for (int j = leftSortBorder; j > rightSortBorder; j--) {
        if (arr[j] < arr[j - 1]) {
          tmp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = tmp;
          isSorted = false;
          lastExchangeIndex = j;
        }
      }
      rightSortBorder = lastExchangeIndex;
      if (isSorted) {
        break;
      }
    }
  }
}
