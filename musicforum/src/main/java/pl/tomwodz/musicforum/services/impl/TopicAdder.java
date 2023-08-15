package pl.tomwodz.musicforum.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.tomwodz.musicforum.model.Topic;
import pl.tomwodz.musicforum.repository.ITopicRepository;
import pl.tomwodz.musicforum.services.ITopicAdder;

@Service
@AllArgsConstructor
@Transactional
@Log4j2
public class TopicAdder implements ITopicAdder {

    private final ITopicRepository topicRepository;
    @Override
    public Topic addTopic(Topic topic) {
        log.info("adding new topic: " + topic.getTitle());
        return this.topicRepository.save(topic);
    }
}
