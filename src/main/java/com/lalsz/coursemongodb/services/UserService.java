package com.lalsz.coursemongodb.services;

import com.lalsz.coursemongodb.domain.User;
import com.lalsz.coursemongodb.dto.UserDTO;
import com.lalsz.coursemongodb.repository.UserRepository;
import com.lalsz.coursemongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new ObjectNotFoundException("object not found");
        }
        return optionalUser.get();
    }

    public User insert(User obj) {
        return userRepository.insert(obj);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
