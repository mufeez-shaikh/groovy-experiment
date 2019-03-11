package com.vavr;

import io.vavr.Tuple;
import io.vavr.Tuple2;

/**
 * Tuples combines a fixed number of elements to be passed around together as a whole.
 * Java does not have this feature. If you want to achieve it, you would have to create a class.
 * Tuple can hold objects of different types and they are also immutable.
 */
public class TupleExperiment {

  public static void main(String[] args) {
    Tuple2<String, Integer> java8 = Tuple.of("Java", 8);


    Tuple2<String, Integer> that1 = java8.map(
        s -> s.substring(2) + "vr",
        i -> i / 8
    );

    Tuple2<String, Integer> that = java8.map(
        (s, i) -> Tuple.of(s.substring(2) + "vr", i / 8)
    );

    String this1 = java8.apply((s,i) -> s.substring(2)+"vr"+i/8);

    System.out.println(this1);
  }
}
