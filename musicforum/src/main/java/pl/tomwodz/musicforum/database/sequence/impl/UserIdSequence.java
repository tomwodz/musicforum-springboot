package pl.tomwodz.musicforum.database.sequence.impl;

import org.springframework.stereotype.Component;
import pl.tomwodz.musicforum.database.sequence.IUserIdSequence;

@Component
public class UserIdSequence implements IUserIdSequence {
    private int id;
    @Override
    public int getId() {
        return ++id;
    }
}
