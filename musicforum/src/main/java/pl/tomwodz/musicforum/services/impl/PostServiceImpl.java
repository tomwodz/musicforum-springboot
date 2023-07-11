package pl.tomwodz.musicforum.services.impl;

import org.springframework.stereotype.Service;
import pl.tomwodz.musicforum.database.IPostDAO;
import pl.tomwodz.musicforum.database.sequence.IPostOfTopicIdSequence;
import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.model.User;
import pl.tomwodz.musicforum.services.IPostService;

import java.util.List;

@Service
public class PostServiceImpl implements IPostService {

    private final IPostDAO postDAO;
    private final IPostOfTopicIdSequence postOfTopicIdSequence;

    public PostServiceImpl(IPostDAO postDAO, IPostOfTopicIdSequence postOfTopicIdSequence) {
        this.postDAO = postDAO;
        this.postOfTopicIdSequence = postOfTopicIdSequence;
    }

    @Override
    public List<Post> gelAllPostsOfTopic(int idTopic) {
        return this.postDAO.getAllPostsOfTopic(idTopic);
    }

    @Override
    public void persistPostOfTopic(int idTopic, Post post, User user) {
        post.setIdPost(postOfTopicIdSequence.getId());
        post.setIdUserAuthorOfPost(user.getIdUser());
        postDAO.persistPostOfTopic(idTopic, post);
    }

    @Override
    public void deletePost(int idTopic, int idPost) {
        this.postDAO.deletePost(idTopic, idPost);
    }
}
