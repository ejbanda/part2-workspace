package com.entertainment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TelevisionTest {

  private Television tv;

  //default channel is 3
  @Before
  public void setUp(){
    tv = new Television("Sony", 55, DisplayType.OLED);
  }

  @Test
  public void testSetVolume() {
    assertEquals(55,tv.getVolume());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetVolumeIllegalArgumentException(){
    tv.setVolume(Television.MAX_VOLUME + 350);
  }

  @Test
  public void testChangeChannel() {
    try{
      tv.changeChannel(69);
      assertEquals(69,tv.getCurrentChannel());
    }
    catch(InvalidChannelException e) {
      fail("Shouldn't have thrown InvalidChannelException");
    }
  }

  @Test
  public void testChangeChannelInvalidChannelException(){
    try{
      tv.changeChannel(1000);
      fail("Should of thrown InvalidChannelException");
    }
    catch(InvalidChannelException e) {
      assertEquals(3, tv.getCurrentChannel());
    }
  }

  @Test
  public void testCompareTo() {
    Television tv2 = new Television("Samsung");
    assertTrue(tv.compareTo(tv2) > 0);
  }

  @Test
  public void testHashCode() {
    Television tv2 = new Television("Sony", 55, DisplayType.OLED);
    assertEquals(tv.hashCode(), tv2.hashCode());
    Television tv3 = new Television("Sony", 0 ,DisplayType.OLED);
    assertNotEquals(tv.hashCode(), tv3.hashCode());
  }

  @Test
  public void testEquals() {
    Television tv2 = new Television("Sony", 55, DisplayType.OLED);
    assertEquals(tv,tv2);
    Television tv3 = new Television("Sony", 55, DisplayType.PLASMA);
    assertNotEquals(tv,tv3);
  }
}