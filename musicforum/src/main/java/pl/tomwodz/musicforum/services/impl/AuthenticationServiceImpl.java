package pl.tomwodz.musicforum.services.impl;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import pl.tomwodz.musicforum.exception.LoginAlreadyExistException;
import pl.tomwodz.musicforum.model.User;
import pl.tomwodz.musicforum.repository.IUserRepository;
import pl.tomwodz.musicforum.services.IAuthenticationService;
import pl.tomwodz.musicforum.session.SessionData;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements IAuthenticationService {

   private final IUserRepository userRepository;

    @Resource
    SessionData sessionData;


    @Override
    public void authenticate(String login, String password) {
        Optional<User> userBox = this.userRepository.findByLogin(login);
        if (userBox.isPresent() && userBox.get().getPassword().equals(DigestUtils.md5Hex(password))) {
            userBox.get().setPassword(null);
            this.sessionData.setUser(userBox.get());
        }
    }
    @Override
    public void logout() {
        this.sessionData.setUser(null);
    }

    @Override
    public void register(User user) throws LoginAlreadyExistException {
        if (this.userRepository.findByLogin(user.getLogin()).isPresent()) {
            throw new LoginAlreadyExistException();
        }
        user.setRole(User.Role.USER);
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        this.userRepository.save(user);
    }
}
