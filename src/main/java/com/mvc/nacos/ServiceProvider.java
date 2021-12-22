package com.mvc.nacos;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.List;
import java.util.Properties;

/**
 * @program: girl
 * @version:
 * @author: ling
 * @createTime: 2021-11-26 10:28
 **/
public class ServiceProvider {
    public static void main(String[] args) throws NacosException {
        Properties properties = new Properties();
        properties.setProperty("serverAddr", "192.168.215.100:8848");
        properties.setProperty("namespace", "local");
        NamingService naming = NamingFactory.createNamingService(properties);
        naming.registerInstance("providerOne", "192.168.216.125", 20081,"master");
        naming.registerInstance("providerOne", "192.168.216.125", 20082,"master");
        List<Instance> instances =naming.getAllInstances("providerOne");
        System.out.println(instances);

    }
}
