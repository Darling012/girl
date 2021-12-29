package com.base.innerClass;
//在这个类中，包含两个内部类 Test1 和 Test2。其中，类Test1继承了类Example1，类Test2继承了类Example2。这样，类MainExample 就拥有了 类Example1 和 类Example2 的方法，也就间接地实现了多继承
public class moreExtends {
    //父类Example1
    public class Example1 {
        public String name() {
            return "rico";
        }
    }

    //父类Example2
    public class Example2 {
        public int age() {
            return 25;
        }
    }

    //实现多重继承的效果

        //内部类Test1继承类Example1
        private class Test1 extends Example1 {
            public String name() {
                return super.name();
            }
        }

        //内部类Test2继承类Example2
        private class Test2 extends Example2 {
            public int age() {
                return super.age();
            }
        }

        public String name() {
            return new Test1().name();
        }

        public int age() {
            return new Test2().age();
        }


    public static void main(String args[]) {
        moreExtends mexam = new moreExtends();
        System.out.println("姓名:" + mexam.name());
        System.out.println("年龄:" + mexam.age());
    }
    /* Output:
        姓名:rico
        年龄:25
 *///:~
}
