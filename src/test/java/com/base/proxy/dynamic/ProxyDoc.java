// package dynamic.proxy;
//
// import sun.misc.ProxyGenerator;
//
// import java.lang.reflect.Constructor;
// import java.lang.reflect.InvocationHandler;
// import java.lang.reflect.InvocationTargetException;
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Set;
//
// /**
//  * @program: proxy
//  * @description: Proxy里方法注释
//  * @author: Darling
//  * @create: 2019-10-18 11:16
//  **/
// public class ProxyDoc {
//     /**
//  * loader:类加载器
//  * interfaces:目标对象实现的接口
//  * h:InvocationHandler的实现类
//  */
// public static Object newProxyInstance(ClassLoader loader,
//                       Class<?>[] interfaces,
//                       InvocationHandler h)
//     throws IllegalArgumentException
//     {
//     if (h == null) {
//         throw new NullPointerException();
//     }
//
//     /*
//      * Look up or generate the designated proxy class.
//      */
//     Class cl = getProxyClass(loader, interfaces);
//
//     /*
//      * Invoke its constructor with the designated invocation handler.
//      */
//     try {
//             // 调用代理对象的构造方法（也就是$Proxy0(InvocationHandler h)）
//         Constructor cons = cl.getConstructor(constructorParams);
//             // 生成代理类的实例并把MyInvocationHandler的实例传给它的构造方法
//         return (Object) cons.newInstance(new Object[] { h });
//     } catch (NoSuchMethodException e) {
//         throw new InternalError(e.toString());
//     } catch (IllegalAccessException e) {
//         throw new InternalError(e.toString());
//     } catch (InstantiationException e) {
//         throw new InternalError(e.toString());
//     } catch (InvocationTargetException e) {
//         throw new InternalError(e.toString());
//     }
//     }
//
//     public static Class<?> getProxyClass(ClassLoader loader,
//                                          Class<?>... interfaces)
//     throws IllegalArgumentException
//     {
//     // 如果目标类实现的接口数大于65535个则抛出异常（我XX，谁会写这么NB的代码啊？）
//     if (interfaces.length > 65535) {
//         throw new IllegalArgumentException("interface limit exceeded");
//     }
//
//     // 声明代理对象所代表的Class对象（有点拗口）
//     Class proxyClass = null;
//
//     String[] interfaceNames = new String[interfaces.length];
//
//     Set interfaceSet = new HashSet();   // for detecting duplicates
//
//     // 遍历目标类所实现的接口
//     for (int i = 0; i < interfaces.length; i++) {
//
//         // 拿到目标类实现的接口的名称
//         String interfaceName = interfaces[i].getName();
//         Class interfaceClass = null;
//         try {
//         // 加载目标类实现的接口到内存中
//         interfaceClass = Class.forName(interfaceName, false, loader);
//         } catch (ClassNotFoundException e) {
//         }
//         if (interfaceClass != interfaces[i]) {
//         throw new IllegalArgumentException(
//             interfaces[i] + " is not visible from class loader");
//         }
//
//         // 中间省略了一些无关紧要的代码 .......
//
//         // 把目标类实现的接口代表的Class对象放到Set中
//         interfaceSet.add(interfaceClass);
//
//         interfaceNames[i] = interfaceName;
//     }
//
//     // 把目标类实现的接口名称作为缓存（Map）中的key
//     Object key = Arrays.asList(interfaceNames);
//
//     Map cache;
//
//     synchronized (loaderToCache) {
//         // 从缓存中获取cache
//         cache = (Map) loaderToCache.get(loader);
//         if (cache == null) {
//         // 如果获取不到，则新建地个HashMap实例
//         cache = new HashMap();
//         // 把HashMap实例和当前加载器放到缓存中
//         loaderToCache.put(loader, cache);
//         }
//
//     }
//
//     synchronized (cache) {
//
//         do {
//         // 根据接口的名称从缓存中获取对象
//         Object value = cache.get(key);
//         if (value instanceof Reference) {
//             proxyClass = (Class) ((Reference) value).get();
//         }
//         if (proxyClass != null) {
//             // 如果代理对象的Class实例已经存在，则直接返回
//             return proxyClass;
//         } else if (value == pendingGenerationMarker) {
//             try {
//             cache.wait();
//             } catch (InterruptedException e) {
//             }
//             continue;
//         } else {
//             cache.put(key, pendingGenerationMarker);
//             break;
//         }
//         } while (true);
//     }
//
//     try {
//         // 中间省略了一些代码 .......
//
//         // 这里就是动态生成代理对象的最关键的地方
//         byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
//             proxyName, interfaces);
//         try {
//             // 根据代理类的字节码生成代理类的实例
//             proxyClass = defineClass0(loader, proxyName,
//             proxyClassFile, 0, proxyClassFile.length);
//         } catch (ClassFormatError e) {
//             throw new IllegalArgumentException(e.toString());
//         }
//         }
//         // add to set of all generated proxy classes, for isProxyClass
//         proxyClasses.put(proxyClass, null);
//
//     }
//     // 中间省略了一些代码 .......
//
//     return proxyClass;
//     }
// }
