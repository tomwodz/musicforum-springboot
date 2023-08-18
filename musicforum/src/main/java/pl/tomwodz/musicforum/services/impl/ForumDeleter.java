package pl.tomwodz.musicforum.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.model.Thread;
import pl.tomwodz.musicforum.repository.IPostRepository;
import pl.tomwodz.musicforum.repository.IThreadRepository;
import pl.tomwodz.musicforum.repository.ITopicRepository;
import pl.tomwodz.musicforum.services.IForumDeleter;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
@Transactional
public class ForumDeleter implements IForumDeleter {

    private final IPostRepository postRepository;
    private final IThreadRepository threadRepository;
    private final ITopicRepository topicRepository;
    @Override
    public void deletePostById(Long id) {
        log.info("! deleted post by id: " + id);
        this.postRepository.deleteById(id);
    }

    @Override
    public void deleteThreadByIdAndDeletePostsByThreadId(Long id) {
        log.info("!! deleted thread by id: " + id);
        List<Post> postsToDelete = this.postRepository.findByThreadId(id);
        postsToDelete.stream()
                .forEach(p -> postRepository.deleteById(p.getId()));
        this.threadRepository.deleteById(id);
    }

    @Override
    public void deleteTopicByIdAndThreadsByTopicIdAndDeletePostsByThreadId(Long id) {
        log.info("!!! deleted topic by id: " + id);
        List<Thread> threadsToDelete = this.threadRepository.findByTopicIdOrderByIdDesc(id);
        threadsToDelete.stream()
                .forEach(th-> deleteThreadByIdAndDeletePostsByThreadId(th.getId()));
        this.topicRepository.deleteById(id);
    }
}
