package com.base.innerClass;
//对客户端而言，我们可以通过 Example 的getInnerInstance()方法得到一个InterfaceTest 实例，但我们并不知道这个实例是如何实现的，也感受不到对应的具体实现类的存在。由于 InnerClass 是 private 的，所以，我们如果不看源代码的话，连实现这个接口的具体类的名字都看不到，所以说内部类可以很好的实现隐藏。
//测试接口
public interface InterfaceTest {
    public void test();
}

//外部类
 class Example {

    //内部类
    private class InnerClass implements InterfaceTest {
        @Override
        public void test() {
            System.out.println("I am Rico.");
        }
    }

    //外部类方法
    public InterfaceTest getInnerInstance(){
        return new InnerClass();
    }
}

//客户端
 class Client {
    public static void main(String[] args) {
        Example ex = new Example();
        InterfaceTest test = ex.getInnerInstance();
        test.test();
    }
}/* Output:
        I am Rico.
 *///:~
