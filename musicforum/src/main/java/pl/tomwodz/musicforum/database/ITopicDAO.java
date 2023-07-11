package pl.tomwodz.musicforum.database;

import org.springframework.stereotype.Component;
import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.model.Topic;

import java.util.List;

@Component
public interface ITopicDAO {
    List<Topic> getAllTopic();
    int persistTopic(Topic topic);
    Topic getTopicById(int idTopic);

    void deleteTopic(int idTopic);
}
