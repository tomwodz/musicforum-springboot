package pl.tomwodz.musicforum.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Topic {
    private int idTopic;
    private String topicTitle;
    private List<Post> topicPosts;
}
