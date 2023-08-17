package pl.tomwodz.musicforum.services;

import pl.tomwodz.musicforum.model.Post;

public interface IForumUpdater {
    void updateById(Long id, Post newPost);
}
