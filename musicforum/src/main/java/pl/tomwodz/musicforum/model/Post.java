package pl.tomwodz.musicforum.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "tpost")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne
    private Thread thread;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime dateCreated;

    @Column(nullable = false)
    private LocalDateTime dateUpdated;

    public String getDateCreateFormatted(){
        return this.dateCreated.format(
                DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
    }
    public String getDateUpdatedFormatted(){
        return this.dateUpdated.format(
                DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
    }
}
