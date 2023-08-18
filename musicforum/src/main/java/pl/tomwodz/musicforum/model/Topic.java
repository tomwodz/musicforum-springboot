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
@Table(name = "ttopic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User author;

    private String title;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
    private List<Thread> threads;

    public Topic(Long id) {
        this.id = id;
    }
}
