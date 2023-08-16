package pl.tomwodz.musicforum.services;

import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.model.Thread;
import pl.tomwodz.musicforum.model.Topic;

import java.util.List;

public interface IForumRetriever {

    List<Topic> findAll();

    List<Thread> findByTopicId(Long id);

    List<Post> findByThreadId(Long id);

}
