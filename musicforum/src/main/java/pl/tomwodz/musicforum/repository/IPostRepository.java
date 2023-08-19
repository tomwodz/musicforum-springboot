package pl.tomwodz.musicforum.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pl.tomwodz.musicforum.model.Post;

import java.util.List;
import java.util.Optional;

public interface IPostRepository extends Repository<Post, Long> {
    List<Post> findByThreadId(Long id);

    List<Post> findAll();

    Optional<Post> save(Post post);
    Optional<Post> findById(Long id);

    @Modifying
    void deleteById(Long id);
    @Modifying
    @Query("UPDATE Post p SET p.content = :#{#newPost.content}, p.dateUpdated= :#{#newPost.dateUpdated} WHERE p.id = :id")
    void updateById(Long id, Post newPost);
}
