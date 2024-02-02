package com.lalsz.coursemongodb.config;

import com.lalsz.coursemongodb.domain.User;
import com.lalsz.coursemongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User caleb = new User(null, "Caleb Williams", "caleb@email.com");
        User maye = new User(null, "Drake Maye", "maye@email.com");
        User daniels = new User(null, "Jayden daniels", "daniels@email.com");

        userRepository.saveAll(Arrays.asList(caleb, maye, daniels));
    }
}
