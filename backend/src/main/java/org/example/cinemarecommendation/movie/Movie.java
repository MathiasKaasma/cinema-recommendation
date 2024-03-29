package org.example.cinemarecommendation.movie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Movie {
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

    private String title;
    private String genre;
    private int ageRating;
    private LocalDateTime startTime;
    private String language;
    private double rating;
    private double suggestion;

    public Movie(String title, String genre, int ageRating, LocalDateTime startTime, String language, double rating, double suggestion) {
        this.title = title;
        this.genre = genre;
        this.ageRating = ageRating;
        this.startTime = startTime;
        this.language = language;
        this.rating = rating;
        this.suggestion = suggestion;
    }

}
