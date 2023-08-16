package pl.tomwodz.musicforum.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.tomwodz.musicforum.repository.IPostRepository;
import pl.tomwodz.musicforum.services.IForumDeleter;

@Service
@Log4j2
@AllArgsConstructor
@Transactional
public class ForumDeleter implements IForumDeleter {

    private final IPostRepository postRepository;
    @Override
    public void deletePostById(Long id) {
        this.postRepository.deleteById(id);
    }
}
