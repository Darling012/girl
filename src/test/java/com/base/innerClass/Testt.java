package com.base.innerClass;

public class Testt {
    public static void main(String[] args)  {
        Testt t = new Testt();
        t.test(2);
    }
    int d = 4;
    public void test( int b) {
          int a = 1;
        int c = 3;
        new Thread(new Runnable() {
//              a =5;
            @Override
            public void run() {
                    // System.out.println(a);
                    // System.out.println(b);
                    // System.out.println(c);
                    // System.out.println(d);
            }
        }).start();
    }
}
