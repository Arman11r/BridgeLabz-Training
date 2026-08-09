package com.greetings.greetingsapp.controller;

import com.greetings.greetingsapp.model.Greeting;
import com.greetings.greetingsapp.service.GreetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @PostMapping
    public Greeting createGreeting(@RequestBody Greeting greeting) {
        return greetingService.createGreeting(greeting);
    }

    @GetMapping
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable Long id) {
        Greeting greeting = greetingService.getGreetingById(id);
        if (greeting == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(greeting);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGreeting(@PathVariable Long id) {
        boolean deleted = greetingService.deleteGreeting(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}