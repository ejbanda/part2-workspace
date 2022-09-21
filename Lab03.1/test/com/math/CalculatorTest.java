/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

  private final Calculator calc = new Calculator();


  @Test
  public void testAdd() {
    assertEquals(5, calc.add(1, 4));  // expected, actual
  }

  @Test
  public void testDivide(){
    assertEquals(2.5, calc.divide(5,2), 0.001);
  }

  @Test
  public void testIsEven(){
    assertTrue(calc.isEven(10));
  }
}