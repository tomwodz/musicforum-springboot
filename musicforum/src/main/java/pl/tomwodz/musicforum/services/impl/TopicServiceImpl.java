package pl.tomwodz.musicforum.services.impl;

import org.springframework.stereotype.Service;
import pl.tomwodz.musicforum.database.ITopicDAO;
import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.model.Topic;
import pl.tomwodz.musicforum.services.ITopicService;

import java.util.List;

@Service
public class TopicServiceImpl implements ITopicService {

    private final ITopicDAO topicDAO;

    public TopicServiceImpl(ITopicDAO topicDAO) {
        this.topicDAO = topicDAO;
    }

    @Override
    public List<Topic> getAllTopic() {
        return this.topicDAO.getAllTopic();
    }


    @Override
    public int persistTopic(Topic topic) {
        return this.topicDAO.persistTopic(topic);
    }

    @Override
    public Topic getTopicById(int idTopic) {
        return this.topicDAO.getTopicById(idTopic);
    }

    @Override
    public void deleteTopic(int idTopic) {
        this.topicDAO.deleteTopic(idTopic);
    }
}


