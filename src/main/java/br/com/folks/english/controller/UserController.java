package br.com.folks.english.controller;

import br.com.folks.english.model.User;
import br.com.folks.english.repo.UserRepo;
import br.com.folks.english.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepo repo;

    @GetMapping("/login")
    public ResponseEntity<User> login(
            @RequestParam("username") String username) {

        User user =
                service.login(username);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {

        List<User> lista =
                repo.findAll();

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

}
