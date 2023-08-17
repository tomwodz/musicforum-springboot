package pl.tomwodz.musicforum.services;

import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.model.Thread;
import pl.tomwodz.musicforum.model.Topic;

public interface IForumUpdater {
    void updatePostById(Long id, Post newPost);
    void updateThreadById(Long id, Thread newThread);
    void updateTopicById(Long id, Topic newTopic);
}
