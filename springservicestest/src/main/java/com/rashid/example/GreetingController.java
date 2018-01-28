package com.rashid.example;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private StringRedisTemplate reditsTemplte;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        for (int i = 0; i<1000; i++) {
            System.out.println("loadtest");
        }
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/redistest")
    public String storeInfo(){
        int counter = 0;
        ValueOperations<String, String> ops = this.reditsTemplte.opsForValue();
        String key = "redis.counter";
        if (!this.reditsTemplte.hasKey(key)) {
            ops.set(key,Integer.toString(counter));
            System.out.println("key not found");
        } else {
            counter = Integer.parseInt(ops.get(key));
            counter++;
            ops.set(key,Integer.toString(counter));
            System.out.println("key found: " + counter);
        }
        return ops.get(key);
    }

}


