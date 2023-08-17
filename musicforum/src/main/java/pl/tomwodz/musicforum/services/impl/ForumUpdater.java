package pl.tomwodz.musicforum.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.model.Thread;
import pl.tomwodz.musicforum.model.Topic;
import pl.tomwodz.musicforum.repository.IPostRepository;
import pl.tomwodz.musicforum.repository.IThreadRepository;
import pl.tomwodz.musicforum.repository.ITopicRepository;
import pl.tomwodz.musicforum.services.IForumUpdater;

@Service
@AllArgsConstructor
@Log4j2
@Transactional
public class ForumUpdater implements IForumUpdater {

    private final IPostRepository postRepository;
    private final IThreadRepository threadRepository;
    private final ITopicRepository topicRepository;

    @Override
    public void updatePostById(Long id, Post newPost) {
        this.postRepository.updateById(id, newPost);
    }
    @Override
    public void updateThreadById(Long id, Thread newThread) {
        this.threadRepository.updateById(id, newThread);
    }
    @Override
    public void updateTopicById(Long id, Topic newTopic) {
        this.topicRepository.updateById(id, newTopic);
    }

}
