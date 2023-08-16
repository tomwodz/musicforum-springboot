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
import pl.tomwodz.musicforum.services.IForumAdder;

@Service
@AllArgsConstructor
@Transactional
@Log4j2
public class ForumAdder implements IForumAdder {

    private final ITopicRepository topicRepository;
    private final IThreadRepository threadRepository;
    private final IPostRepository postRepository;

    @Override
    public Topic addTopic(Topic topic) {
        log.info("adding new topic: " + topic.getTitle());
        return this.topicRepository.save(topic);
    }
    @Override
    public Thread addThread(Thread thread) {
        return this.threadRepository.save(thread);
    }

    @Override
    public Post addPost(Post post) {
        return this.postRepository.save(post);
    }
}
