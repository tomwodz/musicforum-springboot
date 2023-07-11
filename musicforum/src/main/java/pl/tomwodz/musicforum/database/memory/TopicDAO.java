package pl.tomwodz.musicforum.database.memory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.tomwodz.musicforum.database.ITopicDAO;
import pl.tomwodz.musicforum.database.sequence.IPostOfTopicIdSequence;
import pl.tomwodz.musicforum.database.sequence.ITopicIdSequence;
import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.model.Topic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Repository
public class TopicDAO implements ITopicDAO {

    private final List<Topic> topics = new ArrayList<>();
   private final ITopicIdSequence topicIdSequence;


    public TopicDAO(@Autowired ITopicIdSequence topicIdSequence, @Autowired IPostOfTopicIdSequence postOfTopicIdSequence) {
        this.topicIdSequence = topicIdSequence;
        this.topics.add(new Topic(topicIdSequence.getId(), "Witaj na forum muzycznym!", new ArrayList<Post>()));
    }

    @Override
    public List<Topic> getAllTopic() {
        return new ArrayList<>(this.topics);
    }

    @Override
    public Topic getTopicById(int idTopic) {
        for(Topic topic: this.topics){
            if(topic.getIdTopic() == idTopic){
                return  topic;
            }
        }
        return null;
    }

    @Override
    public int persistTopic(Topic topic) {
        topic.setIdTopic(topicIdSequence.getId());
        topic.setTopicPosts(new ArrayList<Post>());
        this.topics.add(topic);
        return topic.getIdTopic();
    }

    @Override
    public void deleteTopic(int idTopic) {
        Iterator<Topic> iterator = this.topics.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getIdTopic() == idTopic){
                iterator.remove();
                return;
            }
        }
    }
}
