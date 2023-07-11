package pl.tomwodz.musicforum.services;

import pl.tomwodz.musicforum.model.Topic;

import java.util.List;

public interface ITopicService {
    List<Topic> getAllTopic();

    int persistTopic(Topic topic);

    Topic getTopicById(int idTopic);

    void deleteTopic(int idTopic);
}
