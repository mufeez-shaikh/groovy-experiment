package com.vavr;

import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.control.Option;

public class FunctionExperiment {

  public static void main(String[] args) {
    Function2<Integer, Integer, Integer> addFun = (a, b) -> a+b;
    //functions with 2 params and return type
    int result = addFun.apply(5,4);

    /************** composition ******************* */
    //applying the result of one function to another function.
    // In mathematics, if f: x-> y, g: y->z, then h(g(x)): x -> z.
    // example:
    Function1<Integer, Integer> plusOne = a -> a + 1;
    Function1<Integer, Integer> multiplyByTwo = a -> a * 2;
    Function1<Integer, Integer> add1AndMultiplyBy2 = plusOne.andThen(multiplyByTwo);
    // should be equal to 6
    add1AndMultiplyBy2.apply(2);
    //another way of composition
    Function1<Integer, Integer> add1Multiply2compose = multiplyByTwo.compose(plusOne);
    // should be 6 as well
    add1Multiply2compose.apply(2);

    /************** lifting ****************** */
    // in mathematics, partial function is f:x' -> y, where x' is a subset of x. which means that
    // only for some subset of x function f will transform x to y. for other values, it wont transform.
    // ie, partial function works only for some values of x, for other values it might throw exception ( java terminology).
    Function2<Integer, Integer, Integer> divide = (a, b) -> a / b;
    Function2<Integer, Integer, Option<Integer>> safeDivide = Function2.lift(divide);

    //Option is similar to optional in java with some more vavr functionality.
    // gives some(2)
    Option<Integer> resultNormal = safeDivide.apply(4, 2);
    // gives none
    Option<Integer> resultError = safeDivide.apply(4,0);

    Function2<Integer, Integer, Option<Integer>> positiveSum = Function2.lift(FunctionExperiment::sum);
    //gives sum
    Option<Integer> sumSuccess = positiveSum.apply(4,5);
    //gives none
    Option<Integer> sumFailure = positiveSum.apply(-1,5);
  }

  /**
   * returns sum for positive numbers only. else throws IllegalArgumentException
   * @param a
   * @param b
   * @return
   */
  static int sum (int a, int b){
    if(a <0 || b <0){
      throw new IllegalArgumentException("negative numbers");
    }
    return a+b;
  }
}
