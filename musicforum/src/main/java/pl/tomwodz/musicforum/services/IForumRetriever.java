package pl.tomwodz.musicforum.services;

import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.model.Thread;
import pl.tomwodz.musicforum.model.Topic;

import java.util.List;
import java.util.Optional;

public interface IForumRetriever {

    List<Topic> findTopicAll();

    List<Thread> findThreadByTopicId(Long id);

    List<Post> findPostByThreadId(Long id);

    List<Post> findPostsByCreatedDate(Long limit);

    Optional<Post> findPostById(Long id);

    Optional<Thread> findThreadById(Long id);

    Optional<Topic> findTopicById(Long id);
}
