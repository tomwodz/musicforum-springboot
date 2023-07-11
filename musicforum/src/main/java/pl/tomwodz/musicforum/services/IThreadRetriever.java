package pl.tomwodz.musicforum.services;

import pl.tomwodz.musicforum.model.Thread;

import java.util.List;

public interface IThreadRetriever {

    List<Thread> findByTopicId(Long id);

}
