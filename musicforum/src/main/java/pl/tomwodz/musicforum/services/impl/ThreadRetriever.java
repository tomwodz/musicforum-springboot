package pl.tomwodz.musicforum.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tomwodz.musicforum.model.Thread;
import pl.tomwodz.musicforum.repository.IThreadRepository;
import pl.tomwodz.musicforum.services.IThreadRetriever;

import java.util.List;

@Service
@AllArgsConstructor
public class ThreadRetriever implements IThreadRetriever {

    private final IThreadRepository threadRepository;
    @Override
    public List<Thread> findByTopicId(Long id) {
        return this.threadRepository.findByTopicId(id);
    }
}
