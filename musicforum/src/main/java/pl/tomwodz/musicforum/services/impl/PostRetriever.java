package pl.tomwodz.musicforum.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.repository.IPostRepository;
import pl.tomwodz.musicforum.services.IPostRetriever;

import java.util.List;

@Service
@AllArgsConstructor
public class PostRetriever implements IPostRetriever {

    private final IPostRepository postRepository;

    @Override
    public List<Post> findByPostId(Long id) {
        return this.postRepository.findByThreadId(id);
    }
}
