package com.base.io.encode;

/**
 * @program: base
 * @description: 字符到字节是编码
 * @author: ling
 * @create: 2020-03-01 18:11
 **/
public class EncodeDemo {
    public static void main(String[] args) throws Exception {
        String str = "慕课abc";
        byte[] byteDefault = str.getBytes();
        for (byte aByte : byteDefault) {
            // String toHexString(int i) 以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式。
            // 去除高8位
            System.out.print(Integer.toHexString(aByte & 0xff) + " ");
        }
        System.out.println();
        // gbk 中文占两个字节  英文占一个字节
        byte[] gbk = str.getBytes("gbk");
        for (byte b : gbk) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();
        // utf8 中文占三个字节 英文占一个字节
        byte[] utf8 = str.getBytes("utf-8");
        for (byte b : utf8) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();
        // java 是双字节编码 utf-16be 中文两个字节 英文两个字节
        byte[] utf16be = str.getBytes("utf-16be");
        for (byte b : utf16be) {
             System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();
        /*
         * 编解码字符集要一致
         */
        String noSame = new String(utf16be);
        System.out.println(noSame);
        String same = new String(utf16be,"utf-16be");
        System.out.println(same);
        /*
         * 文本文件 就是字节序列 可以是任意编码的字节序列
         * 如果我们在中文机器上直接创建文本文件，那么该文本文件只认识ansi编码
         * 联通 联是一种巧合 正好符合了utf8编码的规则
         */
    }
}
