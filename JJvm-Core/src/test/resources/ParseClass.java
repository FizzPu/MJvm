package com.mx.jvm;

/**
 * @author FizzPu
 * @since 2023/10/18 14:20
 */
public class ParseClass {
  private int a;

  public int add(int a, int b) {
    int c = a + b;
    return c;
  }

  public String inc(int b) {
    int a = b + 1;
    Object c = new Object();
    return c.toString();
  }

   public static int testJump(int a, int b) {
        if (a > b) {
            return 1;
        }
        return 0;
   }

   public static void main() {
       int a = 1;
       int b = 2;
       int c = a + b;
       ParseClass parseClass = new ParseClass();
   }
}
