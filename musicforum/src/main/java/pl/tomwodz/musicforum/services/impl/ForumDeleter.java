package pl.tomwodz.musicforum.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.repository.IPostRepository;
import pl.tomwodz.musicforum.repository.IThreadRepository;
import pl.tomwodz.musicforum.services.IForumDeleter;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
@Transactional
public class ForumDeleter implements IForumDeleter {

    private final IPostRepository postRepository;
    private final IThreadRepository threadRepository;
    @Override
    public void deletePostById(Long id) {

        this.postRepository.deleteById(id);
    }

    @Override
    public void deleteThreadByIdAndDeletePostsByThreadId(Long id) {
        List<Post> postToDelete = this.postRepository.findByThreadId(id);
        postToDelete.stream()
                .forEach(p -> postRepository.deleteById(p.getId()));
        this.threadRepository.deleteById(id);
    }
}
