package com.proxybean.main.services;

import com.proxybean.main.proxy.annotation.Animal;

@Animal(doSomething = "cat drink milk")
public interface CatService {
    String drink();
}