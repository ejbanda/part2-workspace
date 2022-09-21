package com.javatunes.personnel;

import static org.junit.Assert.*;

import java.sql.Date;
import org.junit.Before;
import org.junit.Test;

public class SalariedEmployeeTest {

  private SalariedEmployee emp;

  @Before
  public void setUp(){
    emp = new SalariedEmployee("Art Vandelay", new Date(120, 2, 1), 69000.0);
  }

  @Test
  public void testPay() {
    assertEquals(69000, emp.pay(), 0.001);
  }

  @Test
  public void testPayTaxes() {
    assertEquals(20700, emp.payTaxes(), 0.001);
  }
}