package org.example.cinemarecommendation.bookedmovie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class BookedMovie {
    @Id
    @SequenceGenerator(
            name = "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )
    private Long id;

    private Long userId;
    private Long movieId;
    private String genre;

    public BookedMovie(Long movieId, String genre, Long userId) {
        this.movieId = movieId;
        this.genre = genre;
        this.userId = userId;
    }
}
