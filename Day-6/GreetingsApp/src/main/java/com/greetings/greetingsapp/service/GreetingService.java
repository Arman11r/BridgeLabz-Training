package com.greetings.greetingsapp.service;

import com.greetings.greetingsapp.model.Greeting;
import com.greetings.greetingsapp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting createGreeting(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id).orElse(null);
    }

    public boolean deleteGreeting(Long id) {
        if (!greetingRepository.existsById(id)) {
            return false;
        }
        greetingRepository.deleteById(id);
        return true;
    }
}