package com.google.gwtorm.client;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class StringKey<P extends Key<?>>
    implements Key<P>, Serializable, Comparable<StringKey<?>> {
  public abstract String get();

  protected abstract void set(String newValue);

  @Override
  public P getParentKey() {
    return null;
  }

  @Override
  public int hashCode() {
    int hc = get() != null ? get().hashCode() : 0;
    if (getParentKey() != null) {
      hc *= 31;
      hc += getParentKey().hashCode();
    }
    return hc;
  }

  @Override
  public boolean equals(final Object b) {
    if (b == null || get() == null || b.getClass() != getClass()) {
      return false;
    }

    final StringKey<P> q = cast(b);
    return get().equals(q.get()) && KeyUtil.eq(getParentKey(), q.getParentKey());
  }

  @Override
  public int compareTo(final StringKey<?> other) {
    return get().compareTo(other.get());
  }

  @Override
  public String toString() {
    final StringBuffer r = new StringBuffer();
    if (getParentKey() != null) {
      r.append(getParentKey().toString());
      r.append(',');
    }
    r.append(KeyUtil.encode(get()));
    return r.toString();
  }

  @Override
  public void fromString(final String in) {
    set(KeyUtil.parseFromString(getParentKey(), in));
  }

  @SuppressWarnings("unchecked")
  private static <A extends Key<?>> StringKey<A> cast(final Object b) {
    return (StringKey<A>) b;
  }
}
