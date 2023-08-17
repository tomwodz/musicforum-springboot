package pl.tomwodz.musicforum.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pl.tomwodz.musicforum.model.Thread;

import java.util.List;
import java.util.Optional;

public interface IThreadRepository extends Repository <Thread, Long> {

    List<Thread> findByTopicIdOrderByIdDesc(Long id);

    Thread save(Thread thread);
    Optional<Thread> findById(Long id);

    @Modifying
    void deleteById(Long id);

    @Modifying
    @Query("UPDATE Thread th SET th.title = :#{#newThread.title} WHERE th.id = :id")
    void updateById(Long id, Thread newThread);
}
