package com.proxybean.main.controller;

import com.proxybean.main.services.CatService;
import com.proxybean.main.services.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/animal")
@RequiredArgsConstructor
public class AnimalController {
    private final CatService catService;
    private final DogService dogService;

    @GetMapping(value = "/dog/eat")
    public String eat() {
        return dogService.eat();
    }

    @GetMapping(value = "/dog/bark")
    public String bark() {
        return dogService.bark();
    }

    @GetMapping(value = "/cat/drink")
    public String drink() {
        return catService.drink();
    }
}