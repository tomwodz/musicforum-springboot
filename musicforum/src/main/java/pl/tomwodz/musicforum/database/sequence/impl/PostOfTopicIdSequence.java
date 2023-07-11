package pl.tomwodz.musicforum.database.sequence.impl;

import org.springframework.stereotype.Component;
import pl.tomwodz.musicforum.database.sequence.IPostOfTopicIdSequence;

@Component
public class PostOfTopicIdSequence implements IPostOfTopicIdSequence {
    private int id;
    @Override
    public int getId() {
        return ++id;
    }

}
