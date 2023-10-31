package com.proxybean.main.services;

import com.proxybean.main.proxy.annotation.Animal;
import com.proxybean.main.proxy.annotation.Bark;
import org.springframework.stereotype.Component;

@Animal(doSomething = "dog eat meal")
@Component
public interface DogService {
    String eat();

    @Bark("dog is barking")
    String bark();
}