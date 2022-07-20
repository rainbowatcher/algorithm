package com.clubsheep.bench;

import com.clubsheep.sort.BubbleSort;
import com.clubsheep.sort.CocktailSort;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@State(Scope.Benchmark)
public class SortSampleTime {

  private int[] arr;
  private int[] cloneArr;

  @Param({
    "OptimizedCocktailSort",
    "CocktailSort",
    "OptimizedBubbleSort2",
    "OptimizedBubbleSort1",
    "NormalBubbleSort",
  })
  private String type;

  public static void main(String[] args) throws RunnerException {
    Options opts =
        new OptionsBuilder()
            .include(SortSampleTime.class.getSimpleName())
            .mode(Mode.SampleTime)
            .timeUnit(TimeUnit.NANOSECONDS)
            .result("bench/SortSampleTime.json")
            .resultFormat(ResultFormatType.JSON)
            .forks(1)
            .build();

    new Runner(opts).run();
  }

  @Setup
  public void setup() {
    arr = IntStream.range(1, 100).map(i -> new Random().nextInt(100)).toArray();
    cloneArr = arr.clone();
  }

  @Benchmark
  public void sort() {
    switch (type) {
      case "NormalBubbleSort":
        BubbleSort.bubbleSort(cloneArr);
        break;
      case "OptimizedBubbleSort1":
        BubbleSort.optimizedBubbleSort1(cloneArr);
        break;
      case "OptimizedBubbleSort2":
        BubbleSort.optimizedBubbleSort2(cloneArr);
        break;
      case "CocktailSort":
        CocktailSort.cocktailSort(cloneArr);
        break;
      case "OptimizedCocktailSort":
        CocktailSort.optimizedCocktailSort(cloneArr);
        break;
    }
  }
}
