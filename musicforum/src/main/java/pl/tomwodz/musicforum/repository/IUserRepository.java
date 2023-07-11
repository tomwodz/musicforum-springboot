package pl.tomwodz.musicforum.repository;

import org.springframework.data.repository.Repository;
import pl.tomwodz.musicforum.model.User;

import java.util.Optional;

public interface IUserRepository extends Repository<User, Long> {
    Optional<User> findByLogin(String login);
    void save(User user);
}
