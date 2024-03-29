package org.example.cinemarecommendation.movie;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomMovieRepository {
    List<Movie> findByFilters(String title, String genre, Integer ageRating, LocalDateTime startTime, String language, Double rating, Double suggestion);
}
