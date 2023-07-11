package pl.tomwodz.musicforum.database;

import pl.tomwodz.musicforum.model.User;

public interface IUserDAO {
    User getUserByLogin(String login);
    User getUserById(int idUser);
    public void persistUser(User user);


}
