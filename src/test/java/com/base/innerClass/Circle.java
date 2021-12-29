package com.base.innerClass;
// 成员内部类
// 编译器在进行编译的时候，会将成员内部类单独编译成一个字节码文件
// 虽然我们在定义的内部类的构造器是无参构造器，编译器还是会默认添加一个参数，该参数的类型为指向外部类对象的一个引用，

// 成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）。
// 当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，即默认情况下访问的是成员内部类的成员。
// 外部类中如果要访问成员内部类的成员，必须先创建一个成员内部类的对象，再通过指向这个对象的引用来访问
// 如果要创建成员内部类的对象，前提是必须存在一个外部类的对象,也正是由于这个原因，成员内部类也不能含有 static 的变量和方法
// 内部类可以拥有private访问权限、protected访问权限、public访问权限及包访问权限。
// 外部类只能被public和包访问两种权限修饰。
public class Circle {
    // double radius = 0;
    static int a = 1;
    int b = 2;
    // public Circle(double radius) {
    //     this.radius = radius;
    // }
    //

    public Circle() {
        getDrawInstance().drawSahpe();   //必须先创建成员内部类的对象，再进行访问
    }

    private Draw getDrawInstance() {
        return new Draw();
    }
   private void innerClassField(){
        System.out.println(getDrawInstance().d);
   }
    class Draw {      //内部类
        int a = 3;
        int d = 4;
        public void drawSahpe() {
            System.out.println("drawshape");
            System.out.println(Circle.this.a);
            System.out.println(b);
            System.out.println(a);
        }

    }
    public static void main(String[] args){
       Circle circle = new Circle();
        Draw draw = circle.new Draw();
      //  draw.drawSahpe();

        circle.innerClassField();
    }
}
