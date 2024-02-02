package com.lalsz.coursemongodb.config;

import com.lalsz.coursemongodb.domain.Post;
import com.lalsz.coursemongodb.domain.User;
import com.lalsz.coursemongodb.dto.AuthorDTO;
import com.lalsz.coursemongodb.dto.CommentDTO;
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

        userRepository.saveAll(Arrays.asList(caleb, maye, daniels));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Broncos", "Vou jogar nos Broncos", new AuthorDTO(caleb));
        Post post2 = new Post(null, sdf.parse("22/03/2018"), "Partiu Commanders", "Vou jogar nos Commanders", new AuthorDTO(maye));

        CommentDTO comm1 = new CommentDTO("Let's ride! ", sdf.parse("23/03/2018"), new AuthorDTO(daniels));
        CommentDTO comm2 = new CommentDTO("Boa sorte! ", sdf.parse("23/03/2018"), new AuthorDTO(maye));
        CommentDTO comm3 = new CommentDTO("Let's go! ", sdf.parse("23/03/2018"), new AuthorDTO(daniels));

        post1.getComments().addAll(Arrays.asList(comm1, comm2));
        post2.getComments().add(comm3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        caleb.getPosts().add(post1);
        maye.getPosts().add(post2);
        userRepository.saveAll(Arrays.asList(caleb, maye));


    }
}
