package pl.tomwodz.musicforum.services;

import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.model.Thread;
import pl.tomwodz.musicforum.model.Topic;

import java.util.List;

public interface IForumRetriever {

    List<Topic> findTopicAll();

    List<Thread> findThreadByTopicId(Long id);

    List<Post> findPostByThreadId(Long id);

}
