package pl.tomwodz.musicforum.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "tthread")
public class Thread {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    private Topic topic;

    @ManyToOne
    private User author;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "thread")
    private List<Post> posts;

    public Thread(Long id) {
        this.id = id;
    }
}
