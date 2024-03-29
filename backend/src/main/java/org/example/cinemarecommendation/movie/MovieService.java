package org.example.cinemarecommendation.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> getFilteredMovies(String title, String genre, int ageRating, LocalDateTime startTime, String language, double rating, double suggestion) {
        return movieRepository.findByFilters(title, genre, ageRating, startTime, language, rating, suggestion);
    }

    // Implement additional methods for movie-related business logic
}
