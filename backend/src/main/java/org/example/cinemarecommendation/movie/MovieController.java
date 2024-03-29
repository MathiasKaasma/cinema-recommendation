package org.example.cinemarecommendation.movie;

import org.example.cinemarecommendation.bookedmovie.BookedMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("all")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping()
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

    @GetMapping("seats")
    public int[][] getSeats() {
        return movieService.getSeats();
    }

    @PostMapping("booked")
    public ResponseEntity<BookedMovie> addBookedMovie(@RequestBody Map<String, Object> payload) {
        String movieIdString = (String) payload.get("movieId");
        Long movieId = Long.valueOf(movieIdString);
        Integer userIdString = (Integer) payload.get("userId");
        Long userId = Long.valueOf(userIdString);
        BookedMovie bookedMovie = movieService.addBookedMovie(movieId, userId);
        return new ResponseEntity<>(bookedMovie, HttpStatus.CREATED);
    }
}
