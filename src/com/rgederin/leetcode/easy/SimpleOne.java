package com.rgederin.leetcode.easy;

import java.util.Collection;
import java.util.Objects;

public class SimpleOne {
  private int i;
  private Collection<String> strings;
  
  public SimpleOne() {
  }
  
  public SimpleOne(int i, Collection<String> strings) {
    this.i = i;
    this.strings = strings;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SimpleOne simpleOne = (SimpleOne) o;
    return i == simpleOne.i &&
            strings.equals(simpleOne.strings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(i, strings);
  }

  public void setI(int i) {
  	this.i = i;
  }
  
  public int getI() {
  	return i;
  }
  
  public void setStrings(Collection<String> strings) {
  	this.strings = strings;
  }
  
  public Collection<String> getStrings() {
  	return strings;
  }
}