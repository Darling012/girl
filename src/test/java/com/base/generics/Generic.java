package com.base.generics;

import java.util.List;

/**
 * @author Darling
 */
public class Generic<T> {
    private T t;
    // this can not referenced from a static context
    // static T a;

    private void set(T t) {
        this.t = t;
    }

    private T get() {
        return t;
    }

    public static void main(String[] args) {
        // do nothing
    }

    /**
     * 不指定类型
     */
    public void noSpecifyType() {
        Generic generic = new Generic();
        generic.set("test");
        // 需要强制类型转换
        String test = (String) generic.get();
        System.out.println(test);
    }

    /**
     * 指定类型
     */
    public void specifyType() {
        Generic<String> glmapperGeneric = new Generic();
        glmapperGeneric.set("test");
        // 不需要强制类型转换
        String test = glmapperGeneric.get();
        System.out.println(test);

    }

    // 类型通配符
    public void test(List<?> c) {
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c);
        }
    }
}
