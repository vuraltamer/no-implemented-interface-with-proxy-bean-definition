package com.proxybean.main.proxy;

import com.proxybean.main.proxy.annotation.Animal;
import com.proxybean.main.proxy.annotation.Bark;

import java.lang.reflect.Proxy;

public class AnimalAnnotationProxy {

    public static <T> T createProxy(Class<T> type) {
        Animal animal = type.getAnnotation(Animal.class);
        return (T) Proxy.newProxyInstance(
                type.getClassLoader(),
                new Class[]{type},
                (proxy, method, args) -> {
                    if (method.isAnnotationPresent(Bark.class)) {
                        return method.getAnnotation(Bark.class).value();
                    }
                    return animal.doSomething();
                }
        );
    }
}