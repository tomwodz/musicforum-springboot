package pl.tomwodz.musicforum.services;

import pl.tomwodz.musicforum.exception.LoginAlreadyExistException;
import pl.tomwodz.musicforum.model.User;

public interface IAuthenticationService {
    void authenticate(String login, String password);

    void logout();
    void register(User user) throws LoginAlreadyExistException;


}
