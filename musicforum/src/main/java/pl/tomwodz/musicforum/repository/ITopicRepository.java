package pl.tomwodz.musicforum.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pl.tomwodz.musicforum.model.Topic;

import java.util.List;
import java.util.Optional;

public interface ITopicRepository extends Repository<Topic, Long> {
    List<Topic> findAll();
    Optional<Topic> findById(Long id);
    Topic save(Topic topic);
    @Modifying
    void deleteById(Long id);

    @Modifying
    @Query("UPDATE Topic t SET t.title = :#{#newTopic.title} WHERE t.id = :id")
    void updateById(Long id, Topic newTopic);
}
