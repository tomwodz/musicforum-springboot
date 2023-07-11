package pl.tomwodz.musicforum.repository;

import org.springframework.data.repository.Repository;
import pl.tomwodz.musicforum.model.Thread;

import java.util.List;

public interface IThreadRepository extends Repository <Thread, Long> {

    List<Thread> findByTopicId(Long id);

}
