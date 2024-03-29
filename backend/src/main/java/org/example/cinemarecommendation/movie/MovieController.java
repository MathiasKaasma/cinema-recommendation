package org.example.cinemarecommendation.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("filter")
    public List<Movie> getFilteredMovies(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Integer ageRating,
            @RequestParam(required = false) LocalDateTime startTime,
            @RequestParam(required = false) String language,
            @RequestParam(required = false) Double rating,
            @RequestParam(required = false) Double suggestion
    ) {
        if (ageRating == null) {
            ageRating = 0;
        }
        if (rating == null) {
            rating = 0.0;
        }
        if (suggestion == null) {
            suggestion = 0.0;
        }
        return movieService.getFilteredMovies(title, genre, ageRating, startTime, language, rating, suggestion);
    }
}