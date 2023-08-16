package pl.tomwodz.musicforum.services;

import pl.tomwodz.musicforum.model.Post;
import pl.tomwodz.musicforum.model.Thread;
import pl.tomwodz.musicforum.model.Topic;

public interface IForumAdder {

    Topic addTopic(Topic topic);

   Thread addThread(Thread thread);

   Post addPost(Post post);



}
