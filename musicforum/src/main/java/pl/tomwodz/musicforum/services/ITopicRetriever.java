package pl.tomwodz.musicforum.services;

import pl.tomwodz.musicforum.model.Topic;

import java.util.List;
import java.util.Optional;

public interface ITopicRetriever {
    List<Topic> findAll();

    Optional<Topic> findById(Long id);

}
