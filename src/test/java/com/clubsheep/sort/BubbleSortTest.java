package com.clubsheep.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 暂时没来得及写说明
 *
 * @author rainb
 * @since 2022/7/19
 */
class BubbleSortTest {

  private int[] arr;

  @BeforeEach
  public void init() {
    arr = new int[] {3, 4, 6, 1, 5, 2, 7, 8};
    int num = 300;
    arr = IntStream.range(1, num).map(x -> new Random().nextInt(num)).toArray();
  }

  @Test
  void bubbleSort() {
    int[] clone = arr.clone();
    Arrays.sort(clone);
    BubbleSort.bubbleSort(arr);
    System.out.println(Arrays.toString(arr));
    Assertions.assertArrayEquals(clone, arr);
  }

  @Test
  void optimizedBubbleSort1() {
    int[] clone = arr.clone();
    Arrays.sort(clone);
    BubbleSort.optimizedBubbleSort1(arr);
    System.out.println(Arrays.toString(arr));
    Assertions.assertArrayEquals(clone, arr);
  }

  @Test
  void optimizedBubbleSort2() {
    int[] clone = arr.clone();
    Arrays.sort(clone);
    BubbleSort.optimizedBubbleSort2(arr);
    System.out.println(Arrays.toString(arr));
    Assertions.assertArrayEquals(clone, arr);
  }

  @Test
  void cocktailSort() {
    int[] clone = arr.clone();
    Arrays.sort(clone);
    CocktailSort.cocktailSort(arr);
    System.out.println(Arrays.toString(arr));
    Assertions.assertArrayEquals(clone, arr);
  }

  @Test
  void optimizedCocktailSort() {
    int[] clone = arr.clone();
    Arrays.sort(clone);
    CocktailSort.optimizedCocktailSort(arr);
    System.out.println(Arrays.toString(arr));
    Assertions.assertArrayEquals(clone, arr);
  }
}
