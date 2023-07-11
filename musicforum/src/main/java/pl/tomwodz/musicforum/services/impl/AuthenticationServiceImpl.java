package pl.tomwodz.musicforum.services.impl;

import jakarta.annotation.Resource;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import pl.tomwodz.musicforum.database.IUserDAO;
import pl.tomwodz.musicforum.exception.LoginAlreadyExistException;
import pl.tomwodz.musicforum.model.User;
import pl.tomwodz.musicforum.services.IAuthenticationService;
import pl.tomwodz.musicforum.session.SessionData;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

   IUserDAO userDAO;

    @Resource
    SessionData sessionData;

    public AuthenticationServiceImpl(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void authenticate(String login, String password) {
        User user = this.userDAO.getUserByLogin(login);
        if (user != null && user.getPassword().equals(DigestUtils.md5Hex(password))) {
            user.setPassword(null);
            this.sessionData.setUser(user);
        }
    }
    @Override
    public void logout() {
        this.sessionData.setUser(null);
    }

    @Override
    public void register(User user) throws LoginAlreadyExistException {
        if (this.userDAO.getUserByLogin(user.getLogin()) != null) {
            throw new LoginAlreadyExistException();
        }
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        this.userDAO.persistUser(user);
    }
}
