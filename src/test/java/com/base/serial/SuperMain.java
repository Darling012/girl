package com.base.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <see https://johnfrod.top/%E5%AE%89%E5%85%A8/java%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E6%BC%8F%E6%B4%9E-%E5%9F%BA%E7%A1%80%E7%AF%87/>
 */
public class SuperMain {
    private static final String FILE_PATH = "H:\\111.txt";

    public static void main(String[] args) throws Exception {
        serializeAnimal();
        deserializeAnimal();
    }

    private static void serializeAnimal() throws Exception {
        BlackCat black = new BlackCat("black", "我是黑猫");
        System.out.println("序列化前："+black.toString());
        System.out.println("=================开始序列化================");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
        oos.writeObject(black);
        oos.flush();
        oos.close();
    }

    private static void deserializeAnimal() throws Exception {
        System.out.println("=================开始反序列化================");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
        BlackCat black = (BlackCat) ois.readObject();
        ois.close();
        System.out.println(black);
    }
}
