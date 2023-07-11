package pl.tomwodz.musicforum.database;

import org.springframework.stereotype.Component;
import pl.tomwodz.musicforum.model.Post;

import java.util.List;

@Component
public interface IPostDAO {
    List<Post> getAllPostsOfTopic(int idTopic);

    List<Post> getAllPostsOfTopicToDelete(int idTopic);

    void persistPostOfTopic(int idTopic, Post post);

    void deletePost(int idTopic, int idPost);
}
