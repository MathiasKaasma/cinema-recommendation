package org.example.cinemarecommendation.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>, CustomMovieRepository {
    //List<Movie> findByFilters(String title, String genre, int ageRating, LocalDateTime startTime, String language, double rating, double suggestion);
//    @Query("SELECT m FROM Movie m WHERE "
//            + "(COALESCE(:title, '') = '' OR m.title = :title) AND "
//            + "(COALESCE(:genre, '') = '' OR m.genre = :genre) AND "
//            + "(:ageRating IS NULL OR m.ageRating = :ageRating) AND "
//            + "(:startTime IS NULL OR m.startTime = :startTime) AND "
//            + "(COALESCE(:language, '') = '' OR m.language = :language) AND "
//            + "(:rating IS NULL OR m.rating = :rating) AND "
//            + "(:suggestion IS NULL OR m.suggestion = :suggestion)")
//    List<Movie> findByFilters(@Param("title") String title,
//                              @Param("genre") String genre,
//                              @Param("ageRating") Integer ageRating,
//                              @Param("startTime") LocalDateTime startTime,
//                              @Param("language") String language,
//                              @Param("rating") Double rating,
//                              @Param("suggestion") Double suggestion);

}
