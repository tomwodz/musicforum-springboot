package pl.tomwodz.musicforum.repository;

import org.springframework.data.repository.Repository;
import pl.tomwodz.musicforum.model.Topic;

import java.util.List;
import java.util.Optional;

public interface ITopicRepository extends Repository<Topic, Long> {
    List<Topic> findAll();

    Optional<Topic> findById(Long id);

    Topic save(Topic topic);
}
