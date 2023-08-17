package pl.tomwodz.musicforum.services.impl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.model.Thread;
import pl.tomwodz.musicforum.model.Topic;
import pl.tomwodz.musicforum.repository.IPostRepository;
import pl.tomwodz.musicforum.repository.IThreadRepository;
import pl.tomwodz.musicforum.repository.ITopicRepository;
import pl.tomwodz.musicforum.services.IForumRetriever;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class ForumRetriever implements IForumRetriever {

    private final ITopicRepository topicRepository;
    private final IThreadRepository threadRepository;
    private final IPostRepository postRepository;
    @Override
    public List<Topic> findTopicAll() {
        return this.topicRepository.findAll();
    }

    @Override
    public List<Thread> findThreadByTopicId(Long id) {
        return this.threadRepository.findByTopicIdOrderByIdDesc(id);
    }

    @Override
    public List<Post> findPostByThreadId(Long id) {
        return this.postRepository.findByThreadId(id);
    }
    @Override
    public Optional<Post> findPostById(Long id) {
        return this.postRepository.findById(id);
    }

    @Override
    public Optional<Thread> findThreadById(Long id) {
        return this.threadRepository.findById(id);
    }

    @Override
    public Optional<Topic> findTopicById(Long id) {
        return this.topicRepository.findById(id);
    }
}
