package com.base.innerClass;
// 局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内。
// 局部内部类就像是方法里面的一个局部变量一样，是不能有public、protected、private以及static修饰符的。tip: test();
//
class People{
    public People() {}
    // private void test(){
    //    private int a = 0;  // Modifier 'public' not allowed here
    // }
}

class Man{
    public Man(){}
    int a = 1;
     public People getWoman(){
         int b = 2;
//        protected class Woman extends People{   //局部内部类
         class Woman extends People {   //局部内部类
             int age =0;

         }
         return new Woman();
     }
    public  void finalTest(){
        int c = 3;
         class A{
         void testA(){
             // System.out.println(c);
         }
        }
    }
}
