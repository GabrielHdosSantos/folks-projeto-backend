package br.com.folks.english.repo;

import br.com.folks.english.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findUserByLogin(String login);

    User findUserByLoginAndPassword(String login, String password);
}
