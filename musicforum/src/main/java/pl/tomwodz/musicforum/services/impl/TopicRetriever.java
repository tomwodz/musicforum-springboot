package pl.tomwodz.musicforum.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tomwodz.musicforum.model.Topic;
import pl.tomwodz.musicforum.repository.ITopicRepository;
import pl.tomwodz.musicforum.services.ITopicRetriever;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TopicRetriever implements ITopicRetriever {

    private final ITopicRepository topicRepository;
    @Override
    public List<Topic> findAll() {
        return this.topicRepository.findAll();
    }

    @Override
    public Optional<Topic> findById(Long id) {
        return this.topicRepository.findById(id);
    }
}
