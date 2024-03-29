package org.example.cinemarecommendation.movie;

import org.example.cinemarecommendation.bookedmovie.BookedMovie;
import org.example.cinemarecommendation.bookedmovie.BookedMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final BookedMovieRepository bookedMovieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository, BookedMovieRepository bookedMovieRepository) {
        this.movieRepository = movieRepository;
        this.bookedMovieRepository = bookedMovieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> getFilteredMovies(String title, String genre, int ageRating, LocalDateTime startTime, String language, double rating, double suggestion) {
        List<Movie> movies = movieRepository.findByFilters(title, genre, ageRating, startTime, language, rating, suggestion);
        Map<String, Double> genrePreferences = calculateGenrePreferences(1L);

        // Sort movies by genre match and rating value
        movies.forEach(movie -> {
            double adjustedSuggestion = movie.getRating() + movie.getSuggestion() + genrePreferences.getOrDefault(movie.getGenre(), 0.0);
            movie.setSuggestion(adjustedSuggestion);
        });
        movies.sort((movie1, movie2) -> Double.compare(movie2.getSuggestion(), movie1.getSuggestion()));

        return movies;
    }

    public int[][] getSeats() {
        // Generate random seat values, 0 being empty and 1 being taken
        int rows = 7;
        int cols = 11;
        int[][] grid = new int[rows][cols];

        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = rand.nextInt(10) < 6 ? 1 : 0;
            }
        }

        // Find the most optimal available seat, changing value to a '2'
        int middleRow = rows / 2;
        int middleCol = cols / 2;

        int closestRow = middleRow;
        int closestCol = middleCol;
        int minDistance = Integer.MAX_VALUE;
        for (int d = 1; d < Math.max(rows, cols); d++) {
            for (int i = -d; i <= d; i++) {
                for (int j = -d; j <= d; j++) {
                    int row = middleRow + i;
                    int col = middleCol + j;
                    if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 0) {
                        int distance = Math.abs(row - middleRow) + Math.abs(col - middleCol);
                        if (distance < minDistance) {
                            minDistance = distance;
                            closestRow = row;
                            closestCol = col;
                        }
                    }
                }
            }
        }
        grid[closestRow][closestCol] = 2;

        return grid;
    }

    public BookedMovie addBookedMovie(Long movieId, Long userId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found!"));
        String genre = movie.getGenre();

        BookedMovie bookedMovie = new BookedMovie(movieId, genre, userId);
        return bookedMovieRepository.save(bookedMovie);
    }

    public Map<String, Double> calculateGenrePreferences(Long userId) {
        List<BookedMovie> userBookings = bookedMovieRepository.findByUserId(userId);
        Map<String, Double> genrePreferences = new HashMap<>();
        for (BookedMovie bookedMovie : userBookings) {
            String genre = bookedMovie.getGenre();
            genrePreferences.put(genre, genrePreferences.getOrDefault(genre, 0.0) + 0.1);
        }
        return genrePreferences;
    }
}
