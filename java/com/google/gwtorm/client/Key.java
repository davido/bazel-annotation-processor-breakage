package com.google.gwtorm.client;

public interface Key<P extends Key<?>> {
  public P getParentKey();

  @Override
  public int hashCode();

  @Override
  public boolean equals(Object o);

  @Override
  public String toString();

  public void fromString(String in);
}
