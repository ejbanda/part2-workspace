/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import com.javatunes.billing.EuropeTax;
import com.javatunes.billing.Location;
import com.javatunes.billing.OnlineTax;
import com.javatunes.billing.TaxCalculator;
import com.javatunes.billing.USATax;
import java.util.Collection;

public class Order {
  private final String id;
  private double totalCost;
  private Location location;
  
  public Order(String id) {
    this.id = id;
  }

  public Order(String id, Location location){
    this(id);
    setLocation(location);
  }
  
  /**
   * DONE:
   * get the items from the cart and iterate over them, print each item's product code
   * get cart total and print
   */
  public void processCart(ShoppingCart<? extends Product> cart) {
    System.out.println("Order: " + getId() + " contains the following:");
    
    Collection<? extends Product> cartItems = cart.allItems();
    for (Product product : cartItems) {
      System.out.println(product.getCode());
    }
    totalCost = cart.total() + getTax();
    System.out.println("Order Total: " + totalCost);
  }
  
  public String getId() {
    return id;
  }

  public double getTotalCost() {
    return totalCost;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public double getTax(){
    TaxCalculator calculator;
    if(location == Location.EUROPE){
      calculator = new EuropeTax();
    } else if (location == Location.USA){
      calculator = new USATax();
    } else {
      calculator = new OnlineTax();
    }
    return calculator.taxAmount(getTotalCost());
  }
}