package br.com.folks.english.service;

import br.com.folks.english.model.User;
import br.com.folks.english.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (repo.findUserByLogin(username) == null) {
            throw new UsernameNotFoundException(username + "Não existe!");
        } else
            return repo.findUserByLogin(username);
    }

    public User login(String username, String password) {
        return repo.findUserByLoginAndPassword(username, password);

    }


}
