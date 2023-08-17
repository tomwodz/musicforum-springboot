package pl.tomwodz.musicforum.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.repository.IPostRepository;
import pl.tomwodz.musicforum.services.IForumUpdater;

@Service
@AllArgsConstructor
@Log4j2
@Transactional
public class ForumUpdater implements IForumUpdater {

    private final IPostRepository postRepository;

    @Override
    public void updateById(Long id, Post newPost) {
        this.postRepository.updateById(id, newPost);
    }
}
