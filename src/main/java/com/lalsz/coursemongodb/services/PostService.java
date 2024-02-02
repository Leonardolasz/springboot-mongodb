package com.lalsz.coursemongodb.services;

import com.lalsz.coursemongodb.domain.Post;
import com.lalsz.coursemongodb.domain.User;
import com.lalsz.coursemongodb.repository.PostRepository;
import com.lalsz.coursemongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Post findById(String id) {
        Optional<Post> optionalUser = postRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new ObjectNotFoundException("object not found");
        }
        return optionalUser.get();
    }
}