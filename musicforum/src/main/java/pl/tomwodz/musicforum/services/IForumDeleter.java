package pl.tomwodz.musicforum.services;

public interface IForumDeleter {
    void deletePostById(Long id);

    void deleteThreadByIdAndDeletePostsByThreadId(Long id);

    void deleteTopicByIdAndThreadsByTopicIdAndDeletePostsByThreadId(Long id);
}
