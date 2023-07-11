package pl.tomwodz.musicforum.database.sequence.impl;

import org.springframework.stereotype.Component;
import pl.tomwodz.musicforum.database.sequence.ITopicIdSequence;

@Component
public class TopicIdSequence implements ITopicIdSequence {

    private int id;
    @Override
    public int getId() {
        return ++id;
    }

}
