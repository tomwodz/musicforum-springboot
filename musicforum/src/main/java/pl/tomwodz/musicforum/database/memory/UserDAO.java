package pl.tomwodz.musicforum.database.memory;

import org.springframework.stereotype.Repository;
import pl.tomwodz.musicforum.database.IUserDAO;
import pl.tomwodz.musicforum.database.sequence.IUserIdSequence;
import pl.tomwodz.musicforum.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO implements IUserDAO {

    private final IUserIdSequence userIdSequence;

    private final List<User> useres = new ArrayList<>();

    public UserDAO(IUserIdSequence userIdSequence) {
        this.useres.add(new User(userIdSequence.getId(), "admin", "21232f297a57a5a743894a0e4a801fc3", "Tomek","Wodzinski", "twodzinski@op.pl", User.Role.ADMIN));
        this.useres.add(new User(userIdSequence.getId(), "tomasz", "2df8ce7d317c7d89dfa95be7695d2de0", "Tomek","Wodzinski","twodzinski@op.pl", User.Role.USER));
        this.userIdSequence = userIdSequence;
    }

    @Override
    public User getUserByLogin(String login) {
        for(User user : this.useres){
            if(user.getLogin().equals(login))
            {return User.copyOf(user);}
        }
        return null;
    }

    @Override
    public User getUserById(int idUser) {
        for(User user : this.useres){
            if(user.getIdUser() == idUser)
            {return User.copyOf(user);}
        }
        return null;
    }

    @Override
    public void persistUser(User user) {
        user.setIdUser(userIdSequence.getId());
        this.useres.add(user);
    }
}
