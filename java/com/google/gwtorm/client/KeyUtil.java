package com.google.gwtorm.client;

public class KeyUtil {
  private static Encoder ENCODER_IMPL;

  public static void setEncoderImpl(final Encoder e) {
    ENCODER_IMPL = e;
  }

  public static <T extends Key<?>> boolean eq(final T a, final T b) {
    if (a == b) {
      return true;
    }
    if (a == null || b == null) {
      return false;
    }
    return a.equals(b);
  }

  public static String encode(final String e) {
    return ENCODER_IMPL.encode(e);
  }

  public static String decode(final String e) {
    return ENCODER_IMPL.decode(e);
  }

  public static String parseFromString(final Key<?> parent, final String in) {
    final int comma = in.lastIndexOf(',');
    if (comma < 0 && parent == null) {
      return decode(in);
    }
    if (comma < 0 && parent != null) {
      throw new IllegalArgumentException("Not enough components: " + in);
    }
    assert (parent != null);
    parent.fromString(in.substring(0, comma));
    return decode(in.substring(comma + 1));
  }

  public abstract static class Encoder {
    public abstract String encode(String e);

    public abstract String decode(String e);
  }

  private KeyUtil() {}
}
