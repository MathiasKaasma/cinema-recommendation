package org.example.cinemarecommendation.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

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
}
