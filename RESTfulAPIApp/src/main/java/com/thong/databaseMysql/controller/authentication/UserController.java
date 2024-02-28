package com.thong.databaseMysql.controller.authentication;


import com.thong.databaseMysql.domain.dto.authentication.UserDto;
import com.thong.databaseMysql.domain.dto.registerAccount.PostBodyRegisterNewAccount;
import com.thong.databaseMysql.domain.entities.CartEntity;
import com.thong.databaseMysql.domain.entities.UserEntity;
import com.thong.databaseMysql.mappers.impl.UserMapper;
import com.thong.databaseMysql.services.CartService;
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
    private CartService cartService;
    private UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper, CartService cartService) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.cartService = cartService;

    }

    @PostMapping(path = "/user/customerRegister")
    public ResponseEntity<UserDto> postCustomerRegister(@RequestBody final PostBodyRegisterNewAccount postBodyRegisterNewAccount) {

        UserEntity user = UserEntity.builder()
                .image(postBodyRegisterNewAccount.getImage())
                .shipState(postBodyRegisterNewAccount.getShipState())
                .shipCity(postBodyRegisterNewAccount.getShipCity())
                .shipState(postBodyRegisterNewAccount.getShipState())
                .fullName(postBodyRegisterNewAccount.getFullName())
                .username(postBodyRegisterNewAccount.getUsername())
                .email(postBodyRegisterNewAccount.getEmail())
                .telNumber(postBodyRegisterNewAccount.getTelNumber())
                .build();
        user.setAuthorities("ROLE_CUSTOMER");
        user.setIsActive(true);
        user.setPassword("{noop}"+postBodyRegisterNewAccount.getPassword());

        UserEntity savedUser = userService.save(user);
        if(savedUser != null)
        {
            CartEntity cartEntity = CartEntity.builder()
                    .userEntity(savedUser)
                    .quantity(0)
                            .build();
            CartEntity savedCart = cartService.save(cartEntity);
            if(savedCart!=null)
            {
                return new ResponseEntity<>(userMapper.mapTo(savedUser), HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>(userMapper.mapTo(savedUser), HttpStatus.BAD_REQUEST);
    }
    @PostMapping(path = "/user/adminAddUser")
    public ResponseEntity<UserDto> postAdminAddUser(@RequestBody final PostBodyRegisterNewAccount postBodyRegisterNewAccount) {
        UserEntity user = UserEntity.builder()
                .image(postBodyRegisterNewAccount.getImage())
                .shipState(postBodyRegisterNewAccount.getShipState())
                .shipAddress(postBodyRegisterNewAccount.getShipAddress())
                .shipCity(postBodyRegisterNewAccount.getShipCity())
                .shipState(postBodyRegisterNewAccount.getShipState())
                .fullName(postBodyRegisterNewAccount.getFullName())
                .username(postBodyRegisterNewAccount.getUsername())
                .email(postBodyRegisterNewAccount.getEmail())
                .telNumber(postBodyRegisterNewAccount.getTelNumber())
                .build();
        user.setAuthorities("ROLE_ADMIN");
        user.setIsActive(true);
        user.setPassword("{noop}"+postBodyRegisterNewAccount.getPassword());
        UserEntity savedUser = userService.save(user);
        return new ResponseEntity<>(userMapper.mapTo(savedUser), HttpStatus.CREATED);
    }

    @GetMapping(path = "/user")
    public List<UserDto> getMapping() {
        List<UserEntity> authors = userService.findAllByIsActiveTrue();
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
    @GetMapping(path = "/lockUser/{id}")
    public ResponseEntity<UserDto> lockUser(@PathVariable("id") Integer id) {
        Optional<UserEntity> foundAuthor = userService.findOne(id);
        if(foundAuthor.isEmpty())
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
        UserEntity userEntity = foundAuthor.get();
        userEntity.setIsActive(false);
        UserEntity lockedUser = userService.save(userEntity);
        return new ResponseEntity<>(userMapper.mapTo(lockedUser), HttpStatus.OK);

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
