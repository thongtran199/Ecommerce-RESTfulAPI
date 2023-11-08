package com.thong.databaseMysql.controller.authentication;


import com.thong.databaseMysql.domain.dto.authentication.UserDto;
import com.thong.databaseMysql.domain.entities.UserEntity;
import com.thong.databaseMysql.mappers.impl.UserMapper;
import com.thong.databaseMysql.services.UserService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log
@RestController
public class UserController {
    private UserService userService;
    private UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;

    }

    @PostMapping(path = "/user")
    public ResponseEntity<UserDto> postAuthor(@RequestBody final UserDto userDto) {
        UserEntity author = userMapper.mapFrom(userDto);
        UserEntity savedAuthor = userService.save(author);
        return new ResponseEntity<>(userMapper.mapTo(savedAuthor), HttpStatus.CREATED);
    }

    @GetMapping(path = "/user")
    public List<UserDto> getMapping() {
        List<UserEntity> authors = userService.findAll();
        return authors.stream()
                .map(entity -> userMapper.mapTo(entity))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<UserDto> getMappingId(@PathVariable("id") Integer id) {
        Optional<UserEntity> foundAuthor = userService.findOne(id);
        return foundAuthor.map(entity -> {
            UserDto userDto = userMapper.mapTo(entity);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping(path = "/user/{id}")
    public ResponseEntity<UserDto> putMapping(@PathVariable("id") Integer id,
                                              @RequestBody UserDto userDto)
    {
        if(!userService.isExist(id))
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        UserEntity author = userMapper.mapFrom(userDto);
        author.setId(id.intValue());
        UserEntity savedAuthor = userService.save(author);
        return new ResponseEntity<>(userMapper.mapTo(savedAuthor), HttpStatus.OK);
    }
}
