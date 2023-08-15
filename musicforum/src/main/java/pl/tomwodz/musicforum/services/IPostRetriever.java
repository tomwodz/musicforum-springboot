package pl.tomwodz.musicforum.services;

import pl.tomwodz.musicforum.model.Post;

import java.util.List;

public interface IPostRetriever {

    List<Post> findByThreadId(Long id);

}
