package br.com.folks.english.controller;

import br.com.folks.english.model.User;
import br.com.folks.english.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public ResponseEntity<User> login(@PathVariable ("username")String username, @PathVariable("password") String password){
        User user = service.login(username, password);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
