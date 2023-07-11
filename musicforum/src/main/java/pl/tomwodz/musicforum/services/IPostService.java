package pl.tomwodz.musicforum.services;

import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.model.User;

import java.util.List;

public interface IPostService {
    List<Post> gelAllPostsOfTopic(int idTopic);



    void persistPostOfTopic(int idTopic, Post post, User user);

    void deletePost(int idTopic, int idPost);


}
