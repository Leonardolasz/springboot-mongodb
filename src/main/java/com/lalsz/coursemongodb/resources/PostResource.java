package com.lalsz.coursemongodb.resources;

import com.lalsz.coursemongodb.domain.Post;
import com.lalsz.coursemongodb.domain.User;
import com.lalsz.coursemongodb.dto.UserDTO;
import com.lalsz.coursemongodb.services.PostService;
import com.lalsz.coursemongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
