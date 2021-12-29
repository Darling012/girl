package com.base.innerClass;

// 情形 1：匿名内部类直接使用其所在的外部类方法的参数 name
interface Inner {    //注释后，编译时提示类Inner找不到
    String getName();
}

public class Outer {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.getInner("Inner", "gz");
        System.out.println(inner.getName());
    }

    public Inner getInner(final String name, String city) {  // 形参 name 被设为 final
        return new Inner() {
            private String nameStr = name;       // OK
            // private String cityStr = city;       // Error: 形参 city 未被设为 final

            public String getName() {
                return nameStr;
            }
        };
    }
}
