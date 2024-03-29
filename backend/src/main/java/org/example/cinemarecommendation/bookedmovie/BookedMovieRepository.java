package org.example.cinemarecommendation.bookedmovie;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookedMovieRepository extends JpaRepository<BookedMovie, Long> {
    List<BookedMovie> findByUserId(Long userId);
}
