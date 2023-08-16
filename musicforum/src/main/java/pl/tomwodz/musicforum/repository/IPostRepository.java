package pl.tomwodz.musicforum.repository;

import org.springframework.data.repository.Repository;
import pl.tomwodz.musicforum.model.Post;

import java.util.List;

public interface IPostRepository extends Repository<Post, Long> {
    List<Post> findByThreadId(Long id);
    Post save(Post post);

}
