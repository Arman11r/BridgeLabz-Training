package com.greetings.greetingsapp.repository;

import com.greetings.greetingsapp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {
    // That's it. JpaRepository already gives you:
    //   findAll(), findById(id), save(greeting), deleteById(id), existsById(id), count(), etc.
    // Spring generates the implementation at runtime - no InMemory... class needed.
}