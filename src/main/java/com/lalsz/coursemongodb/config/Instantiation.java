package com.lalsz.coursemongodb.config;

import com.lalsz.coursemongodb.domain.Post;
import com.lalsz.coursemongodb.domain.User;
import com.lalsz.coursemongodb.repository.PostRepository;
import com.lalsz.coursemongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.task.TaskSchedulingProperties;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User caleb = new User(null, "Caleb Williams", "caleb@email.com");
        User maye = new User(null, "Drake Maye", "maye@email.com");
        User daniels = new User(null, "Jayden daniels", "daniels@email.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Broncos", "Vou jogar nos Broncos", caleb);
        Post post2 = new Post(null, sdf.parse("22/03/2018"), "Partiu Commanders", "Vou jogar nos Commanders", maye);

        userRepository.saveAll(Arrays.asList(caleb, maye, daniels));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
