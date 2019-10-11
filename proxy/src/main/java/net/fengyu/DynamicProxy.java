package net.fengyu;

import net.fengyu.proxy.Developer;
import net.fengyu.proxy.JavaDeveloper;

import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main( String[] args ) {
        Developer farmerbrag = new JavaDeveloper("Farmerbrag");

        Developer farmerbragProxy = (Developer)Proxy.newProxyInstance(farmerbrag.getClass().getClassLoader(),
                farmerbrag.getClass().getInterfaces(),(proxy, method, argss) -> {
                    if(method.getName().equals("code")) {
                        System.out.println("Farmerbrag is praying for the code!");
                        return method.invoke(farmerbrag, argss);
                    } else if(method.getName().equals("debug")) {
                        System.out.println("Farmerbrag's code is bug-free and does not require debugging");
                        return null;
                    }
                    return null;
                });
        farmerbragProxy.code();
        farmerbragProxy.debug();
    }
}
