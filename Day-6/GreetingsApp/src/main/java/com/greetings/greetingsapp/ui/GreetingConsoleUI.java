package com.greetings.greetingsapp.ui;

import com.greetings.greetingsapp.model.Greeting;
import com.greetings.greetingsapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Component
public class GreetingConsoleUI implements CommandLineRunner {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final GreetingRepository greetingRepository;
    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    public GreetingConsoleUI(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public void run(String... args) {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    greetAndSave();
                    break;
                case "2":
                    listGreetings();
                    break;
                case "3":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("===== Greeting App =====");
        System.out.println("1. Get greeted");
        System.out.println("2. View all saved greetings");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    private void greetAndSave() {
        System.out.print("Hello! What's your name? ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name can't be empty.");
            return;
        }

        Greeting greeting = new Greeting(name);
        greetingRepository.save(greeting);

        System.out.println(greeting.getMessage());
        System.out.println("(saved at " + greeting.getTimestamp().format(FORMAT) + ")");
    }

    private void listGreetings() {
        List<Greeting> all = greetingRepository.findAll();

        if (all.isEmpty()) {
            System.out.println("No greetings saved yet.");
            return;
        }

        System.out.println("--- All Greetings ---");
        for (Greeting g : all) {
            System.out.println(g.getId() + ". " + g.getMessage() + "  [" + g.getTimestamp().format(FORMAT) + "]");
        }
    }
}