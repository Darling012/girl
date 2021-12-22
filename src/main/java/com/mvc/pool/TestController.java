package com.mvc.pool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
public class TestController {
    // 3. 线程池中复制上下文
    @Autowired
    private Executor asyncServiceExecutor;

    @GetMapping("/setSession")
    public void setSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("name", "张三");
    }

    @GetMapping("/getSession")
    public void getSession() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        System.out.println("requestAttributes" + requestAttributes);
        if (requestAttributes != null) {
            // 从session中获取数据
            String name = (String) requestAttributes.getAttribute("name", RequestAttributes.SCOPE_SESSION);
            System.out.println("name0:" + name);

        }
        // ThreadPoolExecutor asyncServiceExecutor = new ThreadPoolExecutor(2, 2, 100, TimeUnit.SECONDS,new LinkedBlockingDeque());
        //2. 将主线程上下文信息共享给子线程，这样只需要写一遍，该线程下的所有子线程都会共享上下文数据
        // RequestContextHolder.setRequestAttributes(RequestContextHolder.getRequestAttributes(), true);
        asyncServiceExecutor.execute(() -> {
            System.out.println(Thread.currentThread()
                                     .getName());
            // 1. 第一种单独复制，这样每个都要写
            // RequestContextHolder.setRequestAttributes(requestAttributes);
            RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
            System.out.println("attributes:" + attributes);
            String name = (String) attributes.getAttribute("name", RequestAttributes.SCOPE_SESSION);
            System.out.println("name1:" + name);
        });
        asyncServiceExecutor.execute(() -> {
            System.out.println(Thread.currentThread()
                                     .getName());
            // 1. 第一种单独复制，这样每个都要写
            // RequestContextHolder.setRequestAttributes(requestAttributes);
            RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
            System.out.println("requestAttributes" + requestAttributes);
            String name = (String) attributes.getAttribute("name", RequestAttributes.SCOPE_SESSION);
            System.out.println("name2:" + name);
        });
    }
}
