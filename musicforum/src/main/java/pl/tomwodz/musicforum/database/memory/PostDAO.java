package pl.tomwodz.musicforum.database.memory;

import org.springframework.stereotype.Repository;
import pl.tomwodz.musicforum.database.IPostDAO;
import pl.tomwodz.musicforum.database.IUserDAO;
import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.services.ITopicService;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class PostDAO implements IPostDAO {

    private final ITopicService topicService;
    private final IUserDAO userDAO;


    public PostDAO(ITopicService topicService, IUserDAO userDAO) {
        this.topicService = topicService;
        this.userDAO = userDAO;
    }

    @Override
    public List<Post> getAllPostsOfTopic(int idTopic) {
        List<Post> listPosts = new ArrayList<>(this.topicService.getTopicById(idTopic).getTopicPosts());
        for(Post post : listPosts){
            post.setAuthorPost(userDAO.getUserById(post.getIdUserAuthorOfPost()).getLogin());
        }
        return listPosts;
    }

    @Override
    public List<Post> getAllPostsOfTopicToDelete(int idTopic) {
        return this.topicService.getTopicById(idTopic).getTopicPosts();
    }

    @Override
    public void persistPostOfTopic(int idTopic, Post post) {
        post.setDateCreation(ZonedDateTime.now());
        this.topicService.getTopicById(idTopic).getTopicPosts().add(post);
    }

    @Override
    public void deletePost(int idTopic, int idPost) {
        Iterator<Post> iterator = this.getAllPostsOfTopicToDelete(idTopic).iterator();
        while(iterator.hasNext()){
            if(iterator.next().getIdPost() == idPost){
                iterator.remove();
                return;
            }
        }
    }
}
